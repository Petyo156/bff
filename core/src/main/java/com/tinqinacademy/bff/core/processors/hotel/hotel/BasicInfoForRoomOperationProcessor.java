package com.tinqinacademy.bff.core.processors.hotel.hotel;

import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.hotel.hotel.basicinfo.BasicInfoForRoomBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.hotel.basicinfo.BasicInfoForRoomBFFOperation;
import com.tinqinacademy.bff.api.operations.hotel.hotel.basicinfo.BasicInfoForRoomBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.hotel.api.models.operations.hotel.basicinfo.BasicInfoForRoomOutput;
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
public class BasicInfoForRoomOperationProcessor extends BaseOperationProcessor implements BasicInfoForRoomBFFOperation {

    private final HotelClient hotelClient;

    @Autowired
    public BasicInfoForRoomOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator, HotelClient hotelClient) {
        super(conversionService, errorMapper, validator);
        this.hotelClient = hotelClient;
    }

    @Override
    public Either<Errors, BasicInfoForRoomBFFOutput> process(BasicInfoForRoomBFFInput input) {
        return Try.of(() -> {
                    log.info("Start basicInfoForRoom input: {}", input);

                    validateInput(input);

                    BasicInfoForRoomOutput requestOutput = hotelClient.basicInfoForRoom(input.getRoomId());

                    BasicInfoForRoomBFFOutput output = conversionService.convert(requestOutput, BasicInfoForRoomBFFOutput.class);

                    log.info("End basicInfoForRoom output: {}", output);
                    return output;
                })
                .toEither()
                .mapLeft(throwable -> Match(throwable).of(
                        Case($(instanceOf(IllegalArgumentException.class)),
                                errorMapper.handleError(throwable, HttpStatus.BAD_REQUEST))
                ));
    }
}
