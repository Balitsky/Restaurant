package service;

import dao.mysqlFactories.MySQLFactory;
import model.Order;

import java.util.List;

public class OrderService {

    public void addOrder(Order order){
        MySQLFactory.getInstance().getOrderDao()
                .addOrder(order);
    }

    public List<Order> getAllOrders(){
        return MySQLFactory.getInstance().getOrderDao()
                .getAllOrders();
    }

    public void confirmOrder(int idOrder){
        MySQLFactory.getInstance().getOrderDao()
                .confirmOrder(idOrder);
    }
}
