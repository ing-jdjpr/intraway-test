package co.intraway.api.fizzbuzz.model.dtos;

import java.io.Serializable;

public class OperationDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String description;
	private String result;
	private String timestamp;
	private String path;

	
	public OperationDto() {
		
	}	
	
	public OperationDto(String description, String result, String timestamp, String path) {
		super();
		this.description = description;
		this.result = result;
		this.timestamp = timestamp;
		this.path = path;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
