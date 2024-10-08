package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.TodoDetails;

public class TodoDAO {
	private Connection conn;
	
	public TodoDAO(Connection conn) {
		super();
		this.conn=conn;
	}
	
	public boolean addTodo(String name,String todo,String status) {
		boolean f=false;
		
		try {
			
			String sql="insert into todo(name,todo,status) values(?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, todo);
			pst.setString(3, status);
			int i=pst.executeUpdate();
			if(i==1) {
				//It will return only 1 or 0. 
				//0 if their is Data Manipulation takes place in DB
				// 1 if their are changes
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}
	
	public List<TodoDetails> getTodo(){
		List<TodoDetails> list =new ArrayList<TodoDetails>();
		
		TodoDetails t=null;
		
		try {
			String sql="select * from todo";
			PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				t=new TodoDetails();
				t.setId(rs.getInt(1));
				t.setTodo(rs.getString(2));
				t.setName(rs.getString(3));
				t.setStatus(rs.getString(4));
				list.add(t);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return list;
	}
	
	public TodoDetails getTodoById(int id) {
		TodoDetails t=null;
		
		
		try {
			String sql="select * from todo where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1,id); 
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				t=new TodoDetails();
				t.setId(rs.getInt(1));
				t.setTodo(rs.getString(2));
				t.setName(rs.getString(3));
				t.setStatus(rs.getString(4));
			}
		} catch (Exception e) {
			
		}
		
		
		return t;
	}
	public boolean updateTodoById(TodoDetails t) {
		
		boolean res=false;
		
		try {
			String sql="update todo set todo=?, name=?,status=? where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, t.getTodo());
			pst.setString(2, t.getName());
			pst.setString(3, t.getStatus());
			pst.setInt(4, t.getId());
			int a=pst.executeUpdate();
			if(a==1) {
				res=true;
			}else {
				System.out.print("Nhi chala bhai!!!");
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
		
	}
	public boolean deleteTodoById(int id) {
		boolean res1=false;
		try {
			String sql="delete from todo where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			int f=pst.executeUpdate();
			if(f==1) {
				res1=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res1;
	}

}
