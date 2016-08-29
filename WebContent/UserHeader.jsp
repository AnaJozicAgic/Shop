<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<nav style="height:70px;" class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="Home.jsp"><span class = "glyphicon glyphicon-home"></span></a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="Succes.jsp">Home</a></li>
				<li><a href="Logout">Log out</a></li>
				<li><a href="ListProduct">List product</a></li>
				<li><a href="Cart">Cart</a></li>
			</ul>
			<form class="navbar-form navbar-left" role="search" action="search" method="get">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search products" name="product">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
			<p class="navbar-text navbar-right">
				Signed in as: <b>${user.username}</b>
			</p>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>

<div class="container-fluid green-bg">
<img src="img/spa1.jpg" alt="All natural products" class="center-block" />
</div>
<hr>