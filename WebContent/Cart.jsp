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

	<jsp:include page="UserHeader.jsp"></jsp:include>

	<h3>Current cart items :</h3>

	<table class="table table-hover">
		<thead>
			<tr>

				<th>Id</th>
				<th>Name</th>
				<th>Description</th>
				<th>Price</th>
				<th></th>
				<th></th>

			</tr>
		</thead>
		<tbody>

			<c:forEach items="${cart}" var="product">
				<br>
				<tr>

					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.price}</td>
					<td><a style="color: black;" href="remove?id=${product.id}">remove</a></td>
					<td></td>


				</tr>
			</c:forEach>


		</tbody>
	</table>

<form action="purchase" method="post">
	<table class="table table-hover">
		<thead>

			<tr>
				<th>TOTAL Amounth:</th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th>&nbsp&nbsp&nbsp&nbsp</th>
				<th><c:out value="${message}"></c:out></th>
				
				<th><button  type="submit" class="btn btn-success">Charge</button></th>

			</tr>

		</thead>
	</table>

</form>

</body>
</html>