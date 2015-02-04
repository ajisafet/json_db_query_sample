package com.ajisafe.entities.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.xml.bind.DataBindingException;

import com.ajisafe.entities.Book;
import com.ajisafe.entities.dao.exceptions.DatabaseException;
import com.mysql.jdbc.SQLError;


public class BookOracleJdbcDAO implements IBookDAO{

	private Connection conn;
	
	public BookOracleJdbcDAO(Connection conn) {
		
		this.conn = conn;
		
	}
	
	@Override
	public Book getBook(Long id) throws DatabaseException{
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
				
			pstmt =conn.prepareStatement("");
			rs = pstmt.executeQuery();
			
		} catch (SQLException sqle) {
					
			throw new DatabaseException(sqle.getMessage(), sqle);

		} finally {
			
			closeResultSet(rs);
			closePreparedStatement(pstmt);
			
		}
		
		return null;
		
	}

	private void closePreparedStatement(PreparedStatement pstmt) {
		try {
			
			if (pstmt != null) {
				pstmt.close();				
			}
		
		} catch (SQLException sqle) {

		}
		
	}

	private void closeResultSet(ResultSet rs) {
		
		try {
			
			if (rs != null) {
				rs.close();				
			}
		
		} catch (SQLException sqle) {

		}
		
	}

	@Override
	public Book createBook(Book book) throws DatabaseException {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
				
			pstmt = conn.prepareStatement("INSERT INTO books VALUES(NULL, ?, ?, ?)");
			
			if (book.getIsbn() == null || book.getIsbn().trim().equals("")) {
				pstmt.setNull(1, Types.VARCHAR);
			} else {
				pstmt.setString(1, book.getIsbn());
			}
			
			if (book.getTitle() == null || book.getTitle().trim().equals("")) {
				pstmt.setNull(2, Types.VARCHAR);
			} else {
				pstmt.setString(2, book.getTitle());
			}
			
			if (book.getAuthor() == null || book.getAuthor().trim().equals("")) {
				pstmt.setNull(3, Types.VARCHAR);
			} else {
				pstmt.setString(3, book.getAuthor());
			}
			
			pstmt.execute();
			pstmt.close();
			
			//pstmt = conn.prepareStatement("SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name=? AND table_schema=?");
			pstmt = conn.prepareStatement("SELECT LAST_INSERT_ID()");
			
			//pstmt.setString(1, "books");
			//pstmt.setString(2, "books_lib");
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				Long id_pk = rs.getLong(1);
				
				if (rs.wasNull()) {
					id_pk = 1L;
				}
				
				book.setId(id_pk);
			
			}
			
		} catch (SQLException sqle) {
					
			throw new DatabaseException(sqle.getMessage(), sqle);

		} finally {
			
			closeResultSet(rs);
			closePreparedStatement(pstmt);
			
		}
		
		return null;
	}

	@Override
	public void updateBook(Book book) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(Long id) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

}
