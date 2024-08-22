package com.tinqinacademy.bff.api.operations.hotel.system.adminpartialupdate;

import com.tinqinacademy.bff.api.base.OperationOutput;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AdminPartialUpdateBFFOutput implements OperationOutput {
    private String id;
}
