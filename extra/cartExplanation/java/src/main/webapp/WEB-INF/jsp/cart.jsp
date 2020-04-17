<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart!</title>


<c:url value='css/solarsystemgeek.css' var='cssUrl' />
<link rel='stylesheet' href='${cssUrl}'/>
</head>
<body>

	<table>
		<c:forEach items='${cart.orderItems}' var='orderItem'>
			<tr>
				<td>product name: ${orderItem.productName}</td>
				<td>quantity: ${orderItem.quantity}</td>
			</tr>
		</c:forEach>
	</table>
	
	<c:url var='shopUrl' value='/'/>
	<c:url var='finishUrl' value='/finish'/>	
	<c:url var='clearUrl' value='/clear'/>
	<a href="${shopUrl}"> Keep Shopping! </a><br>
	<a href="${finishUrl}"> Finalize Order </a><br>
	<a href="${clearUrl}"> Start Over</a>
	
</body>
</html>