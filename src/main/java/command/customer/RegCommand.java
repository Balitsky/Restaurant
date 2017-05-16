package command.customer;

import command.service.Command;
import dao.factories.CustomerDao;
import dao.factories.DaoFactory;
import dao.mysqlFactories.MySQLFactory;
import model.Customer;
import page.Page;
import service.ServiceFactory;
import service.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        // get Customer info from form
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        fillOutTheForm(request, login, phone, email);

        if (!Utils.isAllFieldisFilled(login, password, confirm_password, phone,
                email)) {
            request.setAttribute("filledFail",Utils.getMessage("not_all_fields_are_filled", request));
            page = Page.REG.name();
        } else if (!Utils.isValidLogin(login)) {
            request.setAttribute("loginFail",Utils.getMessage("incorrect_login", request));
            page = Page.REG.name();
        } else if (!Utils.isValidPassword(password)) {
            request.setAttribute("passwordFail",Utils.getMessage("incorrect_password", request));
            page = Page.REG.name();
        } else if (!Utils.isConfrimPasswordEqualsPassword(password,
                confirm_password)) {
            request.setAttribute("confirmpassFail",Utils.getMessage("passwords_dont_match", request));
            page = Page.REG.name();
        } else if (!Utils.isValidPhone(phone)) {
            request.setAttribute("phoneFail",Utils.getMessage("incorrect_phone", request));
            page = Page.REG.name();
        } else if (!Utils.isValidEMail(email)) {
            request.setAttribute("emailFail",Utils.getMessage("incorrect_email", request));
            page = Page.REG.name();
        } else if (Utils.isAlreadyUser(login)) {
            request.setAttribute("alreadyUser",Utils.getMessage("already_user", request));
            page = Page.REG.name();
        } else if (!Utils.isAlreadyUser(login)) {
            request.setAttribute("added_success",Utils.getMessage("added_success", request));
            Customer customer = createCustomer(login, confirm_password, email,
                    phone);
            ServiceFactory.getInstance().getCustomerService()
                    .addCustomer(customer);
            page = Page.INDEX.name();
        } else {
            page = Page.INDEX.name();
        }
        return page;

    }

    private Customer createCustomer(String login, String password, String email, String phone) {
        Customer customer = new Customer();
        customer.setLogin(login);
        customer.setPassword(password);
        customer.setEmail(email);
        customer.setPhone(phone);
        return customer;
    }

    private void fillOutTheForm(HttpServletRequest request, String login, String phone, String email) {
        request.setAttribute("login", login);
        request.setAttribute("phone", phone);
        request.setAttribute("email", email);
    }
}
