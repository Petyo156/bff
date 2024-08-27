package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.hotel.hotel.checkroom.CheckRoomAvailabilityBFFInput;
import com.tinqinacademy.hotel.api.models.operations.hotel.bookroom.BookSpecifiedRoomInput;
import com.tinqinacademy.hotel.api.models.operations.hotel.checkroom.CheckRoomAvailabilityInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CheckRoomAvailabilityBFFInputToCheckRoomAvailabilityInput implements Converter<CheckRoomAvailabilityBFFInput, CheckRoomAvailabilityInput> {
    @Override
    public CheckRoomAvailabilityInput convert(CheckRoomAvailabilityBFFInput input) {
        log.info("Start CheckRoomAvailabilityBFFInput to CheckRoomAvailabilityInput input: {}", input);

        CheckRoomAvailabilityInput output = CheckRoomAvailabilityInput.builder()
                .bathroomType(input.getBathroomType())
                .bedSize(input.getBedSize())
                .endDate(input.getEndDate())
                .build();

        log.info("End CheckRoomAvailabilityBFFInput to CheckRoomAvailabilityInput output: {}", output);
        return output;
    }
}
