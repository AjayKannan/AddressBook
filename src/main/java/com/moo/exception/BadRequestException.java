package com.moo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{

	private static final long serialVersionUID = 8037304991441405727L;

	public BadRequestException(String message) {
        super(message);
	}
}
