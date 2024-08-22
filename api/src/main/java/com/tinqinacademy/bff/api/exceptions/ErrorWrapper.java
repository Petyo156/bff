package com.tinqinacademy.bff.api.exceptions;

import com.tinqinacademy.hotel.api.models.exceptions.ErrorResponse;
import com.tinqinacademy.hotel.api.models.exceptions.Errors;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ErrorWrapper implements Errors {
    private List<ErrorResponse> errorResponseList;
    private LocalDate date;
}
