package dao.factories;

import model.Admin;

public interface AdminDao {
    Admin getAdmin(String login, String password);
}
