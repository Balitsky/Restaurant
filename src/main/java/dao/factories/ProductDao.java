package dao.factories;

import model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAllProducts();

    Product getProduct(Integer idProduct);

    boolean addProduct(Product product);

    List<Product> getProductsByCategory(Integer idCategory);
}
