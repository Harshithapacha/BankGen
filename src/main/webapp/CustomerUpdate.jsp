<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Enter Account Number</title>
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
        .entry-container {
            background-color: Dark blue;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: center;
            font-family: "Times New Roman", Times, serif;
            color:white;
        }
        .entry-container h1 {
            margin-bottom: 20px;
            
        }
        .entry-container label {
            display: block;
            margin-bottom: 5px;
          
            
        }
        .entry-container input[type="text"] {
            width: 90%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
           
        }
        .entry-container button {
            width: 100%;
            padding: 10px;
            background-color: #191970;
            border: none;
            color: white;
            border-radius: 4px;
            cursor: pointer;
            
        }
        .entry-container button:hover {
            background-color: #B0C4DE;
        }
    </style>
</head>
<body>
    <div class="entry-container">
        <h2>Enter Account Number</h2>
        <form action="CustomerDetailsServlet" method="post">
            <label for="account_no"></label>
            <input type="text" id="account_no" name="account_no" required>
            <button type="submit"><h2>Submit</h2></button>
        </form>
        <p>
        <form action="adminDash.jsp" method="get">
            <button type="submit" class="back-button"><h2>Back to Dashboard</h2></button>
        </form>
    </div>
</body>
</html>
