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

<h2>Welcome to Adhya's Banking Application- Contact Us</h2>

<table>
  <tr>
   <td><h2> Email: adhya.dagar@finastra.com </h2></td>
  </tr>
  <tr>
     <td><h2> Mobile: 9971197802 </h2></td>
  </tr>
   <tr>
    <td><h2> Address: Delhi-110015 </h2></td>
  </tr>
</table>
<div style="clear; both;"></div>
			<p><a href="${pageContext.request.contextPath}/customer/welcome">Back</a></p>
</body>
</html>

