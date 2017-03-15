package fi.haaga.helia.domain;

import javax.persistence.*;

@Entity
public class Book {
	private long id;
	private String author;
	private String isbn;
	private String title;
	private int year;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(String author, String isbn, String title, int year) {
		super();
		this.author = author;
		this.isbn = isbn;
		this.title = title;
		this.year = year;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "author")
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Column(name = "isbn")
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name = "year")
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
