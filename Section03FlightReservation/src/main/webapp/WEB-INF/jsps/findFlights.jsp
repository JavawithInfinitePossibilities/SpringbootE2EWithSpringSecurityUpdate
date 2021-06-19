<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="findflights" method="post">
		<pre>
		<h2>Find Flight:</h2>
		From : <input type="text" name="from" /> 
		To : <input type="text" name="to" /> 
		Departure Date : <input type="text" name="departureDate" />
		<input type="submit" value="Search" />
		</pre>
	</form>
</body>
</html>