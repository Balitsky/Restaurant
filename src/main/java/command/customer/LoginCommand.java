package command.customer;

import command.service.Command;
import dao.factories.CategoryDao;
import dao.factories.CustomerDao;
import dao.factories.DaoFactory;
import dao.mysqlFactories.MySQLFactory;
import model.Category;
import model.Customer;
import page.Page;
import service.ServiceFactory;
import service.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");

        // when we wish to do another order or if the customer is already logged
        if (customer != null) {
            List<Category> list_categories = ServiceFactory.getInstance().getCategoryService()
                    .getAllCategory();
            request.setAttribute("list_categories", list_categories);
            if (session.getAttribute("items_count").equals(null)) {
                session.setAttribute("items_count", 0);
            }
            page = Page.MENU.name();
        } else {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            if (login != null && password != null && !login.isEmpty() && !password.isEmpty()){
                customer = ServiceFactory.getInstance().getCustomerService()
                        .getCustomer(login, password);
            }
            if (customer != null && password != null) {
                session.setAttribute("customer", customer);
                session.setAttribute("items_count", 0);
                List<Category> list_categories = ServiceFactory.getInstance().getCategoryService()
                        .getAllCategory();
                request.setAttribute("list_categories", list_categories);
                page = Page.MENU.name();
            } else {
                String error = Utils.getMessage("incorrect_pass_or_login",
                        request);
                request.setAttribute("invalidLogin", error);
                page = Page.INDEX.name();
            }
        }
        return page;
    }
}
