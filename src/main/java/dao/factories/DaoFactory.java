package dao.factories;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory {

    AdminDao getAdminDao();

    CustomerDao getCustomerDao();

    AccountProductDao getAccountProductDao();

    ProductDao getProductDao();

    CategoryDao getCategoryDao();

    OrderDao getOrderDao();
}
