<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete reservation</title>
</head>
<body>
	<pre>
	<h1>Complete Reservation</h1>
	Airlines : ${flight.operationAirlines } <br /> 
	Departure City : ${flight.departureCity } <br /> 
	Arrival City : ${flight.arrivalCity } <br />
	</pre>
	<form action="completeReservation" method="post">
		<pre>
		<h2>Passenger Details :</h2>
		First Name : <input type="text" name="passengerName" /> 
		Last Name : <input type="text" name="passengerLastName" /> 
		Email : <input type="text" name="passengerEmail" /> 
		Phone : <input type="text" name="passengerPhone" />

		<h2>Card Details :</h2>
		Name On The Card : <input type="text" name="nameOnTheCard" /> 
		The Card Number : <input type="text" name="theCardNumber" /> 
		The Card Expiry Date : <input type="text" name="theCardExpiryDate" /> 
		The Card CVV Number : <input type="text" name="theCardCVVNumber" /> 
		
		<input type="hidden" name="flightId" value="${flight.id}">
		<input type="submit" value="Confirm" />	
		</pre>
	</form>
</body>
</html>