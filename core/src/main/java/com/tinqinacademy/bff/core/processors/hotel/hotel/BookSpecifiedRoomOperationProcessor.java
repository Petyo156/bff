package com.tinqinacademy.bff.core.processors.hotel.hotel;

import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.hotel.hotel.bookroom.BookSpecifiedRoomBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.hotel.bookroom.BookSpecifiedRoomBFFOperation;
import com.tinqinacademy.bff.api.operations.hotel.hotel.bookroom.BookSpecifiedRoomBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.hotel.api.models.operations.hotel.bookroom.BookSpecifiedRoomInput;
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

@Service
@Slf4j
public class BookSpecifiedRoomOperationProcessor extends BaseOperationProcessor implements BookSpecifiedRoomBFFOperation {

    private final HotelClient hotelClient;

    @Autowired
    public BookSpecifiedRoomOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator, HotelClient hotelClient) {
        super(conversionService, errorMapper, validator);
        this.hotelClient = hotelClient;
    }

    @Override
    public Either<Errors, BookSpecifiedRoomBFFOutput> process(BookSpecifiedRoomBFFInput input) {
        return Try.of(() -> {
                    log.info("Start bookSpecifiedRoom input: {}", input);

                    validateInput(input);

                    BookSpecifiedRoomInput bookSpecifiedRoomInput = conversionService.convert(input, BookSpecifiedRoomInput.class);

                    hotelClient.bookSpecifiedRoom(bookSpecifiedRoomInput, input.getRoomId());

                    BookSpecifiedRoomBFFOutput output = BookSpecifiedRoomBFFOutput.builder()
                            .build();

                    log.info("End bookSpecifiedRoom output: {}", output);
                    return output;
                })
                .toEither()
                .mapLeft(throwable -> Match(throwable).of(
                        Case($(instanceOf(IllegalArgumentException.class)),
                                errorMapper.handleError(throwable, HttpStatus.BAD_REQUEST))
                ));
    }
}
