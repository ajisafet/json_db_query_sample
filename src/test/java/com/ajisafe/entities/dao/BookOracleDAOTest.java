package com.ajisafe.entities.dao;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookOracleDAOTest {
	
	//private IBookDAO iBookDAO;
	
	
	public BookOracleDAOTest() {
		
		//iBookDAO = new BookOracleJdbcDAO;
		
	}
	
	@Test
	public void bookOracleInstanceOfIBookDAOTest() {
		
		//IBookDAO bookDAO = new BookOracleJdbcDAO();
		BookOracleJdbcDAO bookOracleJdbcDAO = new BookOracleJdbcDAO();
		assertTrue("BookOracleJdbcDAO doesn't implement IBookDAO interface", bookOracleJdbcDAO instanceof IBookDAO);
		
	}
	
}
