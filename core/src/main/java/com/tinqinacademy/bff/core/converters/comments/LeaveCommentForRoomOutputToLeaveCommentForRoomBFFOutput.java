package com.tinqinacademy.bff.core.converters.comments;

import com.tinqinacademy.bff.api.operations.comments.hotel.leavecommentforroom.LeaveCommentForRoomBFFOutput;
import com.tinqinacademy.comments.api.operations.hotel.leavecommentforroom.LeaveCommentForRoomOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class LeaveCommentForRoomOutputToLeaveCommentForRoomBFFOutput implements Converter<LeaveCommentForRoomOutput, LeaveCommentForRoomBFFOutput> {
    @Override
    public LeaveCommentForRoomBFFOutput convert(LeaveCommentForRoomOutput input) {
        log.info("Start LeaveCommentForRoomOutput to LeaveCommentForRoomBFFOutput input: {}", input);

        LeaveCommentForRoomBFFOutput output = LeaveCommentForRoomBFFOutput.builder()
                .id(input.getId())
                .build();

        log.info("End LeaveCommentForRoomOutput to LeaveCommentForRoomBFFOutput output: {}", output);
        return output;
    }
}
