package co.intraway.api.fizzbuzz.model.dtos;

import java.io.Serializable;

public class ResponseOkDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String timestamp;
	private String code;
	private String description;
	private String list;
		
	public ResponseOkDto() {}
	
	public ResponseOkDto(String timestamp, String code, String description, String list) {
		super();
		this.timestamp = timestamp;
		this.code = code;
		this.description = description;
		this.list = list;
	}
	
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}

}
