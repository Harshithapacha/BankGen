package BankingControllers;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bankingmanagement.DepositeDAO;
import bankingmanagement.bankDAO;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        String accountNo = request.getParameter("accountNo");
        String amountStr = request.getParameter("amount");

        if (accountNo == null || accountNo.isEmpty() || username == null || username.isEmpty()) {
            response.sendRedirect("CustomerDash.jsp");
            return;
        }

        if (amountStr == null || amountStr.isEmpty()) {
            request.setAttribute("accountNo", accountNo);
            request.setAttribute("username", username);
            request.getRequestDispatcher("Deposite.jsp").forward(request, response);
            return;
        }

        try {
            double amount = Double.parseDouble(amountStr);
            if (amount <= 0) {
                request.setAttribute("error", "Invalid amount entered.");
                request.setAttribute("accountNo", accountNo);
                request.setAttribute("username", username);
                request.getRequestDispatcher("Deposite.jsp").forward(request, response);
                return;
            }

            processDeposit(username, accountNo, amount, request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid amount entered.");
            request.setAttribute("accountNo", accountNo);
            request.setAttribute("username", username);
            request.getRequestDispatcher("Deposite.jsp").forward(request, response);
        }
    }

    private void processDeposit(String username, String accountNo, double amount, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection conn = bankDAO.getConnection()) {
            DepositeDAO depositDAO = new DepositeDAO(conn);
            boolean success = depositDAO.depositAmount(username, accountNo, amount);

            if (success) {
                double newBalance = depositDAO.getBalance(username, accountNo);
                request.setAttribute("message", "Amount deposited successfully.");
                request.setAttribute("newBalance", newBalance);
                request.setAttribute("accountNo", accountNo);
                request.setAttribute("username", username);
                request.getRequestDispatcher("Deposite.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Failed to deposit amount. Please try again.");
                request.setAttribute("accountNo", accountNo);
                request.setAttribute("username", username);
                request.getRequestDispatcher("Deposite.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred while processing the deposit. Please try again.");
            request.setAttribute("accountNo", accountNo);
            request.setAttribute("username", username);
            request.getRequestDispatcher("Deposite.jsp").forward(request, response);
        }
    }
}