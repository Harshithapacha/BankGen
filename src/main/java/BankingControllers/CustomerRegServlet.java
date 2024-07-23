package BankingControllers;

import java.io.IOException;
import java.security.SecureRandom;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bankingmanagement.CustomerRegDAO;

@WebServlet("/CustomerRegServlet")
public class CustomerRegServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("CustomerReg.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String full_name = request.getParameter("full_name");
        String address = request.getParameter("address");
        String mobile_no = request.getParameter("mobile_no");
        String email_id = request.getParameter("email_id");
        String account_type = request.getParameter("account_type");
        String dob = request.getParameter("dob");
        String id_proof = request.getParameter("id_proof");

        String account_no = generateAccountNumber();
        String temp_password = generateTempPassword();

        CustomerRegDAO customerRegDao = new CustomerRegDAO();

        boolean isRegistered = customerRegDao.registerCustomer(full_name, address, mobile_no, email_id, account_type, dob, id_proof, account_no, temp_password);

        if (isRegistered) {
            // Pass account number and temp password as attributes to success page
            request.setAttribute("accountNumber", account_no);
            request.setAttribute("tempPassword", temp_password);
            request.getRequestDispatcher("RegSuccess.jsp").forward(request, response);
        } else {
            response.sendRedirect("CustomerReg.jsp?error=Registration%20failed");
        }
    }

    private String generateAccountNumber() {
        SecureRandom random = new SecureRandom();
        int account_no = 10000 + random.nextInt(90000);
        return String.valueOf(account_no);
    }

    private String generateTempPassword() {
        SecureRandom random = new SecureRandom();
        int temp_password = 100000 + random.nextInt(900000);
        return String.valueOf(temp_password);
    }
}
