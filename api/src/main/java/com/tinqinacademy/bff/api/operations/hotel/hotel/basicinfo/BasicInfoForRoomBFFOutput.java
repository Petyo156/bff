package com.tinqinacademy.bff.api.operations.hotel.hotel.basicinfo;

import com.tinqinacademy.hotel.api.models.base.OperationOutput;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BasicInfoForRoomBFFOutput implements OperationOutput {
    private UUID roomId;
    private BigDecimal price;
    private Integer floor;
    private List<String> bedSize;
    private String bathroomType;
    private List<LocalDate> datesOccupied;
}
