<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
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
            background-color: Dark blue;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: center;
            color: white;
        }
        .dashboard-container h2 {
            margin-bottom: 20px;
        }
        .dashboard-container button {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            background-color:#1E90FF;
            font-family: "Times New Roman", Times, serif;
            border: none;
            color: white;
            border-radius: 4px;
            cursor: pointer;
        }
        .dashboard-container button:hover {
            background-color:  #191970;
        }
        .logout-button {
            background-color: #191970;
        }
        .logout-button:hover {
            background-color:  #191970;
        }
    </style>
</head>
<body>
    <div class="dashboard-container">
        <h1>Admin Dashboard</h1>
        <form action="CustomerRegServlet" method="post">
            <button type="submit"><h2>Customer Registration</h2></button>
        </form>
        <form action="CustomerDetailsServlet" method="post">
            <button type="submit"><h2>Customer Updation</h2></button>
        </form>
        <form action="LogoutServlet" method="post">
            <button type="submit" class="logout-button"><h2>Logout</h2></button>
        </form>
        
    </div>
</body>
</html>
