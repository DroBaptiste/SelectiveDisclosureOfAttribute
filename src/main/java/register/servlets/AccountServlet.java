package register.servlets;

import Mock.Mock;
import utils.Account;

import java.io.IOException;
import java.util.List;


public class AccountServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Mock mock = new Mock();
        List<Account> accounts = mock.getAccounts();
        String content = "<table>\n" +
                "        <thead>\n" +
                "          <tr>\n" +
                "              <th>Account</th>\n" +
                "              <th>Password</th>\n" +
                "              <th>Driver</th>\n" +
                "              <th>Adult</th>\n" +
                "          </tr>\n" +
                "        </thead>";
        for (Account account: accounts) {
            content += "<tr>";
            content += "<td>"+account.getAddress()+"</td>";
            content += "<td>"+account.getPassword()+"</td>";
            content += "<td>"+ (account.isDriver()? "<i class=\"material-icons\">\n" +
                    "done\n" +
                    "</i>" : "<i class=\"material-icons\">\n" +
                    "clear\n" + "</i>") +"</td>";
            content += "<td>"+ (account.isAdult() ?  "<i class=\"material-icons\">\n" +
                    "done\n" +
                    "</i>" : "<i class=\"material-icons\">\n" +
                    "clear\n" + "</i>") +"</td>";
            content += "</tr>";
        }
        content += "</table>";
        request.setAttribute("account", content);
        request.getRequestDispatcher("account.jsp").forward(request, response);
    }

}
