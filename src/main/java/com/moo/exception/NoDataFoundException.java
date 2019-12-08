package com.moo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoDataFoundException extends RuntimeException{


	private static final long serialVersionUID = 6748550143674960167L;

	public NoDataFoundException(String message) {
        super(message);
	}
}
