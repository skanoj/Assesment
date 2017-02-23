package com.adv.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.adv.api.domain.ExceptionResponse;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> postException(Exception e) throws Exception{
			
		ExceptionResponse er = new ExceptionResponse();
		er.setCode(HttpStatus.BAD_REQUEST.value());
		er.setDescription("There was some problem with the API request, the operation ended up in error.");
		System.out.println(e.getMessage());
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
