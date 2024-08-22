package com.tinqinacademy.bff.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.comments.system.admindeleteanycomment.AdminDeleteAnyCommentBFFInput;
import com.tinqinacademy.bff.api.operations.comments.system.admindeleteanycomment.AdminDeleteAnyCommentBFFOperation;
import com.tinqinacademy.bff.api.operations.comments.system.admindeleteanycomment.AdminDeleteAnyCommentBFFOutput;
import com.tinqinacademy.comments.api.apimapping.RestApiMappingComments;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentsController extends BaseController {
    private final ObjectMapper objectMapper;

    private final AdminDeleteAnyCommentBFFOperation adminDeleteAnyCommentBFFOperation;

    @Autowired
    public CommentsController(ObjectMapper objectMapper, AdminDeleteAnyCommentBFFOperation adminDeleteAnyCommentBFFOperation) {
        this.objectMapper = objectMapper;
        this.adminDeleteAnyCommentBFFOperation = adminDeleteAnyCommentBFFOperation;
    }

    @DeleteMapping(RestApiMappingComments.DELETE_PATH)
    public ResponseEntity<?> deleteComment(@PathVariable("commentId") String id) {
        AdminDeleteAnyCommentBFFInput input = AdminDeleteAnyCommentBFFInput.builder()
                .commentId(id)
                .build();

        Either<Errors, AdminDeleteAnyCommentBFFOutput> output = adminDeleteAnyCommentBFFOperation.process(input);

        return handleOperation(output, HttpStatus.ACCEPTED);
    }
}
