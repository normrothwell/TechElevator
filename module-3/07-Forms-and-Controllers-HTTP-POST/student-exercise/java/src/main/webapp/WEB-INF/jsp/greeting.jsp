<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Squirrel Cigar Party For Dummies Reviews</title>
	</head>
	<body>
		<h1>Squirrel Cigar Party For Dummies Reviews</h1>
		
		<img src='<c:url value="/img/forDummies.png"></c:url>' /> 
	
	<table>
	<tr>
	<th>ID</th>
	<th>User Name</th>
	<th>Rating</th>
	<th>Title</th>
	<th>Text</th>
	<th>Date Submitted</th>
	</tr>
		
	<c:forEach items ="${reviews}" var="review">
	<tr>
		<td>${review.id}</td>
		<td>${review.username}</td>
		<td>${review.rating}</td>
		<td>${review.title}</td>
		<td>${review.text}</td>
		<td>${review.dateSubmitted}</td>
	</tr>		
	</c:forEach>
	
	</table>
	
<c:url var='postSubmissionUrl' value='/postSubmission'/>
<a href='${postSubmissionUrl}' /> Submit a new post </a>
	
	</body>
	
	
</html>