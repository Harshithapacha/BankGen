package bankingmanagement;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import BankingView.Transaction;

public class TransactionDAO {
	 
	                     
    public List<Transaction> getTransactionsByAccountNo(String accountNo) {
        List<Transaction> transactions = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = bankDAO.getConnection();
            String query = "SELECT * FROM transaction WHERE account_no = ? ORDER BY transaction_date DESC LIMIT 20";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, accountNo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int transactionId = rs.getInt("transaction_id");
                BigDecimal amount = rs.getBigDecimal("amount");
                LocalDateTime timestamp = rs.getObject("transaction_date", LocalDateTime.class);
                String transactionType = rs.getString("transaction_type");

                Transaction transaction = new Transaction(transactionId, accountNo, amount, timestamp, transactionType);
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return transactions;
    }
}
