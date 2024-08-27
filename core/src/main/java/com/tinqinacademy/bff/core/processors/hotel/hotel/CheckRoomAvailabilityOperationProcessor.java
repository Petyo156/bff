package com.tinqinacademy.bff.core.processors.hotel.hotel;

import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.hotel.hotel.checkroom.CheckRoomAvailabilityBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.hotel.checkroom.CheckRoomAvailabilityBFFOperation;
import com.tinqinacademy.bff.api.operations.hotel.hotel.checkroom.CheckRoomAvailabilityBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.hotel.api.models.operations.hotel.checkroom.CheckRoomAvailabilityInput;
import com.tinqinacademy.hotel.api.models.operations.hotel.checkroom.CheckRoomAvailabilityOutput;
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
public class CheckRoomAvailabilityOperationProcessor extends BaseOperationProcessor implements CheckRoomAvailabilityBFFOperation {
    private final HotelClient hotelClient;

    @Autowired
    public CheckRoomAvailabilityOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator, HotelClient hotelClient) {
        super(conversionService, errorMapper, validator);
        this.hotelClient = hotelClient;
    }

    @Override
    public Either<Errors, CheckRoomAvailabilityBFFOutput> process(CheckRoomAvailabilityBFFInput input) {
        return Try.of(() -> {
                    log.info("Start checkRoomAvailability input: {}", input);

                    validateInput(input);

                    CheckRoomAvailabilityOutput checkRoomAvailabilityOutput = hotelClient.checkAvailability(
                            input.getStartDate(),
                            input.getEndDate(),
                            input.getBedSize(),
                            input.getBathroomType());

                    CheckRoomAvailabilityBFFOutput output = conversionService.convert(checkRoomAvailabilityOutput, CheckRoomAvailabilityBFFOutput.class);

                    log.info("End checkRoomAvailability output: {}", output);
                    return output;
                })
                .toEither()
                .mapLeft(throwable -> Match(throwable).of(
                        Case($(instanceOf(IllegalArgumentException.class)),
                                errorMapper.handleError(throwable, HttpStatus.BAD_REQUEST))
                ));
    }
}
