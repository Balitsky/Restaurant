package dao.mysqlFactories;

import dao.connection.DaoConnection;
import dao.connection.TransactionHelper;
import dao.DaoException;
import dao.factories.AccountProductDao;
import dao.factories.DaoFactory;
import dao.factories.ProductDao;
import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class AccountProductMySQL implements AccountProductDao {

    public Map<Product, Integer> getAllAccountProductsByOrder(int idOrder) {
        Map<Product, Integer> accountProduct = new HashMap<>();
        try(DaoConnection connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM account_product WHERE id_order = ?");
            statement.setInt(1, idOrder);
            ResultSet resultSet = statement.executeQuery();

            DaoFactory factory = MySQLFactory.getInstance();
            ProductDao productDao = factory.getProductDao();
            while (resultSet.next()) {
                Product product = productDao.getProduct(resultSet.getInt("id_product"));
                accountProduct.put(product, resultSet.getInt("quantity"));
            }
        } catch (SQLException e) {
            throw new DaoException("fail get all account products by order", e);
        }
        return accountProduct;
    }
}
