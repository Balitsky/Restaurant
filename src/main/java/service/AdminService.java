package service;

import dao.mysqlFactories.MySQLFactory;
import model.Admin;

public class AdminService {
    public Admin getAdmin(String login, String password){
        return MySQLFactory.getInstance().getAdminDao()
                .getAdmin(login, password);
    }
}
