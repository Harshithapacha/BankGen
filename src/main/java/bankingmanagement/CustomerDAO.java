package bankingmanagement;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import BankingView.Customer;

import java.sql.DriverManager;

public class CustomerDAO {

    // Method to initialize the database connection
    private Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/bank";
        String dbUser = "root";
        String dbPassword = "Harshith@_12";

        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    }
    
   

    // Method to update the balance of a customer account
    public boolean updateBalance(String accountNo, double amount) {
        boolean rowUpdated = false;
        String updateBalanceSQL = "UPDATE customerac SET balance = balance + ? WHERE account_no = ?";

        try (Connection connection = initializeDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(updateBalanceSQL)) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, accountNo);
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    // Method to get the balance of a customer account
   

    // Additional methods for CustomerDAO (if any)

    // Method to retrieve customer details based on account number
    public Customer getCustomerByAccountNo(String accountNo) {
        Customer customer = null;
        String getCustomerSQL = "SELECT * FROM customerac WHERE account_no = ?";

        try (Connection connection = initializeDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(getCustomerSQL)) {
            preparedStatement.setString(1, accountNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customer = new Customer();
                customer.setAccountNo(resultSet.getString("account_no"));
                customer.setFullName(resultSet.getString("full_name"));
                customer.setEmailId(resultSet.getString("email_id"));
                customer.setMobileNo(resultSet.getString("mobile_no"));
                customer.setAddress(resultSet.getString("address"));
                customer.setAccountType(resultSet.getString("account_type"));
                customer.setDob(resultSet.getString("dob"));
                customer.setIdProof(resultSet.getString("id_proof"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customer;
    }


    public boolean updateCustomer(Customer customer) {
        boolean rowUpdated = false;
        String updateCustomerSQL = "UPDATE customerac SET full_name=?, email_id=?, mobile_no=?, address=?, account_type=?, dob=?, id_proof=? WHERE account_no=?";

        try (Connection connection = bankDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateCustomerSQL)) {
            preparedStatement.setString(1, customer.getFullName());
            preparedStatement.setString(2, customer.getEmailId());
            preparedStatement.setString(3, customer.getMobileNo());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setString(5, customer.getAccountType());
            preparedStatement.setString(6, customer.getDob());
            preparedStatement.setString(7, customer.getIdProof());
            preparedStatement.setString(8, customer.getAccountNo());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowUpdated;
    }

    // Method to delete a customer
    public boolean deleteCustomer(String accountNo) {
        boolean rowDeleted = false;
        String deleteTransactionSQL = "DELETE FROM transaction WHERE account_no = ?";
        String deleteCustomerSQL = "DELETE FROM customerac WHERE account_no = ?";

        try (Connection connection = initializeDatabase()) {
            // Start a transaction
            connection.setAutoCommit(false);

            try (PreparedStatement deleteTransactionStmt = connection.prepareStatement(deleteTransactionSQL);
                 PreparedStatement deleteCustomerStmt = connection.prepareStatement(deleteCustomerSQL)) {
                
                // Delete transactions related to the account number
                deleteTransactionStmt.setString(1, accountNo);
                deleteTransactionStmt.executeUpdate();

                // Delete customer record
                deleteCustomerStmt.setString(1, accountNo);
                rowDeleted = deleteCustomerStmt.executeUpdate() > 0;

                // Commit transaction
                connection.commit();
            } catch (SQLException e) {
                // Rollback transaction in case of error
                connection.rollback();
                e.printStackTrace();
            } finally {
                // Restore auto-commit mode
                connection.setAutoCommit(true);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }
    /*public boolean updateBalanceByUsername(String username, double amount) {
        boolean rowUpdated = false;
        String updateBalanceSQL = "UPDATE customer SET balance = balance + ? WHERE username = ?";

        try (Connection connection = initializeDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(updateBalanceSQL)) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, username);
            
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();  // Add more detailed logging here
        }
        return rowUpdated;
    }*/

    // Method to get the balance of a customer account by username
    /*public double getBalanceByUsername(String username) {
        double balance = 0;
        String getBalanceSQL = "SELECT balance FROM customer WHERE username = ?";

        try (Connection connection = initializeDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(getBalanceSQL)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                balance = resultSet.getDouble("balance");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return balance;
    }*/
    /*public boolean deposit(String accountNo, BigDecimal amount) {
        boolean isUpdated = false;
        String depositSQL = "UPDATE account SET balance = balance + ? WHERE account_no = ?";

        try (Connection connection = bankDAO.initializeDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(depositSQL)) {
            preparedStatement.setBigDecimal(1, amount);
            preparedStatement.setString(2, accountNo);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                isUpdated = true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }
    */
   
    



	public BigDecimal getBalance(String accountNo) {
        BigDecimal balance = null;
        String selectBalanceSQL = "SELECT balance FROM customerac WHERE account_no = ?";

        try (Connection connection = initializeDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(selectBalanceSQL)) {
            preparedStatement.setString(1, accountNo);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                balance = resultSet.getBigDecimal("balance");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return balance;
    }
}
