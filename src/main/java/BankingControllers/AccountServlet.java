package BankingControllers;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bankingmanagement.AccountDAO;
import bankingmanagement.bankDAO;
import BankingView.Customer;

@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String accountNo = request.getParameter("accountNo");

        if (username == null || accountNo == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        try (Connection conn = bankDAO.getConnection()) {
            AccountDAO accountDAO = new AccountDAO(conn);
            Customer customer = accountDAO.getAccountByAccountNoAndUsername(accountNo, username);

            if (customer != null) {
                request.setAttribute("customer", customer);
                request.getRequestDispatcher("Account.jsp").forward(request, response);
            } else {
                response.sendRedirect("CustomerDash.jsp?error=No%20details%20found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("CustomerDash.jsp?error=Error%20retrieving%20details");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
