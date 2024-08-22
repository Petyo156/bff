package com.tinqinacademy.bff.core.processors;

import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.hotel.api.models.base.OperationInput;
import com.tinqinacademy.hotel.api.models.exceptions.ErrorResponse;
import com.tinqinacademy.hotel.api.models.exceptions.Errors;
import com.tinqinacademy.hotel.api.models.operations.hotel.bookroom.BookSpecifiedRoomInput;
import com.tinqinacademy.hotel.api.models.operations.system.admincreateroom.AdminCreateRoomInput;
import com.tinqinacademy.hotel.api.models.operations.system.registervisitor.RegisterVisitorInput;
import com.tinqinacademy.hotel.api.models.operations.system.registervisitor.RegisterVisitorsDataInput;
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