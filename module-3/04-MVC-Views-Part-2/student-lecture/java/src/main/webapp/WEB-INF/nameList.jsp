<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Name List Example</title>
	</head>
	<body>
		<p>We are getting a list from Java called requestScope.nameList.</p>
		
		<ol>
			<c:forEach var = "name" items = "${requestScope.nameList}">
				<li><c:out value = " ${name}"/> </li>
			</c:forEach>
		</ol>
	</body>
</html>