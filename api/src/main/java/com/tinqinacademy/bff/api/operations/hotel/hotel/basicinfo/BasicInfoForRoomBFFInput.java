package com.tinqinacademy.bff.api.operations.hotel.hotel.basicinfo;

import com.tinqinacademy.hotel.api.models.base.OperationInput;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BasicInfoForRoomBFFInput implements OperationInput {
    @NotNull(message = "id can't be null!")
    private String roomId;
}
