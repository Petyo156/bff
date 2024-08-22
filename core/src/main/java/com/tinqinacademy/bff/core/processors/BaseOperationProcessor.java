package com.tinqinacademy.bff.core.processors;

import com.tinqinacademy.bff.api.base.OperationInput;
import com.tinqinacademy.bff.api.exceptions.ErrorResponse;
import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import io.vavr.control.Either;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class BaseOperationProcessor {
    protected final ConversionService conversionService;
    protected final ErrorMapper errorMapper;
    protected final Validator validator;

    @Autowired
    public BaseOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator) {
        this.conversionService = conversionService;
        this.errorMapper = errorMapper;
        this.validator = validator;
    }

    protected Either<Errors, ? extends OperationInput> validateInput(OperationInput input) {
        Set<ConstraintViolation<OperationInput>> violations = validator.validate(input);

        if (!violations.isEmpty()) {
            List<String> errorMessages = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());

            ErrorResponse errorResponse = ErrorResponse.builder()
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .message(String.join(", ", errorMessages))
                    .build();

            return Either.left(errorResponse);
        }

        return Either.right(input);
    }

}