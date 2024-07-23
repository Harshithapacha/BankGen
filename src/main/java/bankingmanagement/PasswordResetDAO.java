package bankingmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PasswordResetDAO {

    public boolean isValidUser(String username, String accountNo) {
        try (Connection conn = bankDAO.getConnection()) {
            String query = "SELECT COUNT(*) FROM customerac WHERE username = ? AND account_no = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, accountNo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePassword(String username, String accountNo, String newPassword) {
        try (Connection conn = bankDAO.getConnection()) {
            String query = "UPDATE customerac SET temp_password = ? WHERE username = ? AND account_no = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, newPassword);
            stmt.setString(2, username);
            stmt.setString(3, accountNo);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
