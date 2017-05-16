package dao.mysqlFactories;

import dao.factories.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLFactory implements DaoFactory {
    private static MySQLFactory instance = new MySQLFactory();

    private AdminDao adminDao = new AdminMySQL();
    private CustomerDao customerDao = new CustomerMySQL();
    private AccountProductDao accountProductDao = new AccountProductMySQL();
    private ProductDao productDao = new ProductMySQL();
    private CategoryDao categoryDao = new CategoryMySQL();
    private OrderDao orderDao = new OrderMySQL();

    private MySQLFactory() {
    }

    public static MySQLFactory getInstance() {
        return instance;
    }

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public AccountProductDao getAccountProductDao() {
        return accountProductDao;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }
}
