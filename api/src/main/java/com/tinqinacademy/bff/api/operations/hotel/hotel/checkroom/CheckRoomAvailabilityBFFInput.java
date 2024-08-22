package com.tinqinacademy.bff.api.operations.hotel.hotel.checkroom;

import com.tinqinacademy.hotel.api.models.base.OperationInput;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CheckRoomAvailabilityBFFInput implements OperationInput {
    @FutureOrPresent
    private LocalDate startDate;

    @FutureOrPresent
    private LocalDate endDate;

    @NotNull(message = "bedSize can't be null!")
    private String bedSize;

    @NotNull(message = "bathroomType can't be null!")
    private String bathroomType;
}
