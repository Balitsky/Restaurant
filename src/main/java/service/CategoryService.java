package service;

import dao.mysqlFactories.MySQLFactory;
import model.Category;

import java.util.List;

public class CategoryService {
    public List<Category> getAllCategory(){
        return MySQLFactory.getInstance().getCategoryDao()
                .getAllCategory();
    }
}
