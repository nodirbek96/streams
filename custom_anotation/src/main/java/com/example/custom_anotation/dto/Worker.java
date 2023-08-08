package com.example.custom_anotation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Worker {
    private int job_id;
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM.dd.yyyy")
    @Past(message = "Enter valid date.")
    private Date birth_date;
    @NotBlank
    private String phone;

    private int salary;
}
