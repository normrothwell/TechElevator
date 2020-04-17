<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="common/header.jsp">
	<c:param name="title" value="Echo"></c:param>
</c:import>

<nav id="page-options">
	<ul>
		<c:set var="routeCount" value="10" />
		<c:set var="routeWord" value="Echo" />
		<c:url var="echoRoute" value="echo.jsp">
			<c:param value="${ routeCount }" name="count" />
			<c:param value="${ routeWord }" name="word" />
		</c:url>
		<li>
			<a href="<c:out value="${ echoRoute }" />">${ routeWord } ${ routeCount }</a>
		</li>

		<c:set var="routeCount" value="20" />
		<c:set var="routeWord" value="Hello!" />
		<c:url var="echoRoute" value="echo.jsp">
			<c:param value="${ routeCount }" name="count" />
			<c:param value="${ routeWord }" name="word" />
		</c:url>
		<li>
			<a href="<c:out value="${ echoRoute }" />">${ routeWord } ${ routeCount }</a>
		</li>

		<c:set var="routeCount" value="50" />
		<c:set var="routeWord" value="Goodbye!" />
		<c:url var="echoRoute" value="echo.jsp">
			<c:param value="${ routeCount }" name="count" />
			<c:param value="${ routeWord }" name="word" />
		</c:url>
		<li>
			<a href="<c:out value="${ echoRoute }" />">${ routeWord } ${ routeCount }</a>
		</li>
	</ul>
</nav>

<c:set var="size" value="${param.count}"/>

<ul>

<c:choose>
			<c:when test="${empty param.word}">
				<c:set var="word" value="World" />
			</c:when>
			<c:otherwise>
				<c:set var="word" value="${param.word}" />
			</c:otherwise>
		</c:choose>


<c:forEach begin = "1" end = "${param.count}">

  <li style="font-size: ${size}px;">${word}</li>
  <c:set var="size" value="${(size-1)}"/>

</c:forEach>
</ul>

<c:import url="common/footer.jsp"></c:import>