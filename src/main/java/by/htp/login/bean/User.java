package by.htp.login.bean;

import java.util.ArrayList;
import java.util.List;

import by.htp.login.bean.util.MD5;

public abstract class User extends Entity{
	private String login;
	private String password;
	private boolean isAdmin = false;
	private List<Book> readBooks=null;
	private Book currentBook ;
	
	public User() {
		super();
		readBooks = new ArrayList<>();
	}
	public User(int id) {
		super(id);
		readBooks = new ArrayList<>();
	}
	public User(String login, String pass) {
		super();
		this.login = login;
		this.password = MD5.md5Custom(pass);
		readBooks = new ArrayList<>();
	}
	
	public User(String login) {
		super();
		this.login = login;
		readBooks = new ArrayList<>();
	}
	
	public User(int id, String login, String pass) {
		super(id);
		this.login = login;
		this.password = MD5.md5Custom(pass);
		readBooks = new ArrayList<>();
	}
	
	public Book getCurrentBook() {
		return currentBook;
	}
	public void setCurrentBook(Book currentBook) {
		this.currentBook = currentBook;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pass) {
		this.password = MD5.md5Custom(pass);
	}
	
	public void setMd5Password(String md5Pass) {
		this.password = md5Pass;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public List<Book> getReadBooks() {
		return readBooks;
	}
	public void setReadBooks(List<Book> readBooks) {
		this.readBooks = readBooks;
	}
	
	public void addReadBooks(Book book) {
		this.readBooks.add(book);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (isAdmin ? 1231 : 1237);
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (isAdmin != other.isAdmin)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}	
	
	@Override
	public String toString() {
		return "User ID = "+  getId()+" Login=" + getLogin() + ", Pass=" + getPassword();
	}
}
