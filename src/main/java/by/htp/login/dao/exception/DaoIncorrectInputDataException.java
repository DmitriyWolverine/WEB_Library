package by.htp.login.dao.exception;

public class DaoIncorrectInputDataException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private final String message;
	
	public DaoIncorrectInputDataException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
}
