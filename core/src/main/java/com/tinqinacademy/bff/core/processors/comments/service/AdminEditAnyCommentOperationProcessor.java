package com.tinqinacademy.bff.core.processors.comments.service;

import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.comments.system.admineditanycomment.AdminEditAnyCommentBFFInput;
import com.tinqinacademy.bff.api.operations.comments.system.admineditanycomment.AdminEditAnyCommentBFFOperation;
import com.tinqinacademy.bff.api.operations.comments.system.admineditanycomment.AdminEditAnyCommentBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.comments.api.operations.system.admineditanycomment.AdminEditAnyCommentInput;
import com.tinqinacademy.comments.api.operations.system.admineditanycomment.AdminEditAnyCommentOutput;
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
public class AdminEditAnyCommentOperationProcessor extends BaseOperationProcessor implements AdminEditAnyCommentBFFOperation {
    private final CommentClient commentClient;

    @Autowired
    public AdminEditAnyCommentOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator, CommentClient commentClient) {
        super(conversionService, errorMapper, validator);
        this.commentClient = commentClient;
    }

    @Override
    public Either<Errors, AdminEditAnyCommentBFFOutput> process(AdminEditAnyCommentBFFInput input) {
        return Try.of(() -> {
                    log.info("Start adminEditAnyComment input: {}", input);

                    AdminEditAnyCommentInput adminEditAnyCommentInput = conversionService.convert(input, AdminEditAnyCommentInput.class);

                    AdminEditAnyCommentOutput adminEditAnyCommentOutput = commentClient.adminEditAnyComment(adminEditAnyCommentInput, input.getCommentId());

                    AdminEditAnyCommentBFFOutput output = conversionService.convert(adminEditAnyCommentOutput, AdminEditAnyCommentBFFOutput.class);

                    log.info("End adminEditAnyComment output: {}", output);
                    return output;
                })
                .toEither()
                .mapLeft(throwable -> Match(throwable).of(
                        Case($(instanceOf(IllegalArgumentException.class)),
                                errorMapper.handleError(throwable, HttpStatus.BAD_REQUEST))
                ));
    }
}
