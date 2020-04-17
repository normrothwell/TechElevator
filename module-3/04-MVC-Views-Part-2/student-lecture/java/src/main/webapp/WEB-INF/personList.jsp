<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Name List Example</title>
	</head>
	<body>
		<p>We are getting a list from Java called personList.</p>
		
		<table>

			<c:forEach var = "person" items = "${personList}">
				<tr><c:out value = "${person.firstName}"/></tr>
				<tr><c:out value = " ${person.lastName}"/></tr>
				<tr><c:out value = " ${person.age}"/></tr>
				<tr><c:out value = " ${person.adult}"/></tr>
				<p>
			</c:forEach>
		
		</table> 
		
		<table>
		
			<tr>
				<th> First Name</th>
				<th> Last Name</th>
				<th> Age </th>
				<th> Is Adult </th>
			</tr>
			<c:forEach var = "person" items = "${personList}">
				<tr>
					<td><c:out value = "${person.firstName}"/></td>
					<td><c:out value = " ${person.lastName}"/></td>
					<td><c:out value = " ${person.age}"/></td>
					<td><c:out value = " ${person.adult}"/>
				</tr>
			</c:forEach>
		
		</table>
	</body>
</html>