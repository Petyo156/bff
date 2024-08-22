package com.tinqinacademy.bff.api.operations.comments.hotel.getcommentsforroom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqinacademy.bff.api.base.OperationInput;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@ToString
public class GetCommentsForRoomBFFInput implements OperationInput {
    @JsonIgnore
    private String roomId;
}
