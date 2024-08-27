package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.hotel.system.admincreateroom.AdminCreateRoomBFFOutput;
import com.tinqinacademy.bff.api.operations.hotel.system.adminreportvisitor.AdminReportVisitorBFFOutput;
import com.tinqinacademy.hotel.api.models.operations.system.adminreportvisitor.AdminReportVisitorOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdminReportVisitorOutputToAdminReportVisitorBFFOutput implements Converter<AdminReportVisitorOutput, AdminReportVisitorBFFOutput> {
    @Override
    public AdminReportVisitorBFFOutput convert(AdminReportVisitorOutput input) {
        log.info("Start AdminCreateRoomOutput to AdminCreateRoomBFFOutput input: {}", input);

        AdminReportVisitorBFFOutput output = AdminReportVisitorBFFOutput.builder()
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .cardIssueAuthorityID(input.getCardIssueAuthorityID())
                .cardIssueDateID(input.getCardIssueDateID())
                .visitorsData(input.getVisitorsData())
                .startDate(input.getStartDate())
                .endDate(input.getEndDate())
                .phoneNo(input.getPhoneNo())
                .build();

        log.info("End AdminCreateRoomOutput to AdminCreateRoomBFFOutput output: {}", output);
        return output;
    }
}
