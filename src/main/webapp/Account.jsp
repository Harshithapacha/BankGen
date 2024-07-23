<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Details</title>
    <style>
        body {
            font-family: "Times New Roman", Times, serif;
            font-size:18px;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: url('https://static.vecteezy.com/system/resources/previews/010/518/831/non_2x/digital-finance-and-banking-investment-service-in-futuristic-background-bank-building-with-online-growth-graph-investment-secure-money-and-financial-innovation-technology-vector.jpg') no-repeat center center fixed;
            background-size: cover;
        }
        .details-container {
            background-color: Dark blue;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: left;
            color:white;
           
        }
        .details-container h2 {
            margin-bottom: 20px;
            
           
           
        }
        .details-container h1 {
            margin-bottom: 20px;
            text-align: center;
            
            
           
        }
        .details-container p {
            margin-bottom: 5px;
            
         
        }
         .details-container button {
            width: 100%;
            padding: 10px;
            background-color: #191970;
            border: none;
            color: white;
            border-radius: 4px;
            cursor: pointer;
             
        }
        .details-container button:hover {
            background-color: #B0C4DE;
        }
        .message {
            color: green;
            text-align: center;
            margin-bottom: 10px;
             
        }
    </style>
</head>
<body>
    <div class="details-container">
        <h1>Account Details</h1>
        <c:choose>
            <c:when test="${customer != null}">
                <p><strong><h2>Full Name:</h2></strong> ${customer.fullName}</p>
                <p><strong><h2>Address:</h2></strong> ${customer.address}</p>
                <p><strong><h2>Mobile No:</h2></strong> ${customer.mobileNo}</p>
                <p><strong><h2>Email ID:</h2></strong> ${customer.emailId}</p>
                <p><strong><h2>Account Type:</h2></strong> ${customer.accountType}</p>
                <p><strong><h2>Date of Birth:</h2></strong> ${customer.dob}</p>
                <p><strong><h2>ID Proof:</h2></strong> ${customer.idProof}</p>
                <p><strong><h2>Account Number:</h2></strong> ${customer.accountNo}</p>
                <p><strong><h2>Balance:</h2></strong> ${customer.balance}</p>
            </c:when>
            <c:otherwise>
                <p></p>
            </c:otherwise>
        </c:choose>
        <form action="CustomerDash.jsp">
            <button type="submit"><h2>Back to Dashboard</h2></button>
        </form>
    </div>
</body>
</html>
