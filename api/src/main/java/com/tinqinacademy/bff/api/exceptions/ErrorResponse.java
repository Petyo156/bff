package com.tinqinacademy.bff.api.exceptions;

import com.tinqinacademy.hotel.api.models.exceptions.Errors;
import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ErrorResponse implements Errors {
    private String message;
    private HttpStatus httpStatus;
}
