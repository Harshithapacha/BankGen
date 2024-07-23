<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Success</title>
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
        .success-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: center;
            font-family: "Times New Roman", Times, serif;
        }
        .success-container h1 {
            margin-bottom: 20px;
        }
        .success-container p {
            margin-bottom: 10px;
        }
        .success-container button {
            padding: 10px;
          
            background-color:#191970;
            border: none;
            color: white;
            border-radius: 4px;
            cursor: pointer;
        }
        .success-container button:hover {
            background-color: Dark blue;
        }
    </style>
</head>
<body>
    <div class="success-container">
        <h1>Registration Successful!</h1>
        <p><h2>Account Number: ${accountNumber}</h2></p>
        <p><h2>Temporary Password: ${tempPassword}</h2></p>
        
        <form action="adminDash.jsp">
            <button type="submit"><h2>Back to Dashboard</h2></button>
        </form>
    </div>
</body>
</html>
