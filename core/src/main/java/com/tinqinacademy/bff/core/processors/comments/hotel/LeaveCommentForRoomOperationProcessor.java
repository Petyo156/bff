package com.tinqinacademy.bff.core.processors.comments.hotel;

import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.comments.hotel.leavecommentforroom.LeaveCommentForRoomBFFInput;
import com.tinqinacademy.bff.api.operations.comments.hotel.leavecommentforroom.LeaveCommentForRoomBFFOperation;
import com.tinqinacademy.bff.api.operations.comments.hotel.leavecommentforroom.LeaveCommentForRoomBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.comments.api.operations.hotel.leavecommentforroom.LeaveCommentForRoomOutput;
import com.tinqinacademy.comments.restexport.CommentClient;
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
public class LeaveCommentForRoomOperationProcessor extends BaseOperationProcessor implements LeaveCommentForRoomBFFOperation {
    private final HotelClient hotelClient;
    private final CommentClient commentClient;


    @Autowired
    public LeaveCommentForRoomOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator, HotelClient hotelClient, CommentClient commentClient) {
        super(conversionService, errorMapper, validator);
        this.hotelClient = hotelClient;
        this.commentClient = commentClient;
    }

    @Override
    public Either<Errors, LeaveCommentForRoomBFFOutput> process(LeaveCommentForRoomBFFInput input) {
        return Try.of(() -> {
                    log.info("Start leaveCommentForRoom input: {}", input);

                    LeaveCommentForRoomOutput leaveCommentForRoomOutput = LeaveCommentForRoomOutput.builder()
                            .id(input.getRoomId())
                            .build();

                    LeaveCommentForRoomBFFOutput output = conversionService.convert(leaveCommentForRoomOutput, LeaveCommentForRoomBFFOutput.class);

                    log.info("End leaveCommentForRoom output: {}", output);
                    return output;
                })
                .toEither()
                .mapLeft(throwable -> Match(throwable).of(
                        Case($(instanceOf(IllegalArgumentException.class)),
                                errorMapper.handleError(throwable, HttpStatus.BAD_REQUEST))
                ));
    }
}
