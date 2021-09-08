package org.event.handler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {
    
	
	   @ExceptionHandler(NullPointerException.class)
	    public final ResponseEntity<Object> handleAllExceptions(NullPointerException ex) {
			Map<String, Object> body= new LinkedHashMap<String, Object>();
		   body.put("timestamp", LocalDateTime.now());
	        body.put("message",new NullPointerException("the request is null").getMessage());
			return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
	        // Log and return
	    }

}
