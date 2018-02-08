package fr.dwaps.model.beans;

import java.io.Serializable;

public class Book implements Serializable {
	private final static long serialVersionUID = 1L;
	
	private long id;
	private String title;
	private String description;
	private String author;
	private String img;
	private double price;
	private boolean available;
	
	public Book() {}
	public Book(
		String title,
		String description,
		String author,
		String img,
		double price,
		boolean available) {
			this.title = title;
			this.description = description;
			this.author = author;
			this.setImg(img);
			this.price = price;
			this.available = available;
	}
	public Book(
			long id,
			String title,
			String description,
			String author,
			String img,
			double price,
			boolean available) {
		this(title, description, author, img, price, available);
		this.id = id;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		if (img.isEmpty()) img = "no-img.png";
		this.img = img.contains("resources") ? img : "/resources/assets/img/" + img;
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
