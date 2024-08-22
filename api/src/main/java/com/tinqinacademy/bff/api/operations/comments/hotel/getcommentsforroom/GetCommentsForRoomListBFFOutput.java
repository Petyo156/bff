package com.tinqinacademy.bff.api.operations.comments.hotel.getcommentsforroom;

import com.tinqinacademy.comments.api.base.OperationOutput;
import com.tinqinacademy.comments.api.operations.hotel.getcommentsforroom.GetCommentsForRoomOutput;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class GetCommentsForRoomListBFFOutput implements OperationOutput {
    private List<GetCommentsForRoomOutput> list;
}
