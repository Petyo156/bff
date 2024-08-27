package com.tinqinacademy.bff.core.processors.hotel.system;

import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.hotel.system.deleteroom.DeleteRoomBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.system.deleteroom.DeleteRoomBFFOperation;
import com.tinqinacademy.bff.api.operations.hotel.system.deleteroom.DeleteRoomBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.hotel.restexport.HotelClient;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static io.vavr.API.*;
import static io.vavr.Predicates.instanceOf;

@Slf4j
@Service
public class DeleteRoomOperationProcessor extends BaseOperationProcessor implements DeleteRoomBFFOperation {
    private final HotelClient hotelClient;

    @Autowired
    public DeleteRoomOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator, HotelClient hotelClient) {
        super(conversionService, errorMapper, validator);
        this.hotelClient = hotelClient;
    }

    @Override
    public Either<Errors, DeleteRoomBFFOutput> process(DeleteRoomBFFInput input) {
        return Try.of(() -> {
                    log.info("Start deleteRoom input: {}", input);

                    validateInput(input);

                    hotelClient.deleteRoom(input.getId());

                    DeleteRoomBFFOutput output = DeleteRoomBFFOutput.builder()
                            .build();

                    log.info("End deleteRoom output: {}", output);
                    return output;
                })
                .toEither()
                .mapLeft(throwable -> Match(throwable).of(
                        Case($(instanceOf(IllegalArgumentException.class)),
                                errorMapper.handleError(throwable, HttpStatus.BAD_REQUEST))
                ));
    }
}
