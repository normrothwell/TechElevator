<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Page</title>
</head>
<body>
<h1>All Employees</h1>
<table>
<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Company Email</th>
	<th>Contact Email</th>
	<th>Hired Date</th>
	<th>Birth Date</th>
	<th>Address Info</th>
</tr>


<c:forEach items = "${allEmployees}" var="employee">
<tr>
	<td>${employee.firstName}</td>
	<td>${employee.lastName}</td>
	<td>${employee.companyEmail}</td>
	<td>${employee.contactEmail}</td>
	<td>${employee.hiredDate}</td>
	<td>${employee.birthDate}</td>
	<td>
</tr>
</c:forEach>
</table>
</body>
</html>