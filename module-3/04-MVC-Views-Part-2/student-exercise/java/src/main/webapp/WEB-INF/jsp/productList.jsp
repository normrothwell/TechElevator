<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product List View" />
</c:import>

<div id="card-page">
	<c:import url="/WEB-INF/jsp/common/filters.jsp">
		<%-- Modify the baseRoute to apply filters to the current route. --%>
		<c:param name="baseRoute" value="#" />
	</c:import>

	<div class="main-content">
		<!-- Container for Sorting Choices
         
         Each link should take the user to this current page and use any combination of the following
         querystring parameters to sort the page:
            - sortOrder (string) - PriceLowToHigh,PriceHighToLow,RatingHighToLow
    	-->
		<div id="sorting-options">
			<h3>Sort By</h3>
			<ul>
			
			<c:url var = 'priceLowToHigh' value ='/products?sortOrder=PriceLowtoHigh'/>
			<c:url var = 'priceHighToLow' value = '/products?sortOrder=PriceHightoLow'/>
			<c:url var = 'ratingHighToLow' value = '/products?sortOrder=RatingHightoLow'/>
				<li><a href="${priceLowToHigh}">Price - Low to High</a></li>
				<li><a href="${priceHighToLow}">Price - High to Low</a></li>
				<li><a href="${ratingHighToLow}">Rating - High to Low</a></li>
			</ul>
		</div>

	<div id="grid">
	<c:forEach var = "product" items = "${products}">
		<c:choose>
		<c:when test="${product.remainingStock == 0}">
			<div class = "tile sold-out">
			<span class="banner">Sold Out</span>
		</c:when>
		<c:otherwise>
			<div class="tile ">
			<c:if test ="${(product.topSeller)}">
				<span class="banner top-seller">Top Seller!</span>
			</c:if>
		</c:otherwise>
		</c:choose>
			
				<c:url var = 'productId' value = '/products/detail?id=${product.id}'/>
				<a class="product-image" href="${productId}"> 
					<img src="<c:url value="/images/product-images/${product.imageName}" />" />
				</a>
				<div class="details">
					<p class="name">${product.name})</p>

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
						<span class="product-alert">Only ${product.remainingStock} left!</span>
					</c:if>

					<p class="price">$<fmt:formatNumber type = "number" minFractionDigits = "2" maxFractionDigits = "2" value = "${product.price}"/></p>
				</div>
			</div>
	</c:forEach>

	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />