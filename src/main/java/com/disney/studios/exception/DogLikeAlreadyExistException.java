package com.disney.studios.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DogLikeAlreadyExistException extends RuntimeException {

	/**
	 * @author Sanath
	 */
	private static final long serialVersionUID = 1L;

	public DogLikeAlreadyExistException(String message) {

		super(message);
	}

	public DogLikeAlreadyExistException(String message, Throwable cause) {

		super(message, cause);

	}

}
