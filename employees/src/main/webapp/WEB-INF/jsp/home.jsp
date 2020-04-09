<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

		<c:url value="/employee" var="employeeUrl" />
		<a style = "button" href="${employeeUrl}">View all Employees</a><p>
		<c:url value="/addEmployee" var="addEmployeeUrl" />
		<a style = "button" href="${addEmployeeUrl}">Add an Employee</a>

</body>