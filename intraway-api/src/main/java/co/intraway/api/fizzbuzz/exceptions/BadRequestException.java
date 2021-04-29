package co.intraway.api.fizzbuzz.exceptions;

public class BadRequestException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String source = "co.intraway.api.fizzbuzz.exceptions.BadRequestException";	

	public BadRequestException(String message, Throwable cause) {
		super(message, cause);		
	}

	public BadRequestException(String message) {
		super(message);		
	}

	public BadRequestException(Throwable cause) {
		super(cause);		
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
