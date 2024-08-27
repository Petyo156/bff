package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.hotel.hotel.basicinfo.BasicInfoForRoomBFFOutput;
import com.tinqinacademy.bff.api.operations.hotel.hotel.bookroom.BookSpecifiedRoomBFFInput;
import com.tinqinacademy.hotel.api.models.operations.hotel.bookroom.BookSpecifiedRoomInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookSpecifiedRoomBFFInputToBookSpecifiedRoomInput implements Converter<BookSpecifiedRoomBFFInput, BookSpecifiedRoomInput> {
    @Override
    public BookSpecifiedRoomInput convert(BookSpecifiedRoomBFFInput input) {
        log.info("Start BookSpecifiedRoomBFFInput to BookSpecifiedRoomInput input: {}", input);

        BookSpecifiedRoomInput output = BookSpecifiedRoomInput.builder()
                .roomId(input.getRoomId())
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .phoneNo(input.getPhoneNo())
                .startDate(input.getStartDate())
                .endDate(input.getEndDate())
                .userId(input.getUserId())
                .build();

        log.info("End BookSpecifiedRoomBFFInput to BookSpecifiedRoomInput output: {}", output);
        return output;
    }
}
