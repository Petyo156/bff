package com.tinqinacademy.bff.api.operations.hotel.system.adminreportvisitor;

import com.tinqinacademy.bff.api.base.OperationOutput;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AdminReportVisitorBFFOutput implements OperationOutput {
    private List<String> visitorsData;
    private LocalDate startDate;
    private LocalDate endDate;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String cardNoID;
    private String cardValidityID;
    private String cardIssueAuthorityID;
    private LocalDate cardIssueDateID;
}
