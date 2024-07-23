package BankingControllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bankingmanagement.PasswordResetDAO;

/**
 * Servlet implementation class UpdatePasswordServlet
 */
@WebServlet("/UpdatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String username = request.getParameter("username");
	        String accountNo = request.getParameter("account_no");
	        String newPassword = request.getParameter("newPassword");
	        String confirmPassword = request.getParameter("confirmPassword");

	        if (newPassword.equals(confirmPassword)) {
	            PasswordResetDAO dao = new PasswordResetDAO();
	            if (dao.updatePassword(username, accountNo, newPassword)) {
	                response.sendRedirect("index.jsp?message=Password successfully updated");
	            } else {
	                request.setAttribute("errorMessage", "Failed to update password");
	                request.setAttribute("showResetForm", true);
	                request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
	            }
	        } else {
	            request.setAttribute("errorMessage", "Passwords do not match");
	            request.setAttribute("showResetForm", true);
	            request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
	        }
	    }
	}