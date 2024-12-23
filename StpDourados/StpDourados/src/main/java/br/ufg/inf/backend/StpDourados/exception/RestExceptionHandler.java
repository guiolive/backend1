package br.ufg.inf.backend.StpDourados.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(ResourceNotFoundException.class)
	private ResponseEntity<RestErrorMessage> resourceNotFoundHandler(ResourceNotFoundException exception){
		RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
	}
	
	@ExceptionHandler(RuntimeException.class)
    private ResponseEntity<RestErrorMessage> runtimeErrorHandler(RuntimeException exception){
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(threatResponse);
    }

}
