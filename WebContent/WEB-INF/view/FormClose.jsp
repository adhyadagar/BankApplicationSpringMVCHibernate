<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Close Account</title>
	</head>
	
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Adhya's Bank Application Close Account Page</h2>
			</div>
		</div>
		
		<div id="container">
			<h3>Close your account</h3>
			<form action="closeAccount"  method="POST"> 
			<!-- Right now this is sending data over to saveCustomer -->	
				<table>
					<tbody>
						<tr>
							<td><label>Account Number: </label></td>
							<td><input type="number" name="accountNumber" required="required"  pattern="[0-9]{10}"/></td>
						</tr>
						<tr>							
							<td><input type="submit" value="Close Account" /></td>
						</tr>
					</tbody>
				</table>
			</form>
			
			<div style="clear; both;"></div>
			<p><a href="${pageContext.request.contextPath}/bank/operations">Back</a></p>
		</div>
	</body>
</html>