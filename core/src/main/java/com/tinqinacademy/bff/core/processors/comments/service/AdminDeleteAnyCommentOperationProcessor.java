package com.tinqinacademy.bff.core.processors.comments.service;

import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.comments.system.admindeleteanycomment.AdminDeleteAnyCommentBFFInput;
import com.tinqinacademy.bff.api.operations.comments.system.admindeleteanycomment.AdminDeleteAnyCommentBFFOperation;
import com.tinqinacademy.bff.api.operations.comments.system.admindeleteanycomment.AdminDeleteAnyCommentBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import io.vavr.control.Either;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import static io.vavr.API.$;
import static io.vavr.API.Match;

@Slf4j
@Service
public class AdminDeleteAnyCommentOperationProcessor extends BaseOperationProcessor implements AdminDeleteAnyCommentBFFOperation {

    @Autowired
    public AdminDeleteAnyCommentOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator) {
        super(conversionService, errorMapper, validator);
    }

    @Override
    public Either<Errors, AdminDeleteAnyCommentBFFOutput> process(AdminDeleteAnyCommentBFFInput input) {
        return null;
    }
}
