package com.jsp.college.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataNotFoundException extends RuntimeException{

	private String messageName;
	private String fieldName;
	private Object fieldValue;
	
	
	
	public DataNotFoundException(String messageName, String fieldName, Object fieldValue) {
		super(messageName+" Not found for "+fieldName+" : "+fieldValue);
		this.messageName = messageName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	

	
	
}
