package com.example.custom_anotation.repository;

import com.example.custom_anotation.anot.ValidateEmployeeType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {
    private int id;
    @NotBlank(message = "name should not be null or empty")
    private String name;
    @ValidateEmployeeType
    private String type;
    @NotNull
    @Min(10)
    private Integer age;

}
