package com.boaentrega.informacoescadastrais.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(BusinnesException.class)
    public ResponseEntity<StandardError> objectNotFound(BusinnesException ex, HttpServletRequest request) {

        StandardError erro = new StandardError(System.currentTimeMillis(), HttpStatus.EXPECTATION_FAILED.value(), "Algum erro aconteceu", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> objectNotFound(Exception ex, HttpServletRequest request) {

        StandardError erro = new StandardError(System.currentTimeMillis(), HttpStatus.EXPECTATION_FAILED.value(), "Algum erro aconteceu", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(erro);
    }
}
