package com.ajisafe.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajisafe.entities.Book;
import com.ajisafe.entities.dao.BookOracleJdbcDAO;
import com.ajisafe.entities.dao.IBookDAO;
import com.google.gson.Gson;

public class AddBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String data = request.getParameter("book");
		
		PrintWriter writer = response.getWriter();
		Connection conn = null;
		Gson gson = new Gson();
		Book book = gson.fromJson(data, Book.class);
		
		//Class.forName(arg0)
		//writer.println("Book's ISBN: " + book.getIsbn());
		//writer.println("ID: " + book.getId());
		//writer.println("Title: " + book.getTitle());
		//writer.println("Author: " + book.getAuthor());
		
		IBookDAO bookDAO = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/books_lib", "root", "");
			bookDAO = new BookOracleJdbcDAO(conn);
			bookDAO.createBook(book);
			//writer.println("Book's ISBN: " + book.getIsbn());
			//writer.println("ID: " + book.getId());
			//writer.println("Title: " + book.getTitle());
			//writer.println("Author: " + book.getAuthor());
			String json = gson.toJson(book, Book.class);
			String data2 = "{\"key\":" + json + ", \"success\":true}";
			writer.print(data2);
			
		} catch (SQLException e) {
				
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		
		writer.flush();
		
	}
	
}
