package BankingControllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bankingmanagement.PasswordResetDAO;

@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String accountNo = request.getParameter("account_no");
        PasswordResetDAO dao = new PasswordResetDAO();

        if (dao.isValidUser(username, accountNo)) {
            request.setAttribute("username", username);
            request.setAttribute("account_no", accountNo);
            request.setAttribute("showResetForm", true);
            request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Invalid Username or Account Number");
            request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
        }
    }
}
