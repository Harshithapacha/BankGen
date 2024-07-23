package BankingControllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BankingView.Customer;
import bankingmanagement.CustomerDAO;

@WebServlet("/CustomerDetailsServlet")
public class CustomerDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNo = request.getParameter("account_no");

        CustomerDAO customerDAO = new CustomerDAO(); // Instantiate your DAO class
        Customer customer = null;
        try {
            customer = customerDAO.getCustomerByAccountNo(accountNo); // Retrieve customer details
        } catch (Exception e) {
            // Handle exception (e.g., log it)
            e.printStackTrace();
            response.sendRedirect("adminDash.jsp"); // Redirect to an error page
            return;
        }

        if (customer != null) {
            request.setAttribute("customer", customer); // Set customer object as request attribute
            request.getRequestDispatcher("CustomerDetails.jsp").forward(request, response); // Forward to CustomerDetails.jsp
        } else {
            response.sendRedirect("CustomerUpdate.jsp"); // Redirect to a page for updating customer details
        }
    }
}
