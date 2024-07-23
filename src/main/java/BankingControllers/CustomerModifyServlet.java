package BankingControllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BankingView.Customer;
import bankingmanagement.CustomerDAO;

@WebServlet("/CustomerModifyServlet")
public class CustomerModifyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("modify".equals(action)) {
            String accountNo = request.getParameter("account_no");
            String fullName = request.getParameter("full_name");
            String emailId = request.getParameter("email_id");
            String mobileNo = request.getParameter("mobile_no");
            String address = request.getParameter("address");
            String accountType = request.getParameter("account_type");
            String dob = request.getParameter("dob");
            String idProof = request.getParameter("id_proof");

            Customer updatedCustomer = new Customer(accountNo, fullName, emailId, mobileNo, address, accountType, dob, idProof);

            CustomerDAO customerDAO = new CustomerDAO();
            boolean isUpdated = customerDAO.updateCustomer(updatedCustomer);

            if (isUpdated) {
                response.sendRedirect("CustomerUpdate.jsp?message=updateSuccess");
            } else {
                response.sendRedirect("CustomerUpdate.jsp?message=updateFail");
            }
        } else if ("delete".equals(action)) {
            String accountNo = request.getParameter("account_no");

            CustomerDAO customerDAO = new CustomerDAO();
            boolean isDeleted = customerDAO.deleteCustomer(accountNo);

            if (isDeleted) {
                response.sendRedirect("CustomerUpdate.jsp?message=deleteSuccess");
            } else {
                response.sendRedirect("CustomerUpdate.jsp?message=deleteFail");
            }
        } else {
            response.sendRedirect("CustomerUpdate.jsp?message=unsupportedAction");
        }
    }
}
