<%@page import="com.entity.TodoDetails"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.TodoDAO"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Todo</title>
<%@include file="components/bootstrap.jsp"%>
</head>
<body class="bg-secondary" style="background-style: #F0f1f2;">
	<%@include file="components/navbar.jsp"%>


	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">

						<form action="add_todo" method="post">
							<h1 class="text-center">Edit Todo</h1>

							<% int id=Integer.parseInt(request.getParameter("id"));
							TodoDAO dao=new TodoDAO(DBConnect.getConn());
							TodoDetails t=dao.getTodoById(id);
							
							%>


							<div class="form-group">
								<label for="exampleInputEmail1">Name</label> <input type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Aapka Naam"
									value="<%=t.getStatus()%>" name="username">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Todo</label> <input type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" value="<%=t.getName()%>"
									placeholder="Enter your Task..." name="todo">
							</div>

							<div class="form-group ">
								<label for="inputState">Status</label> <select type="text"
									class="form-control" id="exampleInputPassword1"
									placeholder="Password" name="status">

									<%
									
									if("Pending".equals(t.getTodo())){
										%>
									<option selected value="Pending">Pending</option>
									<option value="Completed">Completed</option>
									<% 	
									}else{
										%>

									<option value="Pending">Pending</option>
									<option selected value="Completed">Completed</option>

									<%
										
									}
									
									%>

								


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