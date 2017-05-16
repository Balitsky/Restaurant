package dao.mysqlFactories;

import dao.connection.DaoConnection;
import dao.connection.TransactionHelper;
import dao.DaoException;
import dao.factories.CategoryDao;
import dao.factories.DaoFactory;
import dao.factories.ProductDao;
import model.Category;
import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryMySQL implements CategoryDao {

    public List<Category> getAllCategory() {
        List<Category> categories = new ArrayList<>();
        try(DaoConnection connection = TransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM category;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                categories.add(createCategory(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("fail get all category", e);
        }
        return categories;
    }

    private Category createCategory(ResultSet resultSet) throws SQLException {
        Category category = new Category();
        category.setIdCategory(resultSet.getInt("id_category"));
        category.setName(resultSet.getString("name"));
        DaoFactory factory = MySQLFactory.getInstance();
        ProductDao productDao = factory.getProductDao();
        List<Product> products = productDao.getProductsByCategory(category.getIdCategory());
        category.setProducts(products);
        return category;
    }
}
