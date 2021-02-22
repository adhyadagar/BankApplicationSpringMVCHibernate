<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
h2{
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #F7E6FF;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #F7E6FF;
}
</style>
</head>
<body>

<h2>Welcome to Adhya's Banking Application - Operations Menu</h2>

<table>

 <tr>
    <td><a href = "/WebApplicationBankAdhya/bank/create">Create Account</a> </td>
  </tr>
 <tr>
    <td><a href = "/WebApplicationBankAdhya/bank/deposit">Deposit Amount</a> </td>
  </tr>
  <tr>
    <td> <a href = "/WebApplicationBankAdhya/bank/withdraw">Withdraw Amount</a></td>
  </tr>
  <tr>
     <td><a href="/WebApplicationBankAdhya/bank/transfer">Transfer Amount</a></td>
  </tr>
    <tr>
     <td><a href="/WebApplicationBankAdhya/bank/current">Current Balance</a></td>
  </tr>
      <tr>
     <td><a href="/WebApplicationBankAdhya/bank/transaction">Transaction History</a></td>
  </tr>
      <tr>
     <td><a href="/WebApplicationBankAdhya/bank/viewAllAccounts">View All Accounts</a></td>
  </tr>
    <tr>
     <td><a href="/WebApplicationBankAdhya/bank/close">Close Account</a></td>
  </tr>
  
   <tr>
    <td><a href="${pageContext.request.contextPath}/bank/logout">Logout</a></td>
  </tr>
</table>

</body>
</html>
