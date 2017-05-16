package command.order;

import command.service.Command;
import dao.factories.CategoryDao;
import dao.factories.DaoFactory;
import dao.mysqlFactories.MySQLFactory;
import model.Category;
import model.Order;
import model.Product;
import page.Page;
import service.ServiceFactory;

import java.util.Iterator;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class RemoveProductCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String remove_name = request.getParameter("remove_name");
        Order order = (Order) request.getSession().getAttribute("order");
        int items_count = (int) request.getSession()
                .getAttribute("items_count");
        Product p = null;
        p = findAppropriateProduct(remove_name, order, p);
        items_count = removeAppropriateProduct(order, items_count, p);
        Integer total = changeTotal(order);
        order.setTotal(total);

        request.getSession().setAttribute("order", order);
        request.getSession().setAttribute("items_count", items_count);
        // ---

        List<Category> list_categories = ServiceFactory.getInstance()
                .getCategoryService().getAllCategory();
        request.setAttribute("list_categories", list_categories);
        return Page.VIEWCART.name();
    }

    private Integer changeTotal(Order order) {
        Integer total = 0;
        for (Entry<Product, Integer> entry : order.getAccountProduct().entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    private int removeAppropriateProduct(Order order, int items_count, Product p) {
        Iterator<Entry<Product, Integer>> it = order.getAccountProduct().entrySet()
                .iterator();
        while (it.hasNext()) {
            Map.Entry<Product, Integer> entry = it.next();
            if (entry.getKey().equals(p)) {
                it.remove();
                items_count = items_count - entry.getValue();
            }
        }
        return items_count;
    }

    private Product findAppropriateProduct(String remove_name, Order order, Product p) {
        for (Entry<Product, Integer> entry : order.getAccountProduct().entrySet()) {
            if (entry.getKey().getName().equals(remove_name)) {
                p = entry.getKey();
            }
        }
        return p;
    }
}
