package com.example.custom_anotation.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceErrorResponse implements Serializable {
    private Object errorMessage;
    private String errorCode;
    private String requestTime;
}
