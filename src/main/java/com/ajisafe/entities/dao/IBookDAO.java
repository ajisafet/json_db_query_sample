package com.ajisafe.entities.dao;

import com.ajisafe.entities.Book;
import com.ajisafe.entities.dao.exceptions.DatabaseException;

public interface IBookDAO {

	public Book getBook(Long id) throws DatabaseException;
	public Book createBook(Book book) throws DatabaseException;
	public void updateBook(Book book) throws DatabaseException;
	public void deleteBook(Long id) throws DatabaseException;
	
}
