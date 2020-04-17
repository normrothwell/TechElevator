<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product Tile View" />
</c:import>

<div id="masonry-page">
	<c:import url="/WEB-INF/jsp/common/filters.jsp">
		<%-- Modify the baseRoute to apply filters to the current route. --%>
		<c:param name="baseRoute" value="#" />
	</c:import>

	<!-- Container for all of the Products -->
	<!-- The list of products is available using the `products` variable -->
	<div id="grid" class="main-content">
	
	
	<c:forEach var = "product" items = "${products}">
		<c:choose>
		<c:when test ="${product.remainingStock == 0}">
			<div class="tile sold-out">
			<span class="banner">Sold Out</span>
		</c:when>
		<c:when test="${(product.topSeller)}">
			<div class = "tile top-seller">
		</c:when>
		<c:otherwise>
			<div class="tile ">
		</c:otherwise>
		</c:choose>
				
				<c:url var = 'productId' value = '/products/detail?id=${product.id}'/>
				<a class="product-image" href="${productId}"> 
					<img src="<c:url value="/images/product-images/${product.imageName}" />" />
				</a>
				<div class="details">
					<p class="name">
					<a href="#">${product.name}</a>
					</p>

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
					
					<c:if test ="${(product.topSeller)}">
						<p class="product-alert">Top Seller</p>
					</c:if>
					<c:if test="${product.remainingStock <= 5 && product.remainingStock > 0}">
						<span class="product-alert">Only ${product.remainingStock} left!</span>
					</c:if>

					<p class="price">$<fmt:formatNumber type = "number" minFractionDigits = "2" maxFractionDigits = "2" value = "${product.price}"/></p>
				</div>
			</div>
	</c:forEach>
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />