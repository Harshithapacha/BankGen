<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modify or Delete Customer</title>
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
        .modify-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: center;
            font-family: "Times New Roman", Times, serif;
        }
        .modify-container h2 {
            margin-bottom: 20px;
        }
        .modify-container label {
            display: block;
            margin-bottom: 5px;
        }
        .modify-container input[type="text"], .modify-container input[type="email"], .modify-container input[type="date"] {
            width: 80%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .modify-container button {
            width: 100%;
            padding: 10px;
            background-color: #191970;
            border: none;
            color: white;
            border-radius: 4px;
            cursor: pointer;
        }
        .modify-container button:hover {
            background-color: #B0C4DE;
        }
        .delete-button {
            background-color: #191970;
        }
        .delete-button:hover {
            background-color: #B0C4DE;
        }
        .error-message {
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="modify-container">
        <h1>Customer Updation</h1>
        <%-- Display error message if any --%>
        <c:if test="${not empty param.error}">
            <p class="error-message">${param.error}</p>
        </c:if>

        <form action="CustomerModifyServlet" method="post">
            <input type="hidden" name="account_no" value="${param.account_no}">
            
            <label for="full_name">Full Name:</label>
            <input type="text" id="full_name" name="full_name" value="${customer.fullName}" required>
            
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" value="${customer.address}" required>
            
            <label for="mobile_no">Mobile No:</label>
            <input type="text" id="mobile_no" name="mobile_no" value="${customer.mobileNo}" required>
            
            <label for="email_id">Email ID:</label>
            <input type="email" id="email_id" name="email_id" value="${customer.emailId}" required>
            
            <label for="account_type">Account Type:</label>
            <input type="text" id="account_type" name="account_type" value="${customer.accountType}" required>
            
            <label for="dob">Date of Birth:</label>
            <input type="date" id="dob" name="dob" value="${customer.dob}" required>
            
            <label for="id_proof">ID Proof:</label>
            <input type="text" id="id_proof" name="id_proof" value="${customer.idProof}" required>
            
            <button type="submit" name="action" value="modify">Modify</button>
            <p><button type="submit" class="delete-button" name="action" value="delete">Delete</button><p>
        </form>
         <form action="CustomerUpdate.jsp">
            <button type="submit">Back to Dashboard</button>
        </form>
    </div>
</body>
</html>
