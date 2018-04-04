package by.htp.login.bean;

public class PairUserBook extends Entity{
	private int userId;
	private int bookId;
	
	public PairUserBook(int id) {
		super(id);
	}
	
	public PairUserBook(int id, int userId, int bookId) {
		super(id);
		this.userId = userId;
		this.bookId = bookId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + bookId;
		result = prime * result + userId;
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
		PairUserBook other = (PairUserBook) obj;
		if (bookId != other.bookId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PairUserBook [userId=" + userId + ", bookId=" + bookId + ", getId()=" + getId() + "]";
	}

}
