package by.htp.login.service.exceptions;

public class ServiceUnpreparedEntityEsception extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private final String message;
	
	public ServiceUnpreparedEntityEsception(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
