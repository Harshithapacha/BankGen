<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Forgot Password</title>
    <style>
        body {
            font-family: "Times New Roman", Times, serif;
            background: url('https://static.vecteezy.com/system/resources/previews/010/518/831/non_2x/digital-finance-and-banking-investment-service-in-futuristic-background-bank-building-with-online-growth-graph-investment-secure-money-and-financial-innovation-technology-vector.jpg') no-repeat center center fixed;
            background-size: cover;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .forgot-container {
            background-color: Dark blue;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            color: white;
        }
        .forgot-container h1 {
            margin-bottom: 20px;
            text-align: center;
            font-size: 2em;
        }
        .forgot-container label {
            display: block;
            margin-bottom: 5px;
            font-size: 1.5em;
        }
        .forgot-container input[type="text"], .forgot-container input[type="password"] {
            width: 90%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            color: black;
            background-color: white;
            font-size: 1.2em;
        }
        .forgot-container button {
            width: 95%;
            padding: 10px;
            background-color: #1E90FF;
            border: none;
            color: white;
            border-radius: 4px;
            cursor: pointer;
            font-size: 1.5em;
        }
        .forgot-container button:hover {
            background-color: #B0C4DE;
        }
    </style>
    <script>
        function showResetForm() {
            document.getElementById('verifyForm').style.display = 'none';
            document.getElementById('resetForm').style.display = 'block';
        }
    </script>
</head>
<body>
    <div class="forgot-container">
        <h1>Forgot Password</h1>

        <form id="verifyForm" action="ResetPasswordServlet" method="post" style="display: block;">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <label for="account_no">Account Number:</label>
            <input type="text" id="account_no" name="account_no" required>
            <button type="submit">Verify</button>
        </form>

        <form id="resetForm" action="UpdatePasswordServlet" method="post" style="display: none;">
            <input type="hidden" id="username_hidden" name="username">
            <input type="hidden" id="account_no_hidden" name="account_no">
            <label for="newPassword">New Password:</label>
            <input type="password" id="newPassword" name="newPassword" required>
            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
            <button type="submit">Update Password</button>
        </form>

        <% 
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
        %>
            <p style="color: red;"><%= errorMessage %></p>
        <% 
            }
            Boolean showResetForm = (Boolean) request.getAttribute("showResetForm");
            if (showResetForm != null && showResetForm) { 
        %>
            <script>
                document.getElementById('username_hidden').value = "<%= request.getAttribute("username") %>";
                document.getElementById('account_no_hidden').value = "<%= request.getAttribute("account_no") %>";
                showResetForm();
            </script>
        <% } %>
    </div>
</body>
</html>
