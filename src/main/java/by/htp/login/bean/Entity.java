package by.htp.login.bean;

public abstract class Entity {
	private int id;

	public Entity() {
		super();
	}
	
	public Entity(int i) {
		super();
		this.id = i;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass() )
			return false;
		Entity other = (Entity) obj;
		return (id == other.id);
	}

	@Override
	public String toString() {
		return "Entity ID =" + id ;
	}
}
