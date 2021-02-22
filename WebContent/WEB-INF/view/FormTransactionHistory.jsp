<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<meta charset="ISO-8859-1">
<title>View Transaction History</title>
</head>
<body>
			<!--  <H1> List of Customers coming SOON !!</H1> -->
			
			<div id="wrapper">
				<div id="header">
					<h2>View Transaction History</h2>
				</div>
			</div>
			<div id="container">
					<div id="content">
						<!--  Having the actual Table -->
						<table>
							<tr>
								<th> Operation </th>
								<th> Balance </th>
								<th> Time </th>
							</tr>
							
							<!--  Iterate through loop to display Customers -->
							<c:forEach var="tempTransaction" items="${transactionsList}">
							
							<!--  Creating Update link with Customer ID embedded -->							
							
								<tr>
										<td>${tempTransaction.operation} </td>
										<td>${tempTransaction.newBalance} </td>
										<td>${tempTransaction.timeDetails} </td>
		
								</tr>
							
							</c:forEach>
							
						</table>
					
					</div>
		
			</div>
			<div style="clear; both;"></div>
			<p><a href="${pageContext.request.contextPath}/bank/operations">Back</a></p>
</body>
</html>