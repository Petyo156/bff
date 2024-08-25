package com.tinqinacademy.bff.core.processors.hotel.hotel;

import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.hotel.hotel.checkroom.CheckRoomAvailabilityBFFOutput;
import com.tinqinacademy.bff.api.operations.hotel.hotel.unbookbookedroom.UnbookBookedRoomBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.hotel.unbookbookedroom.UnbookBookedRoomBFFOperation;
import com.tinqinacademy.bff.api.operations.hotel.hotel.unbookbookedroom.UnbookBookedRoomBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.hotel.api.models.operations.hotel.unbookbookedroom.UnbookBookedRoomInput;
import com.tinqinacademy.hotel.api.models.operations.hotel.unbookbookedroom.UnbookBookedRoomOperation;
import com.tinqinacademy.hotel.api.models.operations.hotel.unbookbookedroom.UnbookBookedRoomOutput;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static io.vavr.API.*;
import static io.vavr.Predicates.instanceOf;

@Slf4j
@Service
public class UnbookBookedRoomOperationProcessor extends BaseOperationProcessor implements UnbookBookedRoomBFFOperation {

    @Autowired
    public UnbookBookedRoomOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator) {
        super(conversionService, errorMapper, validator);
    }

    @Override
    public Either<Errors, UnbookBookedRoomBFFOutput> process(UnbookBookedRoomBFFInput input) {
        return Try.of(() -> {
                    log.info("Start unbookBookedRoom input: {}", input);

                    UnbookBookedRoomBFFOutput output = UnbookBookedRoomBFFOutput.builder()
                            .build();

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
