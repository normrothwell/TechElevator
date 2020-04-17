<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url value="/css/site.css" var="cssURL" />
<link rel="stylesheet" type="text/css" href="${cssURL}">
<title>Solar System Geek</title>
</head>

<body>

<div id="content">
<p>This is the placeholder for the header.</p>

	<c:url value = '/img/ssg_logo.png' var = 'logoImageUrL' />
	
	<img src = '${logoImageUrL}'/>
	
    <nav>
		<c:url value ='/' var='homePageUrl'/>
		<c:url value ='/aboutUs' var='aboutUsUrl'/>
		<ul>
			<li><a href = '${homePageUrl}'>Home Page</a></li>
			<li><a href = '${aboutUsUrl}'>About Us</a></li>
		</ul>
    </nav>
<h1><c:out value="${param.pageTitle}"/></h1>
<p><c:out value="${param.by}"/></p>