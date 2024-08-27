package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.hotel.hotel.unbookbookedroom.UnbookBookedRoomBFFOutput;
import com.tinqinacademy.bff.api.operations.hotel.system.admincreateroom.AdminCreateRoomBFFOutput;
import com.tinqinacademy.hotel.api.models.operations.hotel.unbookbookedroom.UnbookBookedRoomOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UnbookBookedRoomOutputToUnbookBookedRoomBFFOutput implements Converter<UnbookBookedRoomOutput, UnbookBookedRoomBFFOutput> {
    @Override
    public UnbookBookedRoomBFFOutput convert(UnbookBookedRoomOutput input) {
        log.info("Start UnbookBookedRoomOutput to UnbookBookedRoomBFFOutput input: {}", input);

        UnbookBookedRoomBFFOutput output = UnbookBookedRoomBFFOutput.builder()
                .build();

        log.info("End UnbookBookedRoomOutput to UnbookBookedRoomBFFOutput output: {}", output);
        return output;
    }
}
