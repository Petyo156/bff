package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.hotel.hotel.basicinfo.BasicInfoForRoomBFFOutput;
import com.tinqinacademy.bff.api.operations.hotel.system.admincreateroom.AdminCreateRoomBFFOutput;
import com.tinqinacademy.hotel.api.models.operations.hotel.basicinfo.BasicInfoForRoomOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BasicInfoForRoomOutputToBasicInfoForRoomBFFOutput implements Converter<BasicInfoForRoomOutput, BasicInfoForRoomBFFOutput> {
    @Override
    public BasicInfoForRoomBFFOutput convert(BasicInfoForRoomOutput input) {
        log.info("Start BasicInfoForRoomOutput to BasicInfoForRoomBFFOutput input: {}", input);

        BasicInfoForRoomBFFOutput output = BasicInfoForRoomBFFOutput.builder()
                .roomId(input.getRoomId())
                .bathroomType(input.getBathroomType())
                .price(input.getPrice())
                .floor(input.getFloor())
                .bedSize(input.getBedSize())
                .datesOccupied(input.getDatesOccupied())
                .build();

        log.info("End BasicInfoForRoomOutput to BasicInfoForRoomBFFOutput output: {}", output);
        return output;
    }
}
