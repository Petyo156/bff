package com.tinqinacademy.bff.core.processors.hotel.system;

import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.hotel.hotel.unbookbookedroom.UnbookBookedRoomBFFOutput;
import com.tinqinacademy.bff.api.operations.hotel.system.admincreateroom.AdminCreateRoomBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.system.admincreateroom.AdminCreateRoomBFFOperation;
import com.tinqinacademy.bff.api.operations.hotel.system.admincreateroom.AdminCreateRoomBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.hotel.api.models.operations.system.admincreateroom.AdminCreateRoomInput;
import com.tinqinacademy.hotel.api.models.operations.system.admincreateroom.AdminCreateRoomOperation;
import com.tinqinacademy.hotel.api.models.operations.system.admincreateroom.AdminCreateRoomOutput;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.vavr.API.*;
import static io.vavr.Predicates.instanceOf;

@Slf4j
@Service
public class AdminCreateRoomOperationProcessor extends BaseOperationProcessor implements AdminCreateRoomBFFOperation {

    @Autowired
    public AdminCreateRoomOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator) {
        super(conversionService, errorMapper, validator);
    }

    @Override
    public Either<Errors, AdminCreateRoomBFFOutput> process(AdminCreateRoomBFFInput input) {
        return Try.of(() -> {
                    log.info("Start adminCreateRoom input: {}", input);

                    AdminCreateRoomBFFOutput output = AdminCreateRoomBFFOutput.builder()
                            .build();

                    log.info("End adminCreateRoom output: {}", output);
                    return output;
                })
                .toEither()
                .mapLeft(throwable -> Match(throwable).of(
                        Case($(instanceOf(IllegalArgumentException.class)),
                                errorMapper.handleError(throwable, HttpStatus.BAD_REQUEST))
                ));
    }
}
