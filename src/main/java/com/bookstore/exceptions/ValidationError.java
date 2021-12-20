package com.bookstore.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.bookstore.resource.exceptions.FieldMessage;
import com.bookstore.resource.exceptions.StandardError;

public class ValidationError extends StandardError {
	
	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError() {
		super();
	}

	public ValidationError(Long timesTamp, Integer status, String error) {
		super(timesTamp, status, error);
	}

	

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}
	

}
