package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.hotel.system.admincreateroom.AdminCreateRoomBFFInput;
import com.tinqinacademy.hotel.api.models.operations.hotel.bookroom.BookSpecifiedRoomInput;
import com.tinqinacademy.hotel.api.models.operations.system.admincreateroom.AdminCreateRoomInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdminCreateRoomInputToAdminCreateRoomBFFInput implements Converter<AdminCreateRoomInput, AdminCreateRoomBFFInput> {
    @Override
    public AdminCreateRoomBFFInput convert(AdminCreateRoomInput input) {
        log.info("Start AdminCreateRoomBFFInput to AdminCreateRoomInput input: {}", input);

        AdminCreateRoomBFFInput output = AdminCreateRoomBFFInput.builder()
                .roomNumber(input.getRoomNumber())
                .bathroomType(input.getBathroomType())
                .price(input.getPrice())
                .floor(input.getFloor())
                .bedSizes(input.getBedSizes())
                .build();

        log.info("End AdminCreateRoomBFFInput to AdminCreateRoomInput output: {}", output);
        return output;
    }
}
