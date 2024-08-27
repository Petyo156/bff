package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.hotel.system.admincreateroom.AdminCreateRoomBFFOutput;
import com.tinqinacademy.bff.api.operations.hotel.system.adminpartialupdate.AdminPartialUpdateBFFOutput;
import com.tinqinacademy.hotel.api.models.operations.system.adminpartialupdate.AdminPartialUpdateOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdminPartialUpdateOutputToAdminPartialUpdateBFFOutput implements Converter<AdminPartialUpdateOutput, AdminPartialUpdateBFFOutput> {
    @Override
    public AdminPartialUpdateBFFOutput convert(AdminPartialUpdateOutput input) {
        log.info("Start AdminPartialUpdateOutput to AdminPartialUpdateBFFOutput input: {}", input);

        AdminPartialUpdateBFFOutput output = AdminPartialUpdateBFFOutput.builder()
                .id(input.getId())
                .build();

        log.info("End AdminPartialUpdateOutput to AdminPartialUpdateBFFOutput output: {}", output);
        return output;
    }
}
