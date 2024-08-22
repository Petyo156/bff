package com.tinqinacademy.bff.api.operations.hotel.hotel.bookroom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqinacademy.hotel.api.models.base.OperationInput;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder=true)
@ToString
public class BookSpecifiedRoomBFFInput implements OperationInput {
    @JsonIgnore
    private String roomId;

    private String userId;

    @FutureOrPresent
    private LocalDate startDate;

    @FutureOrPresent
    private LocalDate endDate;

    @NotNull(message = "firstName can't be null!")
    private String firstName;

    @NotNull(message = "lastName can't be null!")
    private String lastName;

    @NotNull(message = "phoneNo can't be null!")
    private String phoneNo;
}
