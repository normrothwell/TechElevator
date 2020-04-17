<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="common/header.jsp">
	<c:param name="title" value="Fibonacci"></c:param>
</c:import>

<nav id="page-options">
	<ul>
		<c:set var="numberOfItems" value="20" />
		<c:url var="fibonacciRoute" value="fibonacci.jsp">
			<c:param value="${ numberOfItems }" name="max" />
		</c:url>
		<li>
			<a href="<c:out value="${ fibonacciRoute }" />"><c:out value="${ numberOfItems }" /></a>
		</li>

		<c:set var="numberOfItems" value="50" />
		<c:url var="fibonacciRoute" value="fibonacci.jsp">
			<c:param value="${ numberOfItems }" name="max" />
		</c:url>
		<li>
			<a href="<c:out value="${ fibonacciRoute }" />"><c:out value="${ numberOfItems }" /></a>
		</li>

		<c:set var="numberOfItems" value="100" />
		<c:url var="fibonacciRoute" value="fibonacci.jsp">
			<c:param value="${ numberOfItems }" name="max" />
		</c:url>
		<li>
			<a href="<c:out value="${ fibonacciRoute }" />"><c:out value="${ numberOfItems }" /></a>
		</li>
	</ul>
</nav>


The default value is: <c:out value="${param.max }" />

<ul>

	<c:set var="a" value = "0"/>
	<c:set var="b" value = "1"/>
	<li>${a}</li>
	<li>${b}</li>
	


	<c:forEach begin="3" end="20">
			
			<c:set var="c" value="${a+b}"/>
			<c:set var="a" value="${b}"/>
			<c:set var="b" value="${c}"/>
			
			<c:if test = "${c <= param.max}">
				<li>${c}</li>
			</c:if>
	</c:forEach>
</ul>

<c:import url="common/footer.jsp"></c:import>