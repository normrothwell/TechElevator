<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Container for Filter Choices
        Each link should take the user to this current page and use any combination of the following
        querystring parameters to filter the page:
        - maxPrice (number)
        - minPrice (number)
        - minRating (number)
        - category (string) - Home, Apparel, Jewelry, Garden

        NOTE: A parameter is passed to this view that is called `baseRoute`. `baseRoute`
        refers to the page that the filters should be associated with. For instance, if you are on the products
        page, the value of the `baseRoute` should be the route for products and on the tiles page, should be the
        route for tiles.
        -->
<div id="filter-options">
	<h3>Refine By</h3>
	<ul>
		<c:url value='/products' var='twentyFiveToFifty'>
			<c:param name = 'minPrice' value = '25'/>
			<c:param name = 'maxPrice' value = '50'/>
		</c:url>
		<c:url value='/products' var='underTwentyFive'>
			<c:param name = 'maxPrice' value = '25'/>
		</c:url>
		<c:url value = '/products' var='greaterThanFifty'>
			<c:param name = 'minPrice' value = '50'/>
		</c:url>
		<li><a href="${underTwentyFive}">Under $25</a></li>
		<li><a href="${twentyFiveToFifty}">$25 to $50</a></li>
		<li><a href="${greaterThanFifty}">$50 &amp; Above</a></li>
	</ul>
	<p>Avg. Review</p>
	<ul>
	
		<c:url value ='/products' var='greaterThanFour'>
			<c:param name = 'minRating' value = '4'/>
		</c:url>
		<c:url value ='/products' var='greaterThanThree'>
			<c:param name = 'minRating' value = '3'/>
		</c:url>
		<c:url value ='/products' var='greaterThanTwo'>
			<c:param name = 'minRating' value = '2'/>
		</c:url>
		<c:url value ='/products' var='greaterThanOne'>
			<c:param name = 'minRaint' value = '1'/>
		</c:url>
		<li>
			<a class="rating" href="${greaterThanFour}">
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span>&#9734;</span> &amp; Up
			</a>
		</li>
		<li>
			<a class="rating" href="${greaterThanThree}">
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span> &amp; Up
			</a>
		</li>
		<li>
			<a class="rating" href="${greaterThanTwo}">
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span> &amp; Up
			</a>
		</li>
		<li>
			<a class="rating" href="${greaterThanOne}">
				<span class="filled">&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span> &amp; Up
			</a>
		</li>
	</ul>
	<p>Category</p>
		<c:url value ='/products' var='getHome'>
			<c:param name = 'category' value = 'Home'/>
		</c:url>
		<c:url value ='/products' var='getApparel'>
			<c:param name = 'category' value = 'Apparel'/>
		</c:url>
		<c:url value ='/products' var='getJewelry'>
			<c:param name = 'category' value = 'Jewelry'/>
		</c:url>
		<c:url value ='/products' var='getGarden'>
			<c:param name = 'category' value = 'Garden'/>
		</c:url>
	<ul>
		<li><a href="${getHome}">Home</a></li>
		<li><a href="${getApparel}">Apparel</a></li>
		<li><a href="${getJewelry}">Jewelry</a></li>
		<li><a href="${getGarden}">Garden</a></li>
	</ul>
</div>
 