package bankingmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDelDAO {

    public boolean deleteCustomer(String account_no, String temp_password) {
        String query = "DELETE FROM customerac WHERE account_no = ? AND temp_password = ?";
        try (Connection conn = bankDAO.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, account_no);
            
			pstmt.setString(2, temp_password);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
