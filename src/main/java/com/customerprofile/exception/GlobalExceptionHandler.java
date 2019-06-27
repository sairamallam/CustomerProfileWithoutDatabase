package com.customerprofile.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.customerprofile.dto.ResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDto> handleAllException(Exception ex) {
		return new ResponseEntity<ResponseDto>(new ResponseDto(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ResponseDto> handleCustomException(ApplicationException ex) {
		return new ResponseEntity<ResponseDto>(new ResponseDto(ex.getMessage()), HttpStatus.NOT_FOUND);

	}

}
