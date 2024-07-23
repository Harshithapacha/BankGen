package bankingmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BankingView.Customer;

public class AccountDAO {
    private Connection connection;

    public AccountDAO(Connection connection) {
        this.connection = connection;
    }

    public Customer getAccountByAccountNoAndUsername(String accountNo, String username) {
        String query = "SELECT * FROM customerac WHERE account_no = ? AND username = ?;";
        Customer account = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, accountNo);
            preparedStatement.setString(2, username);


            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    account = new Customer(
                        resultSet.getString("account_no"),
                        resultSet.getString("full_name"),
                        resultSet.getString("email_id"),
                        resultSet.getString("mobile_no"),
                        resultSet.getString("address"),
                        resultSet.getString("account_type"),
                        resultSet.getString("dob"),
                        resultSet.getString("id_proof")
                    );
                    account.setBalance(resultSet.getDouble("balance"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}

	