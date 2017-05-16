package command.order;

import command.Command;
import model.Category;
import model.Order;
import page.Page;
import service.ServiceFactory;
import service.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class FinishOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Category> list_categories = ServiceFactory.getInstance()
                .getCategoryService().getAllCategory();
        request.setAttribute("list_categories", list_categories);
        HttpSession session = request.getSession();

        // database transaction
        Order order = (Order) session.getAttribute("order");
        if (order == null || order.getTotal() == 0) {
            request.setAttribute("empty_cart", Utils.getMessage("empty_basket", request));
            return Page.VIEWCART.name();
        }
        ServiceFactory.getInstance().getOrderService().addOrder(order);
        // order has done
        session.setAttribute("order", null);
        session.setAttribute("items_count", 0);
        return Page.FINISH_ORDER.name();
    }
}
