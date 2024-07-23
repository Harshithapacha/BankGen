package bankingmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CustomerRegDAO {

    // Email utility method to send email
    private void sendEmail(String toAddress, String accountNumber, String accountPassword) {
        final String username = "pachahrshitha_ece21@velhightech.com";  // Replace with your email
        final String password = "Harshith@12";      // Replace with your email password or App password
        final String smtpHost = "smtp.gmail.com";  // Replace with your SMTP server host
        final String smtpPort = "587";           // Replace with your SMTP server port

        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setSubject("Your Account Details");
            message.setText("Dear User,\n\n" +
                            "Your account has been successfully created.\n\n" +
                            "Account Number: " + accountNumber + "\n" +
                            "Temporary Password: " + accountPassword + "\n\n" +
                            "Please change your password after your first login.\n\n" +
                            "Thank you for banking with us.\n\n" +
                            "Best Regards,\nBank Management");

            Transport.send(message);
            System.out.println("Email sent successfully to " + toAddress);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Failed to send email.");
        }
    }

    // Method to register a customer
    public boolean registerCustomer(String fullName, String address, String mobileNo, String emailId, String accountType, String dob, String idProof, String accountNo, String tempPassword) {
        boolean isRegistered = false;

        try (Connection conn = bankDAO.getConnection()) {
            String sql = "INSERT INTO customerac (full_name, address, mobile_no, email_id, account_type, dob, id_proof, account_no, temp_password, username) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, fullName);
            stmt.setString(2, address);
            stmt.setString(3, mobileNo);
            stmt.setString(4, emailId);
            stmt.setString(5, accountType);
            stmt.setString(6, dob);
            stmt.setString(7, idProof);
            stmt.setString(8, accountNo);
            stmt.setString(9, tempPassword);
            stmt.setString(10, fullName);  // Assuming username is the full name here

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                isRegistered = true;
                // Send email after successful registration
                sendEmail(emailId, accountNo, tempPassword);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isRegistered;
    }
}
