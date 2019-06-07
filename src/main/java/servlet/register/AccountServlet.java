package servlet.register;

import mock.Mock;
import utils.Account;

import java.io.IOException;
import java.util.List;


public class AccountServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Mock mock = new Mock();
        List<Account> accounts = mock.getAccounts();
        StringBuilder content = new StringBuilder("<table>\n" +
                "        <thead>\n" +
                "          <tr>\n" +
                "              <th>Account</th>\n" +
                "              <th>Password</th>\n" +
                "              <th>Driver</th>\n" +
                "              <th>Adult</th>\n" +
                "          </tr>\n" +
                "        </thead>");
        for (Account account : accounts) {
            content.append("<tr>");
            content.append("<td>").append(account.getAddress()).append("</td>");
            content.append("<td>").append(account.getPassword()).append("</td>");
            content.append("<td>").append(account.isDriver() ? "<i class=\"material-icons\">\n" +
                    "done\n" +
                    "</i>" : "<i class=\"material-icons\">\n" +
                    "clear\n" + "</i>").append("</td>");
            content.append("<td>").append(account.isAdult() ? "<i class=\"material-icons\">\n" +
                    "done\n" +
                    "</i>" : "<i class=\"material-icons\">\n" +
                    "clear\n" + "</i>").append("</td>");
            content.append("</tr>");
        }
        content.append("</table>");
        request.setAttribute("accountList", content.toString());
        request.getRequestDispatcher("account.jsp").forward(request, response);
    }

}
