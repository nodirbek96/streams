package com.example.custom_anotation.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ServerResponse {
    private boolean success;
    private Object data;
    private Object error;
}
