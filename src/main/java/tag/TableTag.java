package tag;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class TableTag extends TagSupport {
    private String customer_login;
    private String customer_email;
    private String customer_phone;

    @Override
    public int doStartTag() {
        JspWriter out = pageContext.getOut();
        try {
            out.println("<tr id='profile_info'>");
            out.println("<td>");
            out.println(customer_login);
            out.println("</td>");
            out.println("<td>");
            out.println(customer_email);
            out.println("</td>");
            out.println("<td>");
            out.println(customer_phone);
            out.println("</td>");
            out.println("</tr>");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;

    }

    public String getCustomer_login() {
        return customer_login;
    }

    public void setCustomer_login(String customer_login) {
        this.customer_login = customer_login;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }
}
