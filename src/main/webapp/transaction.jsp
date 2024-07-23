<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="BankingView.Transaction" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transaction Statements</title>
    <style>
        body {
            font-family: "Times New Roman", Times, serif;
            line-height: 1.6;
            background: url('https://static.vecteezy.com/system/resources/previews/010/518/831/non_2x/digital-finance-and-banking-investment-service-in-futuristic-background-bank-building-with-online-growth-graph-investment-secure-money-and-financial-innovation-technology-vector.jpg') no-repeat center center fixed;
            background-size: cover;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 800px;
            margin: auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        .pdf-link {
            display: block;
            text-align: center;
            margin-top: 20px;
        }

        .pdf-link a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #191970;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }

        .pdf-link a:hover {
            background-color: #B0C4DE;
        }
        .dashboard-link {
            display: block;
            text-align: center;
            margin-top: 20px;
        }

        .dashboard-link a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #191970;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }

        .dashboard-link a:hover {
            background-color: #B0C4DE;
        }
    </style>
    <!-- Include jsPDF -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.24/jspdf.plugin.autotable.min.js"></script>
</head>
<body>
    <div class="container">
        <h1>Statement for Account Number: <%= session.getAttribute("accountNo") %></h1>

        <table id="statementTable">
            <thead>
                <tr>
                    <th>Transaction ID</th>
                    <th>Account No.</th>
                    <th>Amount</th>
                    <th>Transaction Type</th>
                    <th>Timestamp</th>
                </tr>
            </thead>
            <tbody>
                <%  
                    List<Transaction> transactions = (List<Transaction>) session.getAttribute("transactions");

                    if (transactions != null) {
                        for (Transaction transaction : transactions) {
                %>
                <tr>
                    <td><%= transaction.getTransactionId() %></td>
                    <td><%= transaction.getAccountNo() %></td>
                    <td><%= transaction.getAmount().setScale(2, java.math.RoundingMode.HALF_UP) %></td>
                    <td><%= transaction.getTransactionType() %></td>
                    <td><%= transaction.getTimestamp().toString() %></td>
                </tr>
                <%  
                        }
                    } else {
                %>
                <tr>
                    <td colspan="5">No transactions found.</td>
                </tr>
                <%  
                    }
                %>
            </tbody>
        </table>

        <div class="pdf-link">
            <a href="#" id="downloadPdf">Download as PDF</a>
        </div>
         <div class="dashboard-link">
            <a href="CustomerDash.jsp">Back to Dashboard</a>
        </div>
    </div>

    <script>
        document.getElementById('downloadPdf').addEventListener('click', function(event) {
            event.preventDefault();

            const { jsPDF } = window.jspdf;
            const doc = new jsPDF();
            doc.autoTable({ html: '#statementTable' });
            doc.save('statement.pdf');
        });
    </script>
    
</body>
</html>
