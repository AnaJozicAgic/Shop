<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  directive -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset = utf-8">
<title>Insert title here</title>
<meta name="viwport" content="width = device-width , initial-scale =1">
<link rel='stylesheet prefetch'
	href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
		<div class="text-center">
		<h3>
			<c:out value="${message}"></c:out>
		</h3>
	</div>
	<div class="wrapper">
		<form class="form-signin" action="login" method="post">
			<h2 class="form-signin-heading">Please Signin</h2>
			<input type="text" class="form-control" name="username"
			autofocus placeholder="Enter user name:" />
				 <input type="password"
				class="form-control" name="password" autofocus placeholder="Enter password: " />

			<button class="btn btn-lg btn-default btn-block" type="submit">Signin</button>


		</form>
		</div>
</body>
</html>