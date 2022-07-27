package com.example.demo.exception;

public enum StudentError {

    STUDENT_NOT_FOUND("Student does not exists"),
    EMAIL_EXISTS("Email in use");

    private String message;

    StudentError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
