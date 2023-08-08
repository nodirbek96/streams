package com.example.custom_anotation.decoder;

import com.example.custom_anotation.dto.Response;
import com.example.custom_anotation.exception.CustomException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.io.InputStream;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, feign.Response response) {
        Response details;
        try (InputStream bodyIs = response.body().asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            details = mapper.readValue(bodyIs, Response.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }
        return new CustomException(details.getError().getCode(),details.getError().getMessage());
    }
}
