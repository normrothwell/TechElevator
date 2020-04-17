<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submit New Post</title>
</head>
<body>

<c:url var="submissionConfirmationUrl" value="/submissionConfirmation"/>

<form method="POST" action="${submissionConfirmationUrl}">
	<div>
		<label for="userName">User Name</label>
		<input type="text" name="userName"/><br>
		<label for="rating">Rating</label>
		<input type="text" name="rating"/><br>
		<label for="title">Post Title</label>
		<input type="text" name="title"/><br>
		<label for="postText">Post Text</label>
		<input type="text" name="postText"/><br>
	</div>
	<input class="formSubmitButton" type="submit" value="Submit Post"/>
</form>

</body>
</html>