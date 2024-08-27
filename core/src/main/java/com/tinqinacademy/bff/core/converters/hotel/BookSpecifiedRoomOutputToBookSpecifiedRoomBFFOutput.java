package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.hotel.hotel.bookroom.BookSpecifiedRoomBFFOutput;
import com.tinqinacademy.bff.api.operations.hotel.system.admincreateroom.AdminCreateRoomBFFOutput;
import com.tinqinacademy.hotel.api.models.operations.hotel.bookroom.BookSpecifiedRoomOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookSpecifiedRoomOutputToBookSpecifiedRoomBFFOutput implements Converter<BookSpecifiedRoomOutput, BookSpecifiedRoomBFFOutput> {
    @Override
    public BookSpecifiedRoomBFFOutput convert(BookSpecifiedRoomOutput input) {
        log.info("Start BookSpecifiedRoomOutput to BookSpecifiedRoomBFFOutput input: {}", input);

        BookSpecifiedRoomBFFOutput output = BookSpecifiedRoomBFFOutput.builder()
                .build();

        log.info("End BookSpecifiedRoomOutput to BookSpecifiedRoomBFFOutput output: {}", output);
        return output;
    }
}
