package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.hotel.system.admincreateroom.AdminCreateRoomBFFOutput;
import com.tinqinacademy.bff.api.operations.hotel.system.deleteroom.DeleteRoomBFFOutput;
import com.tinqinacademy.hotel.api.models.operations.system.deleteroom.DeleteRoomOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteRoomOutputToDeleteRoomBFFOutput implements Converter<DeleteRoomOutput, DeleteRoomBFFOutput> {
    @Override
    public DeleteRoomBFFOutput convert(DeleteRoomOutput input) {
        log.info("Start DeleteRoomOutput to DeleteRoomBFFOutput input: {}", input);

        DeleteRoomBFFOutput output = DeleteRoomBFFOutput.builder()
                .build();

        log.info("End DeleteRoomOutput to DeleteRoomBFFOutput output: {}", output);
        return output;
    }
}
