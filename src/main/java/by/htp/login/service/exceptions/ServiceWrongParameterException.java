package by.htp.login.service.exceptions;

public class ServiceWrongParameterException extends IllegalArgumentException{
	private static final long serialVersionUID = 1L;
	
	private final String message;
	
	public ServiceWrongParameterException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
