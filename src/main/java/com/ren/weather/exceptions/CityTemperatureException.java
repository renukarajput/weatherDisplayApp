package com.ren.weather.exceptions;


import org.springframework.http.HttpStatus;

public class CityTemperatureException extends RuntimeException{
    HttpStatus httpStatus;
    String errorMessage;

    public CityTemperatureException(HttpStatus httpStatus,String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorMessage=errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
