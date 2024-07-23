package bankingmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WithdrawDAO {

    public static boolean verifyAccountOwnership(String username, String accountNumber) throws SQLException {
        boolean isOwner = false;

        try (Connection conn = bankDAO.getConnection()) {
            String sql = "SELECT 1 FROM customerac WHERE account_no = ? AND username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, accountNumber);
            stmt.setString(2, username);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                isOwner = true;
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new SQLException("Error in verifying account ownership: " + e.getMessage());
        }

        return isOwner;
    }

    public static boolean withdrawAmount(String username, String accountNumber, double amount) throws SQLException {
        boolean success = false;

        if (!verifyAccountOwnership(username, accountNumber)) {
            return false; // If the account does not belong to the user, return false
        }

        try (Connection conn = bankDAO.getConnection()) {
            String sql = "SELECT balance FROM customerac WHERE account_no = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, accountNumber);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                double currentBalance = rs.getDouble("balance");

                if (currentBalance >= amount) {
                    double newBalance = currentBalance - amount;

                    sql = "UPDATE customerac SET balance = ? WHERE account_no = ?";
                    PreparedStatement updateStmt = conn.prepareStatement(sql);
                    updateStmt.setDouble(1, newBalance);
                    updateStmt.setString(2, accountNumber);

                    int rowsUpdated = updateStmt.executeUpdate();
                    if (rowsUpdated > 0) {
                        success = true;
                    }

                    updateStmt.close();
                }
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new SQLException("Error in withdrawing amount: " + e.getMessage());
        }

        return success;
    }

    public static double getBalance(String accountNumber) throws SQLException {
        double balance = 0;

        try (Connection conn = bankDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT balance FROM customerac WHERE account_no = ?")) {
            stmt.setString(1, accountNumber);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                balance = rs.getDouble("balance");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new SQLException("Error in getting balance: " + e.getMessage());
        }

        return balance;
    }
}