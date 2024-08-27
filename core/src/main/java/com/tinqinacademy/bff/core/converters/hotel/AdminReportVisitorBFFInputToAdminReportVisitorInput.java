package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.hotel.system.adminreportvisitor.AdminReportVisitorBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.system.adminreportvisitor.AdminReportVisitorBFFOutput;
import com.tinqinacademy.hotel.api.models.operations.system.adminpartialupdate.AdminPartialUpdateInput;
import com.tinqinacademy.hotel.api.models.operations.system.adminreportvisitor.AdminReportVisitorInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdminReportVisitorBFFInputToAdminReportVisitorInput implements Converter<AdminReportVisitorBFFInput, AdminReportVisitorInput> {
    @Override
    public AdminReportVisitorInput convert(AdminReportVisitorBFFInput input) {
        log.info("Start AdminReportVisitorBFFInput to AdminReportVisitorInput input: {}", input);

        AdminReportVisitorInput output = AdminReportVisitorInput.builder()
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .endDate(input.getEndDate())
                .phoneNo(input.getRoomNo())
                .cardIssueAuthorityID(input.getCardIssueAuthorityID())
                .cardIssueDateID(input.getCardIssueDateID())
                .cardValidityID(input.getCardValidityID())
                .cardNoID(input.getCardNoID())
                .roomNo(input.getRoomNo())
                .build();

        log.info("End AdminReportVisitorBFFInput to AdminReportVisitorInput output: {}", output);
        return output;
    }
}
