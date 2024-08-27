package com.tinqinacademy.bff.core.processors.comments.service;

import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.comments.system.admindeleteanycomment.AdminDeleteAnyCommentBFFInput;
import com.tinqinacademy.bff.api.operations.comments.system.admindeleteanycomment.AdminDeleteAnyCommentBFFOperation;
import com.tinqinacademy.bff.api.operations.comments.system.admindeleteanycomment.AdminDeleteAnyCommentBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.comments.api.operations.system.admindeleteanycomment.AdminDeleteAnyCommentInput;
import com.tinqinacademy.comments.api.operations.system.admindeleteanycomment.AdminDeleteAnyCommentOutput;
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
public class AdminDeleteAnyCommentOperationProcessor extends BaseOperationProcessor implements AdminDeleteAnyCommentBFFOperation {
    private final CommentClient commentClient;

    @Autowired
    public AdminDeleteAnyCommentOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator, CommentClient commentClient) {
        super(conversionService, errorMapper, validator);
        this.commentClient = commentClient;
    }

    @Override
    public Either<Errors, AdminDeleteAnyCommentBFFOutput> process(AdminDeleteAnyCommentBFFInput input) {
        return Try.of(() -> {
                    log.info("Start adminDeleteAnyComment input: {}", input);

                    validateInput(input);

                    AdminDeleteAnyCommentInput adminDeleteAnyCommentInput = conversionService.convert(input, AdminDeleteAnyCommentInput.class);

                    commentClient.adminDeleteAnyComment(adminDeleteAnyCommentInput, input.getCommentId());

                    AdminDeleteAnyCommentOutput adminDeleteAnyCommentOutput = AdminDeleteAnyCommentOutput.builder().build();

                    AdminDeleteAnyCommentBFFOutput output = conversionService.convert(adminDeleteAnyCommentOutput, AdminDeleteAnyCommentBFFOutput.class);

                    log.info("End adminDeleteAnyComment output: {}", output);
                    return output;
                })
                .toEither()
                .mapLeft(throwable -> Match(throwable).of(
                        Case($(instanceOf(IllegalArgumentException.class)),
                                errorMapper.handleError(throwable, HttpStatus.BAD_REQUEST))
                ));
    }
}
