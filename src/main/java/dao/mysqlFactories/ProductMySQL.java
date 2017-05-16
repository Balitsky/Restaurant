package dao.mysqlFactories;

import dao.connection.DaoConnection;
import dao.connection.TransactionHelper;
import dao.DaoException;
import dao.factories.ProductDao;
import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductMySQL implements ProductDao {

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (DaoConnection connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                products.add(createProduct(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("fail get all products", e);
        }
        return products;
    }

    public Product getProduct(Integer idProduct) {
        Product product = null;
        try (DaoConnection connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE id_product = ?");
            statement.setInt(1, idProduct);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                product = createProduct(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException("fail get product by id", e);
        }
        return product;
    }

    public boolean addProduct(Product product) {
        try (DaoConnection connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO product(name, amount, price, id_category) VALUES (?,?,?,?)");
            statement.setString(1, product.getName());
            statement.setInt(2, product.getAmount());
            statement.setInt(3, product.getPrice());
            statement.setInt(4, product.getIdCategory());
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException("fail add product", e);
        }
        return false;
    }

    public List<Product> getProductsByCategory(Integer idCategory) {
        List<Product> products = new ArrayList<>();
        try (DaoConnection connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE id_category = ?");
            statement.setInt(1, idCategory);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                products.add(createProduct(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("fail get products by category", e);
        }
        return products;
    }

    private Product createProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setIdProduct(resultSet.getInt("id_product"));
        product.setName(resultSet.getString("name"));
        product.setIdCategory(resultSet.getInt("id_category"));
        product.setAmount(resultSet.getInt("amount"));
        product.setPrice(resultSet.getInt("price"));
        return product;
    }
}
