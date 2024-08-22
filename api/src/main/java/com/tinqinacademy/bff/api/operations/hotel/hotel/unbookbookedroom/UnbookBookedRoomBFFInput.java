package com.tinqinacademy.bff.api.operations.hotel.hotel.unbookbookedroom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqinacademy.hotel.api.models.base.OperationInput;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@ToString
public class UnbookBookedRoomBFFInput implements OperationInput {
    @JsonIgnore
    private String bookingId;
}
