package bankingmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepositeDAO {
    private Connection conn;

    public DepositeDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean depositAmount(String username, String accountNo, double amount) {
        String updateBalanceSQL = "UPDATE customerac SET balance = balance + ? WHERE account_no = ? AND username = ?";
        try (PreparedStatement ps = conn.prepareStatement(updateBalanceSQL)) {
            ps.setDouble(1, amount);
            ps.setString(2, accountNo);
            ps.setString(3, username);


            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public double getBalance(String username, String accountNo) {
        String getBalanceSQL = "SELECT balance FROM customerac WHERE account_no = ? AND username = ?";
        try (PreparedStatement ps = conn.prepareStatement(getBalanceSQL)) {
            ps.setString(1, accountNo);
          
			ps.setString(2, username);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("balance");
                } else {
                    throw new SQLException("Account not found");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}
