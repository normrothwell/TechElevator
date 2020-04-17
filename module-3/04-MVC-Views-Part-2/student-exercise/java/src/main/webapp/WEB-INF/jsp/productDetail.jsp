<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product Details" />
</c:import>


<!-- Container for the Product -->

	<div id="product-detail">
	<img src="<c:url value="/images/product-images/${product.imageName}" />" />
	<div class="product-description">
		<h3>${product.name}</h3>

		<!-- .filled will make the star solid -->
		<div class="rating">
						<c:choose>
						<c:when test="${product.averageRating >= 5}">
							<span class="filled">&#9734;</span> 
							<span class="filled">&#9734;</span>
							<span class="filled">&#9734;</span>
							<span class="filled">&#9734;</span>
							<span class="filled">&#9734;</span>
						</c:when>
						<c:when test="${product.averageRating >= 4}">
							<span class="filled">&#9734;</span> 
							<span class="filled">&#9734;</span>
							<span class="filled">&#9734;</span>
							<span class="filled">&#9734;</span>
							<span>&#9734;</span>
						</c:when>
						<c:when test="${product.averageRating >= 3}">
							<span class="filled">&#9734;</span> 
							<span class="filled">&#9734;</span>
							<span class="filled">&#9734;</span>
							<span>&#9734;</span> 
							<span>&#9734;</span>
						</c:when>
						<c:when test="${product.averageRating >= 2}">
							<span class="filled">&#9734;</span> 
							<span class="filled">&#9734;</span>
							<span>&#9734;</span> 
							<span>&#9734;</span> 
							<span>&#9734;</span>
						</c:when>
						<c:when test="${product.averageRating >= 1}">
							<span class="filled">&#9734;</span>
							<span>&#9734;</span> 
							<span>&#9734;</span> 
							<span>&#9734;</span> 
							<span>&#9734;</span>
						</c:when>
						<c:otherwise>
							<span>&#9734;</span> 
							<span>&#9734;</span> 
							<span>&#9734;</span>
							<span>&#9734;</span>
							<span>&#9734;</span>
						</c:otherwise>
						</c:choose>
				</div>

		<c:if test="${product.remainingStock <= 5 && product.remainingStock > 0}">
			<p class="alert-remaining">BUY NOW! Only ${product.remainingStock} left!</p>
		</c:if>
			<p class="description">${product.description}</p>
			
			$<fmt:formatNumber type = "number" minFractionDigits = "2" maxFractionDigits = "2" value = "${product.price}"/>
			
			
		
		<c:if test="${product.remainingStock > 0}">
			<button class="action">Add to Cart</button>
		</c:if>
		<c:if test = "${product.remainingStock == 0}">
			<button class="action">Out of Stock</button>
		</c:if>
		<!-- OR if item is out of stock -->
		<!--<button disabled>Sold Out</button>-->
	</div>
</div>


<!-- The current product is available using the `product` variable -->



<c:import url="/WEB-INF/jsp/common/footer.jsp" />