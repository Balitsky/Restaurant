package command.admin;

import command.service.Command;
import page.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminCommand implements Command{
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return Page.ADMIN.name();
    }
}
