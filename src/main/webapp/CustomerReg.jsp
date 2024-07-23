<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Registration</title>
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
        .registration-container {
            background-color: Dark blue;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            color: white;
        }
        .registration-container h1 {
            margin-bottom: 20px;
            text-align: center;
        }
        .registration-container label {
            display: block;
            margin-bottom: 5px;
        }
        .registration-container input[type="text"], .registration-container input[type="password"], .registration-container input[type="email"], .registration-container input[type="date"] {
           width: 90%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            color: black;
            
        }
        .registration-container button {
            width: 95%;
            padding: 10px;
            background-color: #1E90FF;
            font-family: "Times New Roman", Times, serif;
            border: none;
            color: white;
            border-radius: 4px;
            cursor: pointer;
            font-size: 18px;
        }
        .registration-container button:hover {
            background-color: #191970;
        }
        .dashboard-link {
            display: block;
            text-align: center;
            margin-top: 20px;
        }
        .dashboard-link button {
            width: 95%;
            padding: 9px;
            background-color: #191970;
            font-family: "Times New Roman", Times, serif;
            border: none;
            color: white;
            border-radius: 3px;
            cursor: pointer;
            font-size: 18px;
        }
        .dashboard-link button:hover {
            background-color: #191970;
        }
    </style>
</head>
<body>
    <div class="registration-container">
        <h1>Customer Registration</h1>
        <form action="CustomerRegServlet" method="post">
        
        
            <label for="full_name">Full Name:</label>
            <input type="text" id="full_name" name="full_name" required>

            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required>

            <label for="mobile_no">Mobile No:</label>
            <input type="text" id="mobile_no" name="mobile_no" required>

            <label for="email_id">Email ID:</label>
            <input type="email" id="email_id" name="email_id" required>

            <label for="account_type">Account Type:</label>
            <input type="text" id="account_type" name="account_type" required>

            <label for="dob">Date of Birth:</label>
            <input type="date" id="dob" name="dob" required>

            <label for="id_proof">ID Proof:</label>
            <input type="text" id="id_proof" name="id_proof" required>

            <button type="submit">Register</button>
            
        </form>
        

        <div class="dashboard-link">
            <form action="adminDash.jsp" method="get">
                <button type="submit">Back to Dashboard</button>
            </form>
        </div>
    </div>
</body>
</html>
