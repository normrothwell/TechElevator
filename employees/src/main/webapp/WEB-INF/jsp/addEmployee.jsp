<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee Page</title>
</head>
<body>

		<c:url var="addEmployeeUrl" value="/addEmployee" />
		<form:form method="POST" action="${addEmployeeUrl}" modelAttribute="employee">
		
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
			<label for="contactEmail">Contact Email</label> 
			<form:input path="contactEmail"/>
  			<form:errors path="contactEmail" cssClass="error"/>
		</div>
			
		<div>
			<label for="companyEmail">Company Email</label> 
			<form:input path="companyEmail"/>
  			<form:errors path="companyEmail" cssClass="error"/>
		</div>
			
		<div>
			<label for="hiredDate">Hire Date</label> 
			<form:input path="hiredDate"/>
  			<form:errors path="hiredDate" cssClass="error"/>
		</div>
			
		<div>
			<label for="birthDate">Birth Date</label> 
			<form:input path="birthDate"/>
  			<form:errors path="birthDate" cssClass="error"/>
		</div>
			
		<div>
			<input type="submit" value="submit" />
		</div>
			
		</form:form>
		
</body>
</html>