package br.com.cvm.api_ofertas.exception.handler;

import br.com.cvm.api_ofertas.exception.RegisterNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        return build(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(RegisterNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(RegisterNotFoundException e) {
        return build(HttpStatus.NOT_FOUND, e.getMessage());
    }


    private ResponseEntity<ErrorResponse> build(HttpStatus status, String message) {
        ErrorResponse error = new ErrorResponse(status.value(), message, Instant.now());
        return new ResponseEntity<>(error, status);
    }


}
