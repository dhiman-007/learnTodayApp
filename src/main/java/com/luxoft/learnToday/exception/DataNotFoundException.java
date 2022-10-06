package com.luxoft.learnToday.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class DataNotFoundException extends RuntimeException {

    private String errorMessage;

    public DataNotFoundException(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

}
