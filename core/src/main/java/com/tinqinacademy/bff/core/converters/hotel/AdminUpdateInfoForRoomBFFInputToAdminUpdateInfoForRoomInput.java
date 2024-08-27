package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.hotel.system.adminupdateinfoforroom.AdminUpdateInfoForRoomBFFInput;
import com.tinqinacademy.hotel.api.models.operations.system.adminreportvisitor.AdminReportVisitorInput;
import com.tinqinacademy.hotel.api.models.operations.system.adminupdateinfoforroom.AdminUpdateInfoForRoomInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdminUpdateInfoForRoomBFFInputToAdminUpdateInfoForRoomInput implements Converter<AdminUpdateInfoForRoomBFFInput, AdminUpdateInfoForRoomInput> {
    @Override
    public AdminUpdateInfoForRoomInput convert(AdminUpdateInfoForRoomBFFInput input) {
        log.info("Start AdminUpdateInfoForRoomBFFInput to AdminUpdateInfoForRoomInput input: {}", input);

        AdminUpdateInfoForRoomInput output = AdminUpdateInfoForRoomInput.builder()
                .id(input.getId())
                .roomNo(input.getRoomNo())
                .bathroomType(input.getBathroomType())
                .floor(input.getFloor())
                .bedSizes(input.getBedSizes())
                .price(input.getPrice())
                .build();

        log.info("End AdminUpdateInfoForRoomBFFInput to AdminUpdateInfoForRoomInput output: {}", output);
        return output;
    }
}
