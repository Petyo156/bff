package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.hotel.system.admincreateroom.AdminCreateRoomBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.system.adminpartialupdate.AdminPartialUpdateBFFInput;
import com.tinqinacademy.hotel.api.models.operations.system.adminpartialupdate.AdminPartialUpdateInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdminPartialUpdateBFFInputToAdminPartialUpdateInput implements Converter<AdminPartialUpdateBFFInput, AdminPartialUpdateInput> {
    @Override
    public AdminPartialUpdateInput convert(AdminPartialUpdateBFFInput input) {
        log.info("Start AdminPartialUpdateBFFInput to AdminPartialUpdateInput input: {}", input);

        AdminPartialUpdateInput output = AdminPartialUpdateInput.builder()
                .roomId(input.getRoomId())
                .bathroomType(input.getBathroomType())
                .bedSize(input.getBedSize())
                .floor(input.getFloor())
                .price(input.getPrice())
                .roomNumber(input.getRoomNumber())
                .build();

        log.info("End AdminPartialUpdateBFFInput to AdminPartialUpdateInput output: {}", output);
        return output;
    }
}
