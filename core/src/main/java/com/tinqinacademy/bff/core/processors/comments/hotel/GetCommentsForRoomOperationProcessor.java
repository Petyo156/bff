package com.tinqinacademy.bff.core.processors.comments.hotel;

import com.tinqinacademy.bff.api.operations.comments.hotel.getcommentsforroom.GetCommentsForRoomBFFInput;
import com.tinqinacademy.bff.api.operations.comments.hotel.getcommentsforroom.GetCommentsForRoomBFFOperation;
import com.tinqinacademy.bff.api.operations.comments.hotel.getcommentsforroom.GetCommentsForRoomListBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.comments.api.exceptions.Errors;
import com.tinqinacademy.comments.api.operations.hotel.getcommentsforroom.GetCommentsForRoomInput;
import com.tinqinacademy.comments.api.operations.hotel.getcommentsforroom.GetCommentsForRoomListOutput;
import com.tinqinacademy.comments.api.operations.hotel.getcommentsforroom.GetCommentsForRoomOperation;
import com.tinqinacademy.comments.api.operations.hotel.getcommentsforroom.GetCommentsForRoomOutput;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static io.vavr.API.$;
import static io.vavr.API.Match;
import static io.vavr.Predicates.instanceOf;

@Slf4j
@Service
public class GetCommentsForRoomOperationProcessor extends BaseOperationProcessor implements GetCommentsForRoomBFFOperation {

    @Autowired
    public GetCommentsForRoomOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator) {
        super(conversionService, errorMapper, validator);
    }

    @Override
    public Either<Errors, GetCommentsForRoomListBFFOutput> process(GetCommentsForRoomBFFInput input) {
        return null;
    }
}

