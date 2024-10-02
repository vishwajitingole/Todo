package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.TodoDAO;
import com.DB.DBConnect;
import com.entity.TodoDetails;

 
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int id=Integer.parseInt(req.getParameter("id"));
		String username=req.getParameter("username");
		String todo=req.getParameter("todo");
		String status =req.getParameter("status");
		
		TodoDAO dao=new TodoDAO(DBConnect.getConn());
		
		TodoDetails t=new TodoDetails();
		t.setId(id);
		t.setName(username);
		t.setTodo(todo);
		t.setStatus(status);
		HttpSession session=req.getSession();
		
		boolean f=dao.updateTodoById(t);
		if(f) {
			session.setAttribute("msg","Todo Updated Successfully");
			System.out.print("Data Inserted");
			res.sendRedirect("index.jsp");
		}else {
			session.setAttribute("fail","Todo Failed to add");

			res.sendRedirect("index.jsp");
		}
		
		
		
	
	}

}
