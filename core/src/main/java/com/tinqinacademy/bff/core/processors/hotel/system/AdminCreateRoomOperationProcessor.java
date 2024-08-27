package com.tinqinacademy.bff.core.processors.hotel.system;

import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.hotel.system.admincreateroom.AdminCreateRoomBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.system.admincreateroom.AdminCreateRoomBFFOperation;
import com.tinqinacademy.bff.api.operations.hotel.system.admincreateroom.AdminCreateRoomBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.hotel.api.models.operations.system.admincreateroom.AdminCreateRoomInput;
import com.tinqinacademy.hotel.api.models.operations.system.admincreateroom.AdminCreateRoomOutput;
import com.tinqinacademy.hotel.restexport.HotelClient;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static io.vavr.API.*;
import static io.vavr.Predicates.instanceOf;

@Slf4j
@Service
public class AdminCreateRoomOperationProcessor extends BaseOperationProcessor implements AdminCreateRoomBFFOperation {
    private final HotelClient hotelClient;

    @Autowired
    public AdminCreateRoomOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator, HotelClient hotelClient) {
        super(conversionService, errorMapper, validator);
        this.hotelClient = hotelClient;
    }

    @Override
    public Either<Errors, AdminCreateRoomBFFOutput> process(AdminCreateRoomBFFInput input) {
        return Try.of(() -> {
                    log.info("Start adminCreateRoom input: {}", input);

                    validateInput(input);

                    AdminCreateRoomInput adminCreateRoomInput = conversionService.convert(input, AdminCreateRoomInput.class);

                    AdminCreateRoomOutput requestOutput = hotelClient.adminCreateRoom(adminCreateRoomInput);

                    AdminCreateRoomBFFOutput output = conversionService.convert(requestOutput, AdminCreateRoomBFFOutput.class);

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
