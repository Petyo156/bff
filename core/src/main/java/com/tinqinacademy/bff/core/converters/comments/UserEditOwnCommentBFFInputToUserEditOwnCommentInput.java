package com.tinqinacademy.bff.core.converters.comments;

import com.tinqinacademy.bff.api.operations.comments.hotel.usereditowncomment.UserEditOwnCommentBFFInput;
import com.tinqinacademy.comments.api.operations.hotel.leavecommentforroom.LeaveCommentForRoomInput;
import com.tinqinacademy.comments.api.operations.hotel.usereditowncomment.UserEditOwnCommentInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserEditOwnCommentBFFInputToUserEditOwnCommentInput implements Converter<UserEditOwnCommentBFFInput, UserEditOwnCommentInput> {
    @Override
    public UserEditOwnCommentInput convert(UserEditOwnCommentBFFInput input) {
        log.info("Start UserEditOwnCommentBFFInput to UserEditOwnCommentInput input: {}", input);

        UserEditOwnCommentInput output = UserEditOwnCommentInput.builder()
                .commentId(input.getCommentId())
                .content(input.getContent())
                .build();

        log.info("End UserEditOwnCommentBFFInput to UserEditOwnCommentInput output: {}", output);
        return output;
    }
}
