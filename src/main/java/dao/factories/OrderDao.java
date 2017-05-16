package dao.factories;

import model.Order;

import java.util.List;

public interface OrderDao {
//    boolean addAccountProduct(Integer idProduct, Integer quantity);

    boolean addOrder(Order order);

    List<Order> getAllOrders();

    boolean confirmOrder(int idOrder);
}
