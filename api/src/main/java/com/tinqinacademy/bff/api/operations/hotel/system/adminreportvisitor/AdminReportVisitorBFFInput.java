package com.tinqinacademy.bff.api.operations.hotel.system.adminreportvisitor;

import com.tinqinacademy.hotel.api.models.base.OperationInput;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AdminReportVisitorBFFInput implements OperationInput {
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

    @NotNull(message = "cardNoID can't be null!")
    @Size(min = 1, max = 5)
    private String cardNoID;

    @NotNull(message = "cardValidityID can't be null!")
    @Size(min = 1, max = 5)
    private String cardValidityID;

    @NotNull(message = "cardValidityID can't be null!")
    @Size(min = 1, max = 5)
    private String cardIssueAuthorityID;

    @FutureOrPresent
    private LocalDate cardIssueDateID;

    @NotNull(message = "roomNo can't be null!")
    private String roomNo;
}
