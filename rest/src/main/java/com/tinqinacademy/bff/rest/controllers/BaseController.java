package com.tinqinacademy.bff.rest.controllers;

import com.tinqinacademy.bff.api.base.OperationOutput;
import com.tinqinacademy.bff.api.exceptions.Errors;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class BaseController {
    public ResponseEntity<?> handleOperation(Either<Errors, ? extends OperationOutput> result, HttpStatus httpStatus) {
        return result.isLeft()
                ? ResponseEntity.status(httpStatus).body(result.getLeft())
                : ResponseEntity.ok(result.get());
    }


}