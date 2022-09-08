package bookstore.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title, author, isbn;
	private int bookYear;
	private double price;

 
 public Book() {
	super();
}





public Book(String title, String author, String isbn, int bookYear, double price) {
	super();
	this.title = title;
	this.author = author;
	this.isbn = isbn;
	this.bookYear = bookYear;
	this.price = price;
}




public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
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


public int getBookYear() {
	return bookYear;
}


public void setBookYear(int year) {
	this.bookYear = year;
}


public String getIsbn() {
	return isbn;
}


public void setIsbn(String isbn) {
	this.isbn = isbn;
}


public double getPrice() {
	return price;
}


public void setPrice(double price) {
	this.price = price;
}
 
 
 
 
 
}
