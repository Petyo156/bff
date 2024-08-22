package com.tinqinacademy.bff.api.operations.hotel.system.adminupdateinfoforroom;

import com.tinqinacademy.bff.api.base.OperationOutput;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AdminUpdateInfoForRoomBFFOutput implements OperationOutput {
    private UUID id;
}
