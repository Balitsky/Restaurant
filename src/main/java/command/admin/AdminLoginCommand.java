package command.admin;

import command.service.Command;
import dao.factories.AdminDao;
import dao.factories.DaoFactory;
import dao.mysqlFactories.MySQLFactory;
import model.Admin;
import page.Page;
import service.ServiceFactory;
import service.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        if (request.getSession().getAttribute("admin") != null) {
            page = Page.ADMIN_CONSOLE.name();
            return page;
        } else {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            Admin admin = null;
            if (password != null && !password.isEmpty()) {
                admin = ServiceFactory.getInstance().getAdminService()
                        .getAdmin(login, password);
            }
            if (admin != null) {
                request.setAttribute("login", login);
                request.getSession().setAttribute("admin", admin);
                page = Page.ADMIN_CONSOLE.name();
            } else {
                request.setAttribute("invalidAdminLogin", Utils.getMessage("incorrect_pass_or_login", request));
                page = Page.ADMIN.name();
            }
        }
        return page;
    }
}
