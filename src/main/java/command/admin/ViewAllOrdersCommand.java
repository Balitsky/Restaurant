package command.admin;

import command.Command;
import model.Order;
import page.Page;
import service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ViewAllOrdersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        List<Order> list_orders = ServiceFactory.getInstance().getOrderService()
                .getAllOrders();
        request.setAttribute("list_orders", list_orders);
        page = Page.ADMIN_CONSOLE.name();
        return page;

    }
}
