<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="index.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<div class="container-sm">
		<h1 class="display-3">JSON Reference Form</h1>
		<form action="entry" method="post">
			<div class="input-group mb-3">
				<span class="input-group-text" id="name-id">@</span> <input
					type="text" class="form-control" placeholder="Name"
					aria-label="Name" aria-describedby="name-id" name="name">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text" id="age-id">#</span> <input
					type="text" class="form-control" placeholder="Age" aria-label="Age"
					aria-describedby="age-id" name="age">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text" id="food-id">$</span> <input
					type="text" class="form-control"
					placeholder="Use ',' to enter your skills"
					aria-label="Use ',' to enter your skills"
					aria-describedby="skills-id" name="skills">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<br>
		<button type="button" class="btn btn-success" id="values-btn">Get
			Values</button>
		<br> <a href="jsonapi.jsp">Json Cricket</a>
		<br> <a href="timejsonapi.html">Json Time</a>
		<br> <a href="./ajax/animals.html">Json Animals</a>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Age</th>
					<th scope="col">Skills</th>

				</tr>
			</thead>
			<tbody id="display">
			</tbody>
		</table>
	</div>
	<script type="text/javascript" src="script1.js"></script>
</body>
</html>