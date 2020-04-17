<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
</head>
<body>
<p>Learn more about how your money is being wasted.</p>

<c:url value="img/${product.imageName}" var='imageUrl' />
<img src='${imageUrl}' width='250px' height='250px'> <br>
${product.name}
${product.description}

<c:url value='/shoppingCart' var='shoppingCartURL' />
<form action='${shoppingCartURL}' method='POST'>

	<input  type="text" name="quantity"/>
	<input type="hidden" name= 'productId' value="${product.id}"/>
	<input class="formSubmitButton" type="submit" value="BUY!" />
	
</form>

</body>
</html>