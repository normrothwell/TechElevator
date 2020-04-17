<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GIFFY wrapper</title>
</head>
<body>
<c:forEach items="${listOfGifs}" var="element"> 
    <img src=${element}><br>
</c:forEach>
</body>
</html>