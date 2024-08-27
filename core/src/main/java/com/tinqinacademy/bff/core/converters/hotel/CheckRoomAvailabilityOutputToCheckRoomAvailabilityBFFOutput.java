package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.hotel.hotel.checkroom.CheckRoomAvailabilityBFFOutput;
import com.tinqinacademy.bff.api.operations.hotel.system.admincreateroom.AdminCreateRoomBFFOutput;
import com.tinqinacademy.hotel.api.models.operations.hotel.checkroom.CheckRoomAvailabilityOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CheckRoomAvailabilityOutputToCheckRoomAvailabilityBFFOutput implements Converter<CheckRoomAvailabilityOutput, CheckRoomAvailabilityBFFOutput> {
    @Override
    public CheckRoomAvailabilityBFFOutput convert(CheckRoomAvailabilityOutput input) {
        log.info("Start CheckRoomAvailabilityOutput to CheckRoomAvailabilityBFFOutput input: {}", input);

        CheckRoomAvailabilityBFFOutput output = CheckRoomAvailabilityBFFOutput.builder()
                .ids(input.getIds())
                .build();

        log.info("End CheckRoomAvailabilityOutput to CheckRoomAvailabilityBFFOutput output: {}", output);
        return output;
    }
}
