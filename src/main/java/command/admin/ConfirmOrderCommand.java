package command.admin;

import command.service.Command;
import dao.factories.DaoFactory;
import dao.factories.OrderDao;
import dao.mysqlFactories.MySQLFactory;
import model.Order;
import page.Page;
import service.ServiceFactory;
import service.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ConfirmOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        String real_id_order = request.getParameter("id_order");
        if (real_id_order == null) return Page.ADMIN_CONSOLE.name();
        Integer id_order = Integer.parseInt(real_id_order);
        ServiceFactory.getInstance().getOrderService()
                .confirmOrder(id_order);
        List<Order> list_orders = ServiceFactory.getInstance().getOrderService()
                .getAllOrders();
        request.setAttribute("list_orders", list_orders);
        request.setAttribute("confirm_succes", Utils.getMessage("confirm_order", request));
        page = Page.ADMIN_CONSOLE.name();
        return page;
    }
}
