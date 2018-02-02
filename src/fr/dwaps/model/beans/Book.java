package fr.dwaps.model.beans;

import java.io.Serializable;

public class Book implements Serializable {
	private final static long serialVersionUID = 1L;
	
	private long id;
	private String title;
	private String description;
	private String author;
	private double price;
	private boolean available;
	
	public Book() {}
	public Book(String title, String description, String author, double price, boolean available) {
		super();
		this.title = title;
		this.description = description;
		this.author = author;
		this.price = price;
		this.available = available;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
}
