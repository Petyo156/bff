package com.tinqinacademy.bff.api.operations.hotel.system.deleteroom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqinacademy.bff.api.base.OperationInput;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class DeleteRoomBFFInput implements OperationInput {
    @JsonIgnore
    private String id;
}
