package dao.mysqlFactories;

import dao.connection.DaoConnection;
import dao.connection.TransactionHelper;
import dao.DaoException;
import dao.factories.AdminDao;
import model.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMySQL implements AdminDao {

    public Admin getAdmin(String login, String password) {
        Admin admin = null;
        try(DaoConnection connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM admin WHERE login = ? AND password = ?");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                admin = new Admin();
                admin.setLogin(resultSet.getString("login"));
                admin.setPassword(resultSet.getString("password"));
                admin.setIdAdmin(resultSet.getInt("id_admin"));
            }
        } catch (SQLException e) {
            throw new DaoException("fail get admin",e);
        }
        return admin;
    }
}
