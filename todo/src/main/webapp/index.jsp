<%@page import="com.entity.TodoDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.TodoDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo</title>
<%@include file="components/bootstrap.jsp"%>
</head>
<body class="bg-light">

<% 

//Just to check if the DB is connected to Jsp
Connection conn=DBConnect.getConn(); 
out.print(conn);
%>

	<%@include file="components/navbar.jsp"%>
	<h1 class="text-center text-dark">Todo App</h1>
	
	<%
	String msg=(String)session.getAttribute("msg");
	if(msg!=null){
		%>
		<div class="alert alert-success" role="alert"><%=msg %></div>
		<%
		session.removeAttribute("msg");
	}
	%>
		<%
	String msg2=(String)session.getAttribute("failed");
	if(msg2!=null){
		%>
		<div class="alert alert-danger" role="alert"><%=msg2 %></div>
		<%
		session.removeAttribute("failed");
	}
	%>


	<div class="container">

		<table class="table table-striped text-center" border="1px">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">Todo</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
			
			<%
			TodoDAO dao=new TodoDAO(DBConnect.getConn());
			List<TodoDetails> todo=dao.getTodo();
			for(TodoDetails t:todo){
				%>
				
				<tr>
					<td scope="row"><%=t.getId() %></td>
					<td><%= t.getName() %></td>
					<td scope="row"><%= t.getTodo() %></td>
					<td><%=t.getStatus() %></td>
					<td>
						<a href="edit.jsp?id=<%=t.getId()%>" class="btn btn-sm btn-success">Edit</a>	
							<a href="delete?id=<%=t.getId()%>"  class="btn btn-sm btn-danger">Delete</a>	
					</td>
				</tr>
				<%
			}
			%>
			
			
				
				
			</tbody>
		</table>
	</div>

</body>
</html>