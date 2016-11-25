<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
    
    <title>Gene_Product Manager | Home</title>
    
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
     <link href="static/css/style.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-geneProduct">New Gene Product</a></li>
					<li><a href="all-geneProducts">All Gene Products</a></li>					
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
		<c:when test="${mode=='MODE_HOME_GENE_PRODUCT'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Gene Product Manager</h1>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode=='MODE_GENE_PRODUCTS'}">
			<div class="container text-center" id="geneProductsDiv">
				<h3>My GeneProducts</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>SYMBOL</th>
								<th>ID DBXREF</th>
								<th>ID SPECIES</th>
								<th>ID TYPE</th>
								<th>FULL_NAME</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="geneProduct" items="${geneProducts}">
								<tr>
									<td>${geneProduct.id}</td>
									<td>${geneProduct.symbol}</td>
									<td>${geneProduct.dbxrefId}</td>
									<td>${geneProduct.speciesId}</td>
									<td>${geneProduct.typeId}</td>
									<td>${geneProduct.fullName}</td>
									<td><a href="update-geneProduct?id=${geneProduct.id}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-geneProduct?id=${geneProduct.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode=='MODE_NEW' || mode=='MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage Gene Product</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-geneProduct">
					<input type="hidden" name="id" value="${geneProduct.id}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Symbol:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="symbol"
								value="${geneProduct.symbol}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Id Db xref:</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="dbxrefId"
								value="${geneProduct.dbxrefId}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Id Species:</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="speciesId"
								value="${geneProduct.speciesId}"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Id Type:</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="typeId"
								value="${geneProduct.typeId}"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">full name:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="fullName"
								value="${geneProduct.fullName}"/>
						</div>
					</div>
					
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>
				</form>
			</div>
		</c:when>
	</c:choose>
</body>
</html>