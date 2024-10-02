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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

       
 

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
//		PrintWriter out=res.getWriter();
//		out.print(id);
		TodoDAO dao=new TodoDAO(DBConnect.getConn());
		boolean res1=dao.deleteTodoById(id);
		HttpSession session=req.getSession();
		if(res1) {
			session.setAttribute("msg","Todo Deleted Successfully");
			System.out.print("Data Deleted");
			res.sendRedirect("index.jsp");
			
		}else {
			session.setAttribute("fail","Todo Failed to Delete");

			res.sendRedirect("index.jsp");
		}
		
	}

}
