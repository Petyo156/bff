package com.tinqinacademy.bff.core.processors.hotel.hotel;

import com.tinqinacademy.bff.api.operations.hotel.hotel.bookroom.BookSpecifiedRoomBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.hotel.bookroom.BookSpecifiedRoomBFFOperation;
import com.tinqinacademy.bff.api.operations.hotel.hotel.bookroom.BookSpecifiedRoomBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.hotel.api.models.exceptions.Errors;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static io.vavr.API.$;
import static io.vavr.API.Match;
import static io.vavr.Predicates.instanceOf;

@Service
@Slf4j
public class BookSpecifiedRoomOperationProcessor extends BaseOperationProcessor implements BookSpecifiedRoomBFFOperation {

    @Autowired
    public BookSpecifiedRoomOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator) {
        super(conversionService, errorMapper, validator);
    }

    @Override
    public Either<Errors, BookSpecifiedRoomBFFOutput> process(BookSpecifiedRoomBFFInput input) {
        return null;
    }
}
