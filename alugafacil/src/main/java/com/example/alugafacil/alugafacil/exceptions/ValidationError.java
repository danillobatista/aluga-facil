package com.example.alugafacil.alugafacil.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(LocalDateTime timestamp, Integer status, String message, String path, List<FieldMessage> errors) {
        super(timestamp, status, message, path);
        this.errors = errors;
    }

    public ValidationError(LocalDateTime timestamp, Integer status, String message, String path) {
        super(timestamp, status, message, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldMessage> errors) {
        this.errors = errors;
    }

    public void addError(String field,String defaultMessage){
        this.errors.add(new FieldMessage(field, defaultMessage));
    }
}
