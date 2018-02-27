package by.htp.login.bean.fields;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import by.htp.login.bean.Entity;

public abstract class Person extends Entity{
	
	private String name;
	private String surname;
	private Date birthday;
	
	public Person() {
		super();
	}
	
	public Person(int id) {
		super(id);
	}

	public Person(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	
	public Person(String name, String surname, Date birthday) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
	}
	public Person(int id, String name, String surname) {
		super(id);
		this.name = name;
		this.surname = surname;
	}
	
	public Person(int id, String name, String surname, Date birthday) {
		super(id);
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public void setBirthday(String birthday) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyy_MM_dd");
		try {
			this.birthday = dateFormat.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(obj==null) {
			return false;
		}
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
		
		
	}

	@Override
	public String toString() {
		return "ID = "+ getId()+", " + name + " "+surname+" ; was born in " + birthday;
	}

}
