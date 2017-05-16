package service;

import dao.factories.DaoFactory;
import dao.mysqlFactories.MySQLFactory;
import model.Product;

import java.util.Map;

public class AccountProductService {

    public Map<Product, Integer> getAllAccountProductsByOrder(int idOrder){
        return MySQLFactory.getInstance().getAccountProductDao()
                .getAllAccountProductsByOrder(idOrder);
    }
}
