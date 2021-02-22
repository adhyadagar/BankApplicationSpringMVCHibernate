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
		<title>Registering New Customer</title>
	</head>
	
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Creating New Customer</h2>
			</div>
		</div>
		
		<div id="container">
			<h3>Register Customer</h3>
			<form:form action="registerCustomer" modelAttribute="customer" method="POST"> 
			<!-- Right now this is sending data over to saveCustomer -->
			<form:hidden path = "id" />
				<table>
					<tbody>
						<tr>
							<td><label>First Name: </label></td>
							<td><form:input path="firstName" type="text" name="firstName" required="required" pattern="[A-Za-z0-9]{1,15}"/></td>
						</tr>
						<tr>
							<td><label>Last Name: </label></td>
							<td><form:input path="lastName" type="text" name="lastName" required="required" pattern="[A-Za-z0-9]{1,15}"/></td>
						</tr>
						<tr>
							<td><label>Email: </label></td>
							<td><form:input path="email" type="email" name="email" required="required" /></td>
						</tr>
						<tr>
							<td><label>Mobile: </label></td>
							<td><form:input path="mobile" type="number" name="mobile" required="required"/></td>
						</tr>
						<tr>
							<td><label>User Name: </label></td>
							<td><form:input path="userName" type="text" name="userName" required="required" pattern="[A-Za-z0-9]{1,15}"/></td>
						</tr>
						<tr>
							<td><label>Password: </label></td>
							<td><form:input path="password" type="password" name="password" required="required" pattern="[A-Za-z0-9]{8,15}"/></td>
						</tr>
						<tr>							
							<td><input type="submit" value="Register"></td> <!--onclick="window.location.href='registerCustomer';"  -->
						</tr>
					</tbody>
				</table>
			</form:form>
			<div style="clear; both;"></div>
			<p><a href="${pageContext.request.contextPath}/customer/welcome">Back</a></p>
			<p> Already a user? <a href = "${pageContext.request.contextPath}/customer/login"> Sign In</a> </p>
		</div>
	</body>
</html>