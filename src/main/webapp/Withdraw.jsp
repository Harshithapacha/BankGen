<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Withdraw</title>
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
        .form-container {
            background-color:Dark blue;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: center;
            font-family: "Times New Roman", Times, serif;
            color:white;
        }
        .form-container h2 {
            margin-bottom: 20px;
            
        }
        .form-container label {
            display: block;
            margin-bottom: 10px;
        }
        .form-container input[type="number"], .form-container input[type="text"] {
            width: 95%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-family: "Times New Roman", Times, serif;
        }
        .form-container button {
            width: 100%;
            padding: 10px;
            background-color: #191970;
            border: none;
            color: white;
            border-radius: 4px;
            cursor: pointer;
            font-family: "Times New Roman", Times, serif;
        }
        .form-container button:hover {
            background-color: #B0C4DE;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h1>Withdraw Amount</h1>
        <%-- Display errors if any --%>
        <%--- <c:if test="${not empty error}">
            <p style="color: red;">${error}</p>
        </c:if>---%>
        <%-- Display success message if any --%>
        <c:if test="${not empty message}">
            <p style="color: green;">${message}</p>
        </c:if>
        <form action="WithdrawServlet" method="post">
            <input type="hidden" name="accountNo" value="${param.accountNo}">
            <input type="number" name="amount" step="0.01" placeholder="Enter Amount" required>
            <button type="submit"><h2>Withdraw</h2></button>
        </form><br>
        <form action="CustomerDash.jsp">
            <button type="submit"><h2>Back to Dashboard</h2></button>
        </form>
    </div>
</body>
</html>
