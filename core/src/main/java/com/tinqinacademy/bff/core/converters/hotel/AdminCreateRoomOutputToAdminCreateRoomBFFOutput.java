package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.comments.hotel.usereditowncomment.UserEditOwnCommentBFFOutput;
import com.tinqinacademy.bff.api.operations.hotel.system.admincreateroom.AdminCreateRoomBFFOutput;
import com.tinqinacademy.hotel.api.models.operations.system.admincreateroom.AdminCreateRoomOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdminCreateRoomOutputToAdminCreateRoomBFFOutput implements Converter<AdminCreateRoomOutput, AdminCreateRoomBFFOutput> {
    @Override
    public AdminCreateRoomBFFOutput convert(AdminCreateRoomOutput input) {
        log.info("Start AdminCreateRoomOutput to AdminCreateRoomBFFOutput input: {}", input);

        AdminCreateRoomBFFOutput output = AdminCreateRoomBFFOutput.builder()
                .id(input.getId())
                .build();

        log.info("End AdminCreateRoomOutput to AdminCreateRoomBFFOutput output: {}", output);
        return output;
    }
}
