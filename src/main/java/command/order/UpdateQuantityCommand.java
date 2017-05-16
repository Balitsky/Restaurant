package command.order;

import command.Command;
import model.Order;
import model.Product;
import page.Page;
import service.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateQuantityCommand implements Command
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String real_update_value = request.getParameter("update_value");
        if (real_update_value == null) return Page.VIEWCART.name();
        String product_name = request.getParameter("prod_name");
        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("order");
        int items_count = 0;
        Integer total = 0;
        Integer updateValue = null;

        if (!isCorrectUpdateValue(real_update_value)) {
            request.setAttribute("incorrect_update_value_msg", Utils.getMessage("incorrect_update_value", request));
        } else {
            updateValue = Integer.parseInt(real_update_value);
            for (Entry<Product, Integer> entry : order.getAccountProduct().entrySet()) {
                if (entry.getKey().getName().equals(product_name)) {
                    if ((entry.getKey().getAmount() - updateValue) < 0) {
                        request.setAttribute("exceeded_value", Utils.getMessage("exceeded_value", request));
                        return Page.VIEWCART.name();
                    } else {
                        entry.setValue(updateValue);
                    }
                }
                total += entry.getKey().getPrice() * entry.getValue();
                items_count += entry.getValue();
            }
            order.setTotal(total);
            session.setAttribute("order", order);
            session.setAttribute("items_count", items_count);
        }
        // -----------
        return Page.VIEWCART.name();
    }

    public boolean isCorrectUpdateValue(String real_update_value) {
        Pattern p = Pattern.compile("^[1-9]+[0-9]*$");
        Matcher m = p.matcher(real_update_value);
        return m.matches();
    }
}
