package com.tinqinacademy.bff.core.processors.comments.hotel;

import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.comments.hotel.leavecommentforroom.LeaveCommentForRoomBFFInput;
import com.tinqinacademy.bff.api.operations.comments.hotel.leavecommentforroom.LeaveCommentForRoomBFFOperation;
import com.tinqinacademy.bff.api.operations.comments.hotel.leavecommentforroom.LeaveCommentForRoomBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.comments.api.operations.hotel.leavecommentforroom.LeaveCommentForRoomInput;
import com.tinqinacademy.comments.api.operations.hotel.leavecommentforroom.LeaveCommentForRoomOperation;
import com.tinqinacademy.comments.api.operations.hotel.leavecommentforroom.LeaveCommentForRoomOutput;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static io.vavr.API.$;
import static io.vavr.API.Match;
import static io.vavr.Predicates.instanceOf;

@Slf4j
@Service
public class LeaveCommentForRoomOperationProcessor extends BaseOperationProcessor implements LeaveCommentForRoomBFFOperation {

    @Autowired
    public LeaveCommentForRoomOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator) {
        super(conversionService, errorMapper, validator);
    }

    @Override
    public Either<Errors, LeaveCommentForRoomBFFOutput> process(LeaveCommentForRoomBFFInput input) {
        return null;
    }
}
