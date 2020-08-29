package com.honeywell.bms.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BMSExceptionMapper {

	private static final Logger LOGGER = LoggerFactory.getLogger(BMSExceptionMapper.class);

	@ExceptionHandler
	public ResponseEntity<?> serverError(BMSException e) {
		LOGGER.error("processing failure", e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to process");
	}
}
