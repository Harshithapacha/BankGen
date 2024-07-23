package BankingControllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bankingmanagement.CustomerDelDAO;
import bankingmanagement.CustomerRegDAO;

@WebServlet("/CustomerDelServlet")
public class CustomerDelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("CustomerDel.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account_no = request.getParameter("account_no");
        String temp_password = request.getParameter("temp_password");

        CustomerDelDAO customerRegDao = new CustomerDelDAO();

        boolean isDeleted = customerRegDao.deleteCustomer(account_no, temp_password);

        if (isDeleted) {
            response.sendRedirect("DelSuccess.jsp");
        } else {
            response.sendRedirect("CustomerDel.jsp");
        }
    }
}
