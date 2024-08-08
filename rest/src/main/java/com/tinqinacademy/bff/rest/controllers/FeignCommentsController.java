package com.tinqinacademy.bff.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqinacademy.bff.domain.CommentFeignClient;
import com.tinqinacademy.comments.api.apimapping.RestApiMappingComments;
import com.tinqinacademy.comments.api.operations.hotel.leavecommentforroom.LeaveCommentForRoomInput;
import com.tinqinacademy.comments.api.operations.hotel.usereditowncomment.UserEditOwnCommentInput;
import com.tinqinacademy.comments.api.operations.system.admindeleteanycomment.AdminDeleteAnyCommentInput;
import com.tinqinacademy.comments.api.operations.system.admineditanycomment.AdminEditAnyCommentInput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class FeignCommentsController {

    private final CommentFeignClient commentFeignClient;
    private final ObjectMapper objectMapper;

    @Autowired
    public FeignCommentsController(CommentFeignClient commentFeignClient, ObjectMapper objectMapper) {
        this.commentFeignClient = commentFeignClient;
        this.objectMapper = objectMapper;
    }


    @GetMapping(RestApiMappingComments.GET_PATH)
    public ResponseEntity<?> getRoomComments(
            @PathVariable("roomId") String roomId) {

        return commentFeignClient.getRoomComments(roomId);
    }

    @PostMapping(RestApiMappingComments.POST_PATH)
    public ResponseEntity<?> leaveCommentForRoom(
            @RequestBody LeaveCommentForRoomInput input,
            @PathVariable("roomId") String roomId) {

        return commentFeignClient.leaveCommentForRoom(input, roomId);
    }

    @PatchMapping(RestApiMappingComments.PATCH_PATH)
    public ResponseEntity<?> userEditOwnComment(
            @RequestBody UserEditOwnCommentInput input,
            @PathVariable("commentId") String commentId) {

        return commentFeignClient.userEditOwnComment(input, commentId);
    }

    @PutMapping(RestApiMappingComments.PUT_PATH)
    public ResponseEntity<?> adminEditAnyComment(
            @RequestBody AdminEditAnyCommentInput input,
            @PathVariable("commentId") String commentId) {

        return commentFeignClient.adminEditAnyComment(input, commentId);
    }

    @DeleteMapping(RestApiMappingComments.DELETE_PATH)
    public ResponseEntity<?> adminDeleteAnyComment(
            @RequestBody AdminDeleteAnyCommentInput input,
            @PathVariable("commentId") String commentId) {

        return commentFeignClient.adminDeleteAnyComment(input, commentId);
    }


}
