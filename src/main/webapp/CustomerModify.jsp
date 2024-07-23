<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Updation</title>
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
        .update-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: center;
            font-family: "Times New Roman", Times, serif;
        }
        .update-container h1 {
            margin-bottom: 20px;
        }
        .update-container input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .update-container button {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            background-color: #191970;
            border: none;
            color: white;
            border-radius: 4px;
            cursor: pointer;
        }
        .update-container button:hover {
            background-color: #B0C4DE;
        }
        .delete-button {
            background-color: #191970;
        }
        .delete-button:hover {
            background-color: #B0C4DE;
        }
    </style>
</head>
<body>
    <div class="update-container">
        <h1>Customer Updation</h1>
        <form action="CustomerModifyServlet" method="post">
            <input type="text" name="account_no" placeholder="Account Number" required>
            <input type="text" name="full_name" placeholder="Full Name" required>
            <input type="text" name="email_id" placeholder="Email ID" required>
            <input type="text" name="mobile_no" placeholder="Mobile Number" required>
            <input type="text" name="address" placeholder="Address" required>
            <input type="text" name="account_type" placeholder="Account Type" required>
            <input type="text" name="dob" placeholder="Date of Birth" required>
            <input type="text" name="id_proof" placeholder="ID Proof" required>
            <input type="hidden" name="action" value="modify">
            <button type="submit">Modify</button>
        </form>
        <form action="CustomerModifyServlet" method="post">
            <input type="hidden" name="account_no" value="${param.account_no}">
            <input type="hidden" name="action" value="delete">
            <button type="submit" class="delete-button">Delete</button>
        </form>
        <% String message = request.getParameter("message");
           if (message != null) {
               if (message.equals("updateSuccess")) { %>
                   <p style="color:green; text-align:center;">Details Modified Successfully!</p>
               <% } else if (message.equals("deleteSuccess")) { %>
                   <p style="color:green; text-align:center;">Account Deleted Successfully!</p>
               <% } else if (message.equals("updateFail")) { %>
                   <p style="color:red; text-align:center;">Failed to Update Customer Details</p>
               <% } else if (message.equals("deleteFail")) { %>
                   <p style="color:red; text-align:center;">Failed to Delete Customer</p>
               <% }
           } %>
    </div>
</body>
</html>
