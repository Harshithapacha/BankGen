<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
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
        .login-container {
            background-color: Dark blue;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            color: white;
        }
        .login-container h1 {
            margin-bottom: 20px;
            text-align: center;
            font-size: 2em;
        }
        .login-container label {
            display: block;
            margin-bottom: 5px;
            font-size: 1.5em;
        }
        .login-container input[type="text"], .login-container input[type="password"] {
            width: 90%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            color: black;
            background-color: white;
            font-size: 1.2em;
        }
        .login-container select {
            width: 95%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 1.2em;
        }
        .login-container button {
            width: 95%;
            padding: 10px;
            background-color: #1E90FF;
            border: none;
            color: white;
            border-radius: 4px;
            cursor: pointer;
            font-size: 1.5em;
        }
        .login-container button:hover {
            background-color: #B0C4DE;
        }
        .login-container .forgot-password {
            margin-top: 10px;
            text-align: center;
            font-size: 1.2em;
        }
        .login-container .forgot-password a {
            color: white;
            text-decoration: none;
        }
        .login-container .forgot-password a:hover {
            text-decoration: underline;
        }
        .message-box {
            width: 100%;
            padding: 15px;
            margin: 20px 0;
            border-radius: 5px;
            text-align: center;
        }
        .success {
            background-color: #d4edda;
            color: #155724;
        }
        .error {
            background-color: #f8d7da;
            color: #721c24;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h1>Banking Application Login</h1>
        <form action="Login" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <label for="role">Login as:</label>
            <select id="role" name="role" required>
                <option value="admin">Admin</option>
                <option value="customer">Customer</option>
            </select>

            <button type="submit">Login</button>
        </form>

        <div class="forgot-password">
            <p><a href="forgotPassword.jsp">Forgot Password?</a></p>
        </div>
        
        <!-- Display message if present -->
        <% 
            String message = request.getParameter("message");
            if (message != null) {
                String messageType = message.contains("success") ? "success" : "error";
        %>
            <div class="message-box <%= messageType %>">
                <%= message %>
            </div>
        <% } %>
    </div>
</body>
</html>
