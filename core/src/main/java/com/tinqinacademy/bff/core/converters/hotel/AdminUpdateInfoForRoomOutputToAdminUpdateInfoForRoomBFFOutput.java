package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.hotel.system.admincreateroom.AdminCreateRoomBFFOutput;
import com.tinqinacademy.bff.api.operations.hotel.system.adminupdateinfoforroom.AdminUpdateInfoForRoomBFFOutput;
import com.tinqinacademy.hotel.api.models.operations.system.adminupdateinfoforroom.AdminUpdateInfoForRoomOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdminUpdateInfoForRoomOutputToAdminUpdateInfoForRoomBFFOutput implements Converter<AdminUpdateInfoForRoomOutput, AdminUpdateInfoForRoomBFFOutput> {
    @Override
    public AdminUpdateInfoForRoomBFFOutput convert(AdminUpdateInfoForRoomOutput input) {
        log.info("Start AdminUpdateInfoForRoomOutput to AdminUpdateInfoForRoomBFFOutput input: {}", input);

        AdminUpdateInfoForRoomBFFOutput output = AdminUpdateInfoForRoomBFFOutput.builder()
                .id(input.getId())
                .build();

        log.info("End AdminUpdateInfoForRoomOutput to AdminUpdateInfoForRoomBFFOutput output: {}", output);
        return output;
    }
}
