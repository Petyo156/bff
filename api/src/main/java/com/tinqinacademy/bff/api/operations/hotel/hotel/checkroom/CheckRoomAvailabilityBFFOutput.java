package com.tinqinacademy.bff.api.operations.hotel.hotel.checkroom;

import com.tinqinacademy.hotel.api.models.base.OperationOutput;
import lombok.*;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CheckRoomAvailabilityBFFOutput implements OperationOutput {
    private List<UUID> ids;
}
