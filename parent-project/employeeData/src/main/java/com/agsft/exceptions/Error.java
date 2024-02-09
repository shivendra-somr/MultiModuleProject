package com.agsft.exceptions;

import java.time.LocalDateTime;

public class Error {
    private String message;
    private String errorDetails;
    private LocalDateTime date;

    public Error(String message, String errorDetails, LocalDateTime date) {
        this.message = message;
        this.errorDetails = errorDetails;
        this.date = date;
    }

    public Error() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
