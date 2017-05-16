package command.order;

import command.service.Command;
import dao.factories.CategoryDao;
import dao.factories.DaoFactory;
import dao.mysqlFactories.MySQLFactory;
import model.Category;
import page.Page;
import service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BackToMenuCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Category> list_categories = ServiceFactory.getInstance()
                .getCategoryService().getAllCategory();
        request.setAttribute("list_categories", list_categories);
        return Page.MENU.name();
    }
}
