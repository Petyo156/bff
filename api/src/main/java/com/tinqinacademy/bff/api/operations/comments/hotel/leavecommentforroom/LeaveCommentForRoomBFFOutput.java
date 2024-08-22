package com.tinqinacademy.bff.api.operations.comments.hotel.leavecommentforroom;

import com.tinqinacademy.comments.api.base.OperationOutput;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class LeaveCommentForRoomBFFOutput implements OperationOutput {
    private String id;
}
