package com.example.custom_anotation.exception;

import org.springframework.http.ResponseEntity;

public class ResponseEntityErrorException extends RuntimeException{
    private  ResponseEntity<ServiceErrorResponse> serviceErrorResponseResponse;

    public ResponseEntityErrorException(ResponseEntity<ServiceErrorResponse> serviceErrorResponseResponse) {
        this.serviceErrorResponseResponse = serviceErrorResponseResponse;
    }

    public ResponseEntity<ServiceErrorResponse> getServiceErrorResponseResponse() {
        return serviceErrorResponseResponse;
    }
}
