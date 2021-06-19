<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="updateLoc" method="post">
		<pre>
		ID: <input type="text" name="id" value="${loclocation.id }" readonly/> 
		CODE: <input type="text" name="code" value="${loclocation.code }"/>
		NAME: <input type="text" name="name" value="${loclocation.name }"/>
		
		TYPE: URBEN<input type="radio" name="type" value="URBEN" ${loclocation.type=='URBEN'?'checked':'' }/>
			  RURAL<input type="radio" name="type" value="RURAL" ${loclocation.type=='RURAL'?'checked':'' }/>
		
		<input type="submit" value="Save" />
		</pre>
	</form>
</body>
</html>