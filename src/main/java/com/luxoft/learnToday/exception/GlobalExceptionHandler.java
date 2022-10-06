package com.luxoft.learnToday.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(DataNotFoundException exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorMessage(exception.getMessage());
        errorDetails.setTimestamp(new Date());
        errorDetails.setErrorDetails(webRequest.getDescription(true));
        return new ResponseEntity<ErrorDetails>(errorDetails,
                exception.getMessage().startsWith("Something")
                        ? HttpStatus.BAD_REQUEST
                        : HttpStatus.NOT_FOUND
        );
    }

}