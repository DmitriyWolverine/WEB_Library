package by.htp.login.actions.exception;

public class IncorrectInputParametres extends IllegalArgumentException{

	private static final long serialVersionUID = 1L;
	
	private final String message;
	
	public IncorrectInputParametres(String message) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
	
}
