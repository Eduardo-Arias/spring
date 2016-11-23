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
    
    <title>Exam Manager | Home</title>
    
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
				
					<li><a href="new-exam">New Exam</a></li>
					<li><a href="all-exams">All Exams</a></li>
					
					
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
	<c:when test="${mode=='MODE_HOME_EXAM'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Exam Manager</h1>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode=='MODE_EXAMS'}">
			<div class="container text-center" id="examsDiv">
				<h3>My Exams</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Matter</th>
								<th>Unity</th>
								<th>Date</th>
								<th>Score</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="exam" items="${exams}">
								<tr>
									<td>${exam.id}</td>
									<td>${exam.matter}</td>
									<td>${exam.unity}</td>
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${exam.date}" /></td>
									<td>${exam.score}</td>
									<td><a href="update-exam?id=${exam.id}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-exam?id=${exam.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode=='MODE_NEW_EXAM' || mode=='MODE_UPDATE_EXAM'}">
			<div class="container text-center">
				<h3>Manage Exam</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-exam">
					<input type="hidden" name="id" value="${exam.id}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Matter:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="matter"
								value="${exam.matter}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Unity:</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="unity"
								value="${exam.unity}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Score:</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="score"
								value="${exam.score }" />
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