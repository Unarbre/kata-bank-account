package com.kata.bankaccount.exposition.configuration;


import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.kata.bankaccount.application.structures.ApplicationException;
import com.kata.bankaccount.domain.structures.DomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler {


    @ResponseBody
    @ExceptionHandler(Throwable.class)
    public final ResponseEntity<?> handleFeignExceptions(Exception ex, WebRequest request) {

        if (ex instanceof ApplicationException) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

        if (ex instanceof DomainException) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

        if (ex instanceof HttpMessageNotReadableException) {
            return ResponseEntity.badRequest().body(((HttpMessageNotReadableException) ex).getHttpInputMessage());
        }

        if (ex instanceof HttpMessageConversionException) {
            return ResponseEntity.badRequest().body(((HttpMessageConversionException) ex).getMessage());
        }

        if (ex instanceof MethodArgumentNotValidException) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

        if (ex instanceof InvalidDefinitionException) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
