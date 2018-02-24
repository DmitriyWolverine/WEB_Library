package by.htp.login.bean.fields;

import java.util.Date;

public class Author extends Person{
	public Author() {
		super();
	}
	public Author(int id) {
		super(id);
	}
	
	public Author(String name, String surname) {
		super(name, surname);
	}
	public Author(String name, String surname, Date birthday) {
		super(name, surname,  birthday);
	}
	public Author(int id, String name, String surname) {
		super(id, name, surname);
	}
	public Author(int id, String name, String surname, Date birthday) {
		super(id, name, surname,  birthday);
	}
	@Override
	public String toString() {
		return "Author "+ super.toString();
	}
	
}