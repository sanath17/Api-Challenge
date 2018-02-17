package com.disney.studios.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DogNotFoundException extends RuntimeException {

	/**
	 * @author Sanath
	 */
	private static final long serialVersionUID = 1L;

	public DogNotFoundException(String message) {

		super(message);
	}

	public DogNotFoundException(String message, Throwable cause) {

		super(message, cause);

	}

}
