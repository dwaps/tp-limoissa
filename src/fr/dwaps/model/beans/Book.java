package fr.dwaps.model.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book implements Serializable {
	private final static long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=90, nullable=false)
	private String title;
	@Column(columnDefinition="TEXT")
	private String description;
	@Column(length=90, nullable=false)
	private String author;
	@Column(length=90, nullable=false)
	private String img;
	@Column(columnDefinition="DECIMAL(5,2)")
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
			int id,
			String title,
			String description,
			String author,
			String img,
			double price,
			boolean available) {
		this(title, description, author, img, price, available);
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
