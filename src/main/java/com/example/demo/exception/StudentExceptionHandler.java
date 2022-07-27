package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(value = StudentException.class)
    public ResponseEntity<ErrorInfo> handleException(StudentException e) {

        if (Objects.equals(e.getStudentError().getMessage(), StudentError.EMAIL_EXISTS.getMessage())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorInfo(e.getStudentError().getMessage()));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorInfo(e.getStudentError().getMessage()));
    }

}
