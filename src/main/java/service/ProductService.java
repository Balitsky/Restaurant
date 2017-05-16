package service;

import dao.mysqlFactories.MySQLFactory;
import model.Product;

import java.util.List;

public class ProductService {

    public List<Product> getAllProducts(){
        return MySQLFactory.getInstance().getProductDao()
                .getAllProducts();
    }

    public Product getProduct(Integer idProduct){
        return MySQLFactory.getInstance().getProductDao()
                .getProduct(idProduct);
    }

    public void addProduct(Product product){
        MySQLFactory.getInstance().getProductDao()
                .addProduct(product);
    }

    public List<Product> getProductsByCategory(Integer idCategory){
        return MySQLFactory.getInstance().getProductDao()
                .getProductsByCategory(idCategory);
    }
}
