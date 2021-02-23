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
	  border: 1px solid #F7E6FF;
	   background-color: #F7E6FF;
	  text-align: left;
	  padding: 8px;
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
<meta charset="ISO-8859-1">
<title>Transfer Failed</title>
</head>
<body>
<h2> Your transfer failed!</h2>
<h2>Please enter the correct sender and receiver account number and make sure that your account balance is greater than or equal to the sum you want to transfer!</h2>
<p><a href="${pageContext.request.contextPath}/bank/transfer">Back</a></p>
</body>
</html>