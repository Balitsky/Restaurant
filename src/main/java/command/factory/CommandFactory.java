package command.factory;

import command.admin.*;
import command.customer.LoginCommand;
import command.customer.LogoutCommand;
import command.customer.ProfileCommand;
import command.customer.RegCommand;
import command.order.*;
import command.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static CommandFactory instance = new CommandFactory();
    private Map<String, Command> commands = new HashMap<>();

    private CommandFactory(){
        Map<String, Command> tempMap = new HashMap<>();
        tempMap.put("/login", new LoginCommand());
        tempMap.put("/reg", new RegCommand());
        tempMap.put("/profile", new ProfileCommand());
        tempMap.put("/logout", new LogoutCommand());
        tempMap.put("/cart", new CartCommand());
        tempMap.put("/viewcart", new ViewCartCommand());
        tempMap.put("/updatequantity", new UpdateQuantityCommand());
        tempMap.put("/finish_order", new FinishOrderCommand());
        tempMap.put("/do_another_order", new DoAnotherOrderCommand());
        tempMap.put("/admin", new AdminCommand());
        tempMap.put("/admin_login", new AdminLoginCommand());
        tempMap.put("/view_all_customers", new ViewAllCustomersCommand());
        tempMap.put("/view_all_orders", new ViewAllOrdersCommand());
        tempMap.put("/logout_admin", new LogoutAdmin());
        tempMap.put("/confirm_order", new ConfirmOrderCommand());
        tempMap.put("/back", new BackToMenuCommand());
        tempMap.put("/remove_product", new RemoveProductCommand());

        commands = Collections.unmodifiableMap(tempMap);
    }

    public Command getCommand(HttpServletRequest request){
        String path = request.getServletPath();
        return commands.get(path);
    }

    public Command getCommand(String path){
        path = "/" + path;
        return commands.get(path);
    }

    public static CommandFactory getInstance(){
        return instance;
    }
}
