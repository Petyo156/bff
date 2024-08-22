package com.tinqinacademy.bff.api.operations.comments.hotel.getcommentsforroom;

import com.tinqinacademy.bff.api.base.OperationOutput;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class GetCommentsForRoomListBFFOutput implements OperationOutput {
    private List<GetCommentsForRoomBFFOutput> list;
}
