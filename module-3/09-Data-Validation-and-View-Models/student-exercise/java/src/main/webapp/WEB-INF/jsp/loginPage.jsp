<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="common/header.jspf" %>

Login Page<br>
<br>

<c:url var="loginSubmitUrl" value="/loginPage"/>
		<form:form method="POST" action="${loginSubmitUrl}" modelAttribute="loginPage">
			
			<div>
				<label for="email">Email Address</label>
				<form:input path="email"/>
				<form:errors path="email" cssClass="error"/>
			</div>
			<div>
				<label for ="password">Password</label>
				<form:input path="password"/>
				<form:errors path="password" cssClass="error"/>
			
			</div>
			<div>
				<input type="submit" value="Login"/>
			</div>
		</form:form>

<%@include file="common/footer.jspf" %>