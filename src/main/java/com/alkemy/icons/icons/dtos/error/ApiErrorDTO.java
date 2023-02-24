package com.alkemy.icons.icons.dtos.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ApiErrorDTO {

    private HttpStatus httpStatus;

    private String message;

    private List<String> errors;

}
