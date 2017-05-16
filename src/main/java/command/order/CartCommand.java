package command.order;

import command.service.Command;
import dao.factories.CategoryDao;
import dao.factories.DaoFactory;
import dao.factories.ProductDao;
import dao.mysqlFactories.MySQLFactory;
import model.Category;
import model.Customer;
import model.Order;
import model.Product;
import page.Page;
import service.ServiceFactory;
import service.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CartCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String real_id_product = request.getParameter("id_product");
        if (real_id_product == null) return Page.INDEX.name();
        real_id_product = real_id_product.substring(0, real_id_product.length() - 1);
        String real_id_category = request.getParameter("id_category");
        if (real_id_category == null) return Page.INDEX.name();
        real_id_category = real_id_category.substring(0, real_id_category.length() - 1);

        List<Category> list_categories = ServiceFactory.getInstance()
                .getCategoryService().getAllCategory();
        request.setAttribute("list_categories", list_categories);
        // ----

        Integer id_product = Integer.parseInt(real_id_product);
        Integer id_category = Integer.parseInt(real_id_category);
        request.setAttribute("idcat", id_category);
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        Order order = (Order) session.getAttribute("order");
        if (order == null) {
            order = new Order();
        }
        // ----
        Product product = ServiceFactory.getInstance()
                .getProductService().getProduct(id_product);
        if (product.getAmount() == 0) {
            request.setAttribute("notAvailableProduct", Utils.getMessage("product_not_available", request));
            return Page.MENU.name();
        }
        if (order.getAccountProduct().containsKey(product)) {
            request.setAttribute("already_added", Utils.getMessage("product_already_added", request));
            return Page.MENU.name();
        } else {
            order.getAccountProduct().put(product, 1);
            order.setTotal(order.getTotal() + product.getPrice());
        }
        // ----
        order.setCustomer(customer);
        session.setAttribute("order", order);
        // ----------
        Integer items_count = (Integer) session.getAttribute("items_count");
        items_count++;
        session.setAttribute("items_count", items_count);
        // ---
        return Page.MENU.name();

    }
}
