package controller;

import command.factory.CommandFactory;
import command.Command;
import page.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
//        System.setProperty("file.Encoding", "UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    private void performTask(HttpServletRequest req, HttpServletResponse resp) {
        CommandFactory factory = CommandFactory.getInstance();
        Command command = factory.getCommand(req);
        String path = command.execute(req, resp);
        String url = null;
        if (path.equals(Page.INDEX.name()) || path.equals(Page.REG.name())) {
            url = "/" + path.toLowerCase() + ".jsp";
        } else {
            url = "/WEB-INF/view/" + path.toLowerCase() + ".jsp";
        }
        try {
            req.getRequestDispatcher(url).forward(req, resp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
