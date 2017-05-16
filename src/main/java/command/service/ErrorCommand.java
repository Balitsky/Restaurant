package command.service;

import page.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorCommand implements Command {
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return Page.EROR404.name();
    }
}
