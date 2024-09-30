<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Todo</title>
<%@include file="components/bootstrap.jsp"%>
</head>
<body style="background-style: #F0f1f2;">
	<%@include file="components/navbar.jsp"%>


	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">

						<form action="add_todo" method="post">
							<h1 class="text-center">Add Todo</h1>
							<div class="form-group">
								<label for="exampleInputEmail1">Name</label> <input type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Aapka Naam" name="username">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Todo</label> <input type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter your Task..." name="todo">

							</div>
							<div class="form-group ">
								<label for="inputState">Status</label> <select type="text"
									class="form-control" id="exampleInputPassword1"
									placeholder="Password" name="status">
									<option selected>---Select---</option>
									<option value="Pending">Pending</option>
									<option value="Completed">Completed</option>
								</select>
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-primary">Add Task</button>
							</div>

						</form>

					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>