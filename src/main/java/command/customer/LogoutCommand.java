package command.customer;

import command.Command;
import page.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        HttpSession session = request.getSession();
        session.invalidate();
        String language = Locale.ENGLISH.getLanguage();
        request.getSession().setAttribute("language", language);
        page = Page.INDEX.name();
        return page;
    }
}
