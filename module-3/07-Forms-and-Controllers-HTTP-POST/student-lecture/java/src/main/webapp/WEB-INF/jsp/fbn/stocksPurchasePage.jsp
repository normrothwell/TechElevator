<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/fbn/common/header.jsp">
	<c:param name="subTitle">Stocks</c:param>
</c:import>

How many shares of <strong><c:out value="${param.ticker}"/></strong> do you want to buy?
<c:url var="purchaseUrl" value="/fbn/stockPurchase"/>
<form>
	<input type="hidden" name="ticker" value="${param.ticker}">
	<input type="number" name="shares">
	<input type="submit" value="Buy">
</form>

<c:import url="/WEB-INF/jsp/fbn/common/footer.jsp" />