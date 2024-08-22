package com.tinqinacademy.bff.api.base;

import com.tinqinacademy.hotel.api.models.base.OperationInput;
import com.tinqinacademy.hotel.api.models.base.OperationOutput;
import com.tinqinacademy.hotel.api.models.exceptions.Errors;
import io.vavr.control.Either;

public interface OperationProcessor<S extends OperationInput, T extends OperationOutput> {
    Either<Errors, T> process(S input);
}
