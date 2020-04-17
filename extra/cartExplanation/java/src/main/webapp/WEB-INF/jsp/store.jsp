<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Store Front</title>
</head>
<body>

	<h1>Completely Legit Gift Shop</h1>

	<table>
		<c:forEach items='${itemsForSale}' var='storeItem'>
			<tr>
				<td><c:url value='/detail' var='detailUrl'>
						<c:param name='id' value='${storeItem.id}' />
					</c:url> <a href='${detailUrl}'> Buy! </a> <br>
				</td>

				<td style='border: 1px solid black;'>
				${storeItem.name}<br> 
				${storeItem.description}<br>
				${storeItem.price}<br> 
					<c:url value="img/${storeItem.imageName}" var='imageUrl' /> 
					<img src='${imageUrl}' height='200px' width='200px' /> 
					<br>
				</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>