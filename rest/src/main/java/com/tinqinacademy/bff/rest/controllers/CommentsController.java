package com.tinqinacademy.bff.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.comments.hotel.getcommentsforroom.GetCommentsForRoomBFFInput;
import com.tinqinacademy.bff.api.operations.comments.hotel.leavecommentforroom.LeaveCommentForRoomBFFInput;
import com.tinqinacademy.bff.api.operations.comments.hotel.usereditowncomment.UserEditOwnCommentBFFInput;
import com.tinqinacademy.bff.api.operations.comments.system.admindeleteanycomment.AdminDeleteAnyCommentBFFInput;
import com.tinqinacademy.bff.api.operations.comments.system.admindeleteanycomment.AdminDeleteAnyCommentBFFOutput;
import com.tinqinacademy.bff.api.operations.comments.system.admineditanycomment.AdminEditAnyCommentBFFInput;
import com.tinqinacademy.bff.core.processors.comments.hotel.GetCommentsForRoomOperationProcessor;
import com.tinqinacademy.bff.core.processors.comments.hotel.LeaveCommentForRoomOperationProcessor;
import com.tinqinacademy.bff.core.processors.comments.hotel.UserEditOwnCommentOperationProcessor;
import com.tinqinacademy.bff.core.processors.comments.service.AdminDeleteAnyCommentOperationProcessor;
import com.tinqinacademy.bff.core.processors.comments.service.AdminEditAnyCommentOperationProcessor;
import com.tinqinacademy.comments.api.apimapping.RestApiMappingComments;
import io.vavr.control.Either;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentsController extends BaseController {
    private final ObjectMapper objectMapper;

    private final GetCommentsForRoomOperationProcessor getCommentsForRoomOperationProcessor;
    private final LeaveCommentForRoomOperationProcessor leaveCommentForRoomOperationProcessor;
    private final UserEditOwnCommentOperationProcessor userEditOwnCommentOperationProcessor;
    private final AdminEditAnyCommentOperationProcessor adminEditAnyCommentOperationProcessor;
    private final AdminDeleteAnyCommentOperationProcessor adminDeleteAnyCommentOperationProcessor;

    @Autowired
    public CommentsController(ObjectMapper objectMapper, GetCommentsForRoomOperationProcessor getCommentsForRoomOperationProcessor, LeaveCommentForRoomOperationProcessor leaveCommentForRoomOperationProcessor,
                              UserEditOwnCommentOperationProcessor userEditOwnCommentOperationProcessor, AdminEditAnyCommentOperationProcessor adminEditAnyCommentOperationProcessor, AdminDeleteAnyCommentOperationProcessor adminDeleteAnyCommentOperationProcessor) {
        this.objectMapper = objectMapper;
        this.getCommentsForRoomOperationProcessor = getCommentsForRoomOperationProcessor;
        this.leaveCommentForRoomOperationProcessor = leaveCommentForRoomOperationProcessor;
        this.userEditOwnCommentOperationProcessor = userEditOwnCommentOperationProcessor;
        this.adminEditAnyCommentOperationProcessor = adminEditAnyCommentOperationProcessor;
        this.adminDeleteAnyCommentOperationProcessor = adminDeleteAnyCommentOperationProcessor;
    }

    @GetMapping(RestApiMappingComments.GET_PATH)
    public ResponseEntity<?> getRoomComments(
            @PathVariable("roomId") String roomId) {

        GetCommentsForRoomBFFInput getCommentsForRoomBFFInput = GetCommentsForRoomBFFInput.builder()
                .roomId(roomId)
                .build();

        return handleOperation(getCommentsForRoomOperationProcessor.process(getCommentsForRoomBFFInput), HttpStatus.BAD_REQUEST);
    }

    @PostMapping(RestApiMappingComments.POST_PATH)
    public ResponseEntity<?> leaveCommentForRoom(
            @Valid @RequestBody LeaveCommentForRoomBFFInput input,
            @PathVariable("roomId") String roomId) {

        LeaveCommentForRoomBFFInput leaveCommentForRoomInput = input.toBuilder()
                .roomId(roomId)
                .build();

        return handleOperation(leaveCommentForRoomOperationProcessor.process(leaveCommentForRoomInput), HttpStatus.BAD_REQUEST);
    }

    @PatchMapping(RestApiMappingComments.PATCH_PATH)
    public ResponseEntity<?> userEditOwnComment(
            @Valid @RequestBody UserEditOwnCommentBFFInput input,
            @PathVariable("commentId") String commentId) {

        UserEditOwnCommentBFFInput userEditOwnCommentInput = input.toBuilder()
                .commentId(commentId)
                .build();

        return handleOperation(userEditOwnCommentOperationProcessor.process(userEditOwnCommentInput), HttpStatus.BAD_REQUEST);
    }

    @PutMapping(RestApiMappingComments.PUT_PATH)
    public ResponseEntity<?> adminEditAnyComment(
            @Valid @RequestBody AdminEditAnyCommentBFFInput input,
            @PathVariable("commentId") String commentId) {

        AdminEditAnyCommentBFFInput adminEditAnyCommentInput = input.toBuilder()
                .commentId(commentId)
                .build();

        return handleOperation(adminEditAnyCommentOperationProcessor.process(adminEditAnyCommentInput), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(RestApiMappingComments.DELETE_PATH)
    public ResponseEntity<?> deleteComment(@PathVariable("commentId") String id) {
        AdminDeleteAnyCommentBFFInput input = AdminDeleteAnyCommentBFFInput.builder()
                .commentId(id)
                .build();

        Either<Errors, AdminDeleteAnyCommentBFFOutput> output = adminDeleteAnyCommentOperationProcessor.process(input);

        return handleOperation(output, HttpStatus.ACCEPTED);
    }
}
