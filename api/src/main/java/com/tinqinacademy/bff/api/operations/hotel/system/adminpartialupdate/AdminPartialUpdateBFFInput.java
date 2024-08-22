package com.tinqinacademy.bff.api.operations.hotel.system.adminpartialupdate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqinacademy.bff.api.base.OperationInput;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@ToString
public class AdminPartialUpdateBFFInput implements OperationInput {
    @JsonIgnore
    private UUID roomId;

    private String bedSize;

    private String bathroomType;

    @Min(1)
    private Integer floor;

    private String roomNumber;

    @PositiveOrZero
    private BigDecimal price;
}
