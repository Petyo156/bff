package com.tinqinacademy.bff.core.converters.comments;

import com.tinqinacademy.bff.api.operations.comments.hotel.getcommentsforroom.GetCommentsForRoomBFFOutput;
import com.tinqinacademy.bff.api.operations.comments.hotel.leavecommentforroom.LeaveCommentForRoomBFFInput;
import com.tinqinacademy.comments.api.operations.hotel.leavecommentforroom.LeaveCommentForRoomInput;
import com.tinqinacademy.comments.api.operations.hotel.leavecommentforroom.LeaveCommentForRoomOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class LeaveCommentForRoomBFFInputToLeaveCommentForRoomInput implements Converter<LeaveCommentForRoomBFFInput, LeaveCommentForRoomInput> {
    @Override
    public LeaveCommentForRoomInput convert(LeaveCommentForRoomBFFInput input) {
        log.info("Start LeaveCommentForRoomBFFInput to LeaveCommentForRoomInput input: {}", input);

        LeaveCommentForRoomInput output = LeaveCommentForRoomInput.builder()
                .roomId(input.getRoomId())
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .content(input.getContent())
                .build();

        log.info("End LeaveCommentForRoomBFFInput to LeaveCommentForRoomInput output: {}", output);
        return output;
    }
}
