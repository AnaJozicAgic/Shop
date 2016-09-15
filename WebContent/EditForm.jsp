<%@page import="shop.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset = utf-8">
<title>Insert title here</title>
<meta name="viwport" content="width = device-width , initial-scale =1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="css/main.css">
</head>
<body>

<jsp:include page="AdminHeader.jsp"></jsp:include>

<div class="wrapper">
		<form class="form-signin" action="editProduct" method="post" >
			<h2 class="form-signin-heading">Edit Product </h2>
			<input type="text" class="form-control" name="name"
				placeholder="${product.name}" /> <input type="text"
				class="form-control" name="price" placeholder="${product.price} " required/>
			<input type="text" class="form-control" name="description"
				placeholder="${product.description}" />
			<button class="btn btn-lg btn-default btn-block" type="submit">edit</button>
		</form>
	</div>
</body>
</html>