package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.TodoDAO;
import com.DB.DBConnect;

@WebServlet("/add_todo")
public class AddServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String username=req.getParameter("username");
		String todo=req.getParameter("todo");
		String status =req.getParameter("status");
		
		TodoDAO t=new TodoDAO(DBConnect.getConn());
		
		HttpSession session=req.getSession();
		
		boolean f=t.addTodo(username, todo, status);
		if(f) {
			session.setAttribute("msg","Todo Added Successfully");
			System.out.print("Data Inserted");
			resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("fail","Todo Failed to add");

			resp.sendRedirect("index.jsp");
		}
		
		
	}

}
