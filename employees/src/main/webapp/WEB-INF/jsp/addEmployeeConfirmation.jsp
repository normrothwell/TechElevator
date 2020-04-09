<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Confirmation</title>
</head>
<body>
You have successfully added an employee.<p>

		<c:url value="/home" var="homeUrl" />
		<a style = "button" href="${homeUrl}">Go back home</a>
		
</body>
</html>