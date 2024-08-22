package com.tinqinacademy.bff.api.operations.hotel.system.admincreateroom;

import com.tinqinacademy.hotel.api.models.base.OperationOutput;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AdminCreateRoomBFFOutput implements OperationOutput {
    private UUID id;
}
