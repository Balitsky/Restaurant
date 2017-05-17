package dao.mysqlFactories;

import dao.connection.DaoConnection;
import dao.connection.TransactionHelper;
import dao.DaoException;
import dao.factories.*;
import model.Customer;
import model.Order;
import model.Product;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OrderMySQL implements OrderDao {
private static Logger logger = Logger.getLogger(OrderDao.class);
    public boolean addOrder(Order order) {
        try (DaoConnection connection = TransactionHelper.getInstance().getConnection()) {
            TransactionHelper.getInstance().beginTransaction();
            logger.warn("open transaction");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO restaurant.order (total, id_customer) VALUES (?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, order.getTotal());
            statement.setInt(2, order.getCustomer().getIdCustomer());
            statement.execute();

            int idOrder = 0;
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) {
                idOrder = resultSet.getInt(1);
            }

            for (Entry<Product, Integer> entry : order.getAccountProduct().entrySet()) {
                statement = connection.prepareStatement("INSERT INTO restaurant.account_product (id_product, quantity, id_order) VALUES (?,?,?)");
                statement.setInt(1, entry.getKey().getIdProduct());
                statement.setInt(2, entry.getValue());
                statement.setInt(3, idOrder);
                statement.execute();
            }

            for (Entry<Product, Integer> entry : order.getAccountProduct().entrySet()) {
                int val = entry.getKey().getAmount() - entry.getValue();
                statement = connection.prepareStatement("UPDATE restaurant.product SET amount = ? WHERE id_product = ?;");
                statement.setInt(1, val);
                statement.setInt(2, entry.getKey().getIdProduct());
                statement.execute();
            }

            TransactionHelper.getInstance().commitTransaction();
            logger.warn("transaction closed");
        } catch (SQLException e) {
            TransactionHelper.getInstance().rollbackTransaction();
            throw new DaoException("fail add order transaction", e);
        }
        return false;
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        try (DaoConnection connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM restaurant.order");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders.add(createOrder(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("fail get all orders", e);
        }
        return orders;
    }

    public boolean confirmOrder(int idOrder) {
        try (DaoConnection connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE restaurant.order SET confirm = ? WHERE id_order = ?");
            statement.setBoolean(1, true);
            statement.setInt(2, idOrder);
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException("fail confirm order", e);
        }
        return false;
    }

    private Order createOrder(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        DaoFactory factory = MySQLFactory.getInstance();
        CustomerDao customerDao = factory.getCustomerDao();
        AccountProductDao accountProductDao = factory.getAccountProductDao();

        order.setIdOrder(resultSet.getInt("id_order"));
        order.setTotal(resultSet.getInt("total"));
        order.setConfirm(resultSet.getBoolean("confirm"));

        Customer customer = customerDao.getCustomer(resultSet.getInt("id_customer"));
        order.setCustomer(customer);

        Map<Product, Integer> accountProduct = accountProductDao.getAllAccountProductsByOrder(resultSet.getInt("id_order"));
        order.setAccountProduct(accountProduct);
        return order;
    }
}
