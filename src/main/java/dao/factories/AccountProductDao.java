package dao.factories;

import model.Product;

import java.util.Map;

public interface AccountProductDao {
    Map<Product, Integer> getAllAccountProductsByOrder(int idOrder);
}
