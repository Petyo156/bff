package com.tinqinacademy.bff.core.processors.hotel.hotel;

import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.hotel.hotel.unbookbookedroom.UnbookBookedRoomBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.hotel.unbookbookedroom.UnbookBookedRoomBFFOperation;
import com.tinqinacademy.bff.api.operations.hotel.hotel.unbookbookedroom.UnbookBookedRoomBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.hotel.api.models.operations.hotel.unbookbookedroom.UnbookBookedRoomOutput;
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
public class UnbookBookedRoomOperationProcessor extends BaseOperationProcessor implements UnbookBookedRoomBFFOperation {
    private final HotelClient hotelClient;

    @Autowired
    public UnbookBookedRoomOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator, HotelClient hotelClient) {
        super(conversionService, errorMapper, validator);
        this.hotelClient = hotelClient;
    }

    @Override
    public Either<Errors, UnbookBookedRoomBFFOutput> process(UnbookBookedRoomBFFInput input) {
        return Try.of(() -> {
                    log.info("Start unbookBookedRoom input: {}", input);

                    validateInput(input);

                    UnbookBookedRoomOutput unbookBookedRoomOutput = hotelClient.unbookBookedRoom(input.getBookingId());

                    UnbookBookedRoomBFFOutput output = conversionService.convert(unbookBookedRoomOutput, UnbookBookedRoomBFFOutput.class);

                    log.info("End unbookBookedRoom output: {}", output);
                    return output;
                })
                .toEither()
                .mapLeft(throwable -> Match(throwable).of(
                        Case($(instanceOf(IllegalArgumentException.class)),
                                errorMapper.handleError(throwable, HttpStatus.BAD_REQUEST))
                ));
    }
}
