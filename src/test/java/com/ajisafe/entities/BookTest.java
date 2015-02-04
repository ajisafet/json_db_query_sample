package com.ajisafe.entities;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class BookTest {
	
	Book book = null;
	
	public BookTest() {
		
		book = new Book();
		
	}
	
	public static Object[] validIsbnValues() {
		
		return new Object[] {
				"ISBN-1234-1567", "ISBN-1234-1568"
		};
	}
	
	public static Object[] validIdValues() {
		
		return new Object[] {
				1L, 2L, 3L
		};
	}
	
	@Test
	@Parameters(method="validIsbnValues")
	public void setIsbnWithFixedValueTest(String isbn) {
		
		book.setIsbn(isbn);
		assertEquals("Expected isbn: " + isbn + ", Actual value: " + book.getIsbn(), isbn, book.getIsbn());
		
	}
	
	@Test
	public void setIdWithNullValue(){
		
		Long value = null;
		book.setId(value);
		assertNull("Expected: null, Actual value: " + book.getId(), book.getId());
		
	}
	
	@Test
	@Parameters(method="validIdValues")
	public void setIdWithNonNullValue(Long id) {
		
		//Long value = 2L;
		book.setId(id);
		assertEquals("Expected: " + id + ", Actual value: " + book.getId(), id, book.getId());
		
	}
	
}
