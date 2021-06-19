<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
	<pre>
	<h2>Flight Details :</h2>

	Airlines : ${reservation.flight.operationAirlines } 
	Flight Number : ${reservation.flight.flightNumber } 
	Departure City : ${reservation.flight.departureCity } 
	Arrival City : ${reservation.flight.arrivalCity } 
	Date Of Departure : ${reservation.flight.dateOfDeparture } 
	Estimated Departure Time : ${reservation.flight.estimatedDepartureTime }
	
	<h2>Passenger Details :</h2>
	
	Passenger First Name : ${reservation.passenger.firstName } 
	Passenger Last Name : ${reservation.passenger.lastname } 
	Passenger Middle Name : ${reservation.passenger.middleName } 
	Passenger Phone : ${reservation.passenger.phone } 
	Passenger Email : ${reservation.passenger.email } 
	</pre>
	<form action="completeCheckin" method="post">
		<pre>
		Please enter the number of bags carrying : <input type="text"
				name="numberOfBags" />
		<input type="hidden" value="${reservation.id }" name="reservationId"/>
		<input type="submit" value="Check In" />
	    </pre>
	</form>
</body>
</html>