package BankingControllers;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bankingmanagement.WithdrawDAO;

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String accountNumber = request.getParameter("accountNo");
        String amountStr = request.getParameter("amount");

        // Validate if session is active and username exists
        String username = (String) session.getAttribute("username");
        if (username == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        // Validate and parse the amount
        double amount = 0;
        try {
            if (amountStr != null && !amountStr.trim().isEmpty()) {
                amount = Double.parseDouble(amountStr.trim());
                if (amount <= 0) {
                    throw new IllegalArgumentException("Amount must be greater than zero.");
                }
            } else {
                throw new IllegalArgumentException("Amount is required.");
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid amount. Please enter a valid number.");
            request.getRequestDispatcher("Withdraw.jsp").forward(request, response);
            return;
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("Withdraw.jsp").forward(request, response);
            return;
        }

        // Process withdrawal
        try {
            boolean success = WithdrawDAO.withdrawAmount(username, accountNumber, amount);

            if (success) {
                double newBalance = WithdrawDAO.getBalance(accountNumber);
                request.setAttribute("message", "Withdrawal successful! New Balance: " + newBalance);
            } else {
                request.setAttribute("error", "Failed to withdraw amount.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Failed to process withdrawal due to a database error.");
        }

        request.getRequestDispatcher("Withdraw.jsp").forward(request, response);
    }
}