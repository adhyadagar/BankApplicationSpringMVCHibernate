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

tr:nth-child(odd) {
  background-color: #F7E6FF;
}
</style>
</head>
<body>

<h2>Welcome to Adhya's Banking Application- About Us</h2>

<table>
  <tr>
     <td><h2>Established since 1990. </h2></td>
  </tr>
   <tr>
    <td><h2> Adhya's Bank is one of the largest fintech companies in the world.</h2></td>
  </tr>
  <tr>
    <td><h2>Offering the broadest portfolio of solutions for financial institutions of all sizes.</h2></td>
  </tr>
 
</table>
<div style="clear; both;"></div>
			<p><a href="${pageContext.request.contextPath}/customer/welcome">Back</a></p>
</body>
</html>