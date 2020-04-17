<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="common/header.jspf" %>

Registration Page<br>
<br>

<c:url var="registrationSubmitUrl" value="/registrationPage"/>
		<form:form method="POST" action="${registrationSubmitUrl}" modelAttribute="registrationPage">
			
			<div>
				<label for="firstName">First Name</label>
				<form:input path="firstName"/>
				<form:errors path="firstName" cssClass="error"/>
			</div>
			<div>
				<label for="lastName">Last Name</label>
				<form:input path="lastName"/>
				<form:errors path="lastName" cssClass="error"/>
			</div>
			<div>
				<label for="email">Email Address</label>
				<form:input path="email"/>
				<form:errors path="email" cssClass="error"/>
			</div>
			<div>
				<label for="emailConfirm">Confirm Email Address</label>
				<form:input path="emailConfirm"/>
				<form:errors path="emailConfirm" cssClass="error"/>
			</div>
			<div>
				<label for ="password">Password</label>
				<form:input path="password"/>
				<form:errors path="password" cssClass="error"/>
			</div>
			<div>
				<label for ="passwordConfirm">Confirm Password</label>
				<form:input path="passwordConfirm"/>
				<form:errors path="passwordConfirm" cssClass="error"/>
			</div>
			<div>
				<label for="birthDate">Birth Date dd/mm/yyyy</label>
				<form:input path="birthDate"/>
				<form:errors path="birthDate" cssClass="error"/>
			</div>
			<div>
				<label for="numTickets">Number of Tickets</label>
				<form:input path="numTickets"/>
				<form:errors path="numTickets" cssClass="error"/>
			</div>
			<div>
				<input type="submit" value="Register"/>
			</div>
		</form:form>

<%@include file="common/footer.jspf" %>