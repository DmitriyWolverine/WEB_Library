package by.htp.login.bean;

import by.htp.login.bean.fields.Author;

public class Book extends Entity{
	private String title;
	private Author author;
	private int publishedYear;

	public Book() {
		super();
	}
	public Book(int id) {
		super(id);
	}
	public Book(String title, Author author, int year) {
		super();
		this.title = title;
		this.author = author;
		this.publishedYear = year;
	}
	
	public Book(int id, String title, Author author, int year) {
		super(id);
		this.title = title;
		this.author = author;
		this.publishedYear = year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getPublishedYear() {
		return publishedYear;
	}
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + publishedYear;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if(obj== null) {
			return false;
		}
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null) 
				return false;
		} else if (!author.equals(other.author)) 
			return false;
		if (publishedYear != other.publishedYear) {
			return false;}
		if (title == null) {
			if (other.title != null) 
				return false;
		} else if (!title.equals(other.title)) 
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Book Id = "+ getId() +", Title: " + title + ", " + author + " , publishedYear = " + publishedYear;
	}
	
}
