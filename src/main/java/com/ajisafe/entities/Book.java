package com.ajisafe.entities;

public class Book {

	private String isbn;
	private Long id;
	private String title;
	private String author;
	
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIsbn() {

		return isbn;
		
	}

	public void setId(Long id) {
		
		this.id = id;
		
	}

	public Long getId() {
		
		return id;
		
	}

	public String getTitle() {
	
		return title;
	
	}

	public void setTitle(String title) {
	
		this.title = title;
	
	}

	public String getAuthor() {
	
		return author;
	
	}

	public void setAuthor(String author) {
	
		this.author = author;
	
	}	

}