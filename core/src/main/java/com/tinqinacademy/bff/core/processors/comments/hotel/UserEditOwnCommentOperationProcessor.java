package com.tinqinacademy.bff.core.processors.comments.hotel;

import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.comments.hotel.usereditowncomment.UserEditOwnCommentBFFInput;
import com.tinqinacademy.bff.api.operations.comments.hotel.usereditowncomment.UserEditOwnCommentBFFOperation;
import com.tinqinacademy.bff.api.operations.comments.hotel.usereditowncomment.UserEditOwnCommentBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.comments.api.operations.hotel.usereditowncomment.UserEditOwnCommentInput;
import com.tinqinacademy.comments.api.operations.hotel.usereditowncomment.UserEditOwnCommentOutput;
import com.tinqinacademy.comments.restexport.CommentClient;
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
public class UserEditOwnCommentOperationProcessor extends BaseOperationProcessor implements UserEditOwnCommentBFFOperation {
    private final CommentClient commentClient;

    @Autowired
    public UserEditOwnCommentOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator, CommentClient commentClient) {
        super(conversionService, errorMapper, validator);
        this.commentClient = commentClient;
    }

    @Override
    public Either<Errors, UserEditOwnCommentBFFOutput> process(UserEditOwnCommentBFFInput input) {
        return Try.of(() -> {
                    log.info("Start userEditOwnComment input: {}", input);

                    validateInput(input);

                    UserEditOwnCommentInput userEditOwnCommentInput = conversionService.convert(input, UserEditOwnCommentInput.class);

                    UserEditOwnCommentOutput userEditOwnCommentOutput = commentClient.userEditOwnComment(userEditOwnCommentInput, input.getCommentId());

                    UserEditOwnCommentBFFOutput output = conversionService.convert(userEditOwnCommentOutput, UserEditOwnCommentBFFOutput.class);

                    log.info("End userEditOwnComment output: {}", output);
                    return output;
                })
                .toEither()
                .mapLeft(throwable -> Match(throwable).of(
                        Case($(instanceOf(IllegalArgumentException.class)),
                                errorMapper.handleError(throwable, HttpStatus.BAD_REQUEST))
                ));
    }
}
