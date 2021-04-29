package co.intraway.api.fizzbuzz.model.dtos;

import java.io.Serializable;

public class ResponseErrorDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String timestamp;
	private int status;
	private String exception;
	private String message;
	private String path;
	
	public ResponseErrorDto() {}

	public ResponseErrorDto(String timestamp, int status, String exception, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.exception = exception;
		this.message = message;
		this.path = path;
	}
	
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}	

}
