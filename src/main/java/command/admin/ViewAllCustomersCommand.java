package command.admin;

import command.service.Command;
import dao.factories.CustomerDao;
import dao.factories.DaoFactory;
import dao.mysqlFactories.MySQLFactory;
import model.Customer;
import page.Page;
import service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ViewAllCustomersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        List<Customer> list_customers = ServiceFactory.getInstance().getCustomerService()
                .getAllCustomers();
        request.setAttribute("list_customers", list_customers);
        page = Page.ADMIN_CONSOLE.name();
        return page;
    }
}
