<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Dashboard</title>
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
        .dashboard-container {
            background-color:Dark blue;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: center;
            color:white;
        }
        .dashboard-container h1 {
            margin-bottom: 20px;
        }
        .dashboard-container label, .dashboard-container input {
            width: 95%;
            display: block;
            margin-bottom: 10px;
        }
        .dashboard-container input[type="text"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            color : black;
        }
        .dashboard-container button {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            background-color: #191970;
            font-family: "Times New Roman", Times, serif;
            border: none;
            color: white;
            border-radius: 4px;
            cursor: pointer;
        }
        .dashboard-container button:hover {
            background-color:#191970;
        }
    </style>
    <script>
        function setAccountNo(form) {
            var accountNo = document.getElementById("accountNo").value;
            form.accountNo.value = accountNo;
        }
    </script>
</head>
<script>
        function setAccountNo(form) {
            var accountNo = document.getElementById("accountNo").value;
            var username = document.getElementById("username").value;
            form.accountNo.value = accountNo;
            form.username.value = username;
        }
    </script>
</head>
<body>
    <div class="dashboard-container">
        <h1>Welcome, ${username}</h1>
        <label for="accountNo"><h2>Enter Account No:</h2></label>
        <input type="text" id="accountNo" name="accountNo" required>
        <input type="hidden" id="username" name="username" value="${username}">
        
        <form action="AccountServlet" method="post" onsubmit="setAccountNo(this)">
            <input type="hidden" name="accountNo">
            <input type="hidden" name="username">
            <button type="submit"><h2>Account Details</h2></button>
        </form>
        <form action="DepositServlet" method="post" onsubmit="setAccountNo(this)">
            <input type="hidden" name="accountNo">
            <input type="hidden" name="username">
            <button type="submit"><h2>Deposit</h2></button>
        </form>
        <form action="WithdrawServlet" method="post" onsubmit="setAccountNo(this)">
            <input type="hidden" name="accountNo">
            <input type="hidden" name="username">
            <button type="submit"><h2>Withdraw</h2></button>
        </form>
        <form action="TransactionServlet" method="post" onsubmit="setAccountNo(this)">
            <input type="hidden" name="accountNo">
            <input type="hidden" name="username">
            <button type="submit"><h2>Transaction Statements</h2></button>
        </form>
        <form action="LogoutServlet" method="post">
            <button type="submit" class="logout-button"><h2>Logout</h2></button>
        </form>
    </div>
</body>
</html>
</html>