package dao.mysqlFactories;


import dao.connection.DaoConnection;
import dao.connection.TransactionHelper;
import dao.DaoException;
import dao.factories.CustomerDao;
import model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerMySQL implements CustomerDao {

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (DaoConnection connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customers.add(createCustomer(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("fail get all customers", e);
        }
        return customers;
    }

    public Customer getCustomer(String login) {
        Customer customer = null;
        try (DaoConnection connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer WHERE login = ?");
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                customer = createCustomer(resultSet);
            }

        } catch (SQLException e) {
            throw new DaoException("fail get customer by login", e);
        }
        return customer;
    }

    public Customer getCustomer(int idCustomer) {
        Customer customer = null;
        try (DaoConnection connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer WHERE id_customer = ?");
            statement.setInt(1, idCustomer);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                customer = createCustomer(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException("fail get customer by id", e);
        }
        return customer;
    }

    public boolean addCustomer(Customer customer) {
        try (DaoConnection connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO customer (login, password, email, phone) VALUES (?,?,?,?)");
            statement.setString(1, customer.getLogin());
            statement.setString(2, customer.getPassword());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhone());
            statement.execute();
            return true;
        } catch (SQLException e) {
            throw new DaoException("fail add customer", e);
        }
    }

    public Customer getCustomer(String login, String password) {
        Customer customer = null;
        try (DaoConnection connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer WHERE login = ? AND password = ?;");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                customer = createCustomer(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException("fail get customer by login and password", e);
        }
        return customer;
    }

    private Customer createCustomer(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setIdCustomer(resultSet.getInt("id_customer"));
        customer.setLogin(resultSet.getString("login"));
        customer.setPassword(resultSet.getString("password"));
        customer.setEmail(resultSet.getString("email"));
        customer.setPhone(resultSet.getString("phone"));
        return customer;
    }
}
