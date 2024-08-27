package com.tinqinacademy.bff.core.converters.comments;

import com.tinqinacademy.bff.api.operations.comments.hotel.getcommentsforroom.GetCommentsForRoomBFFOutput;
import com.tinqinacademy.comments.api.operations.hotel.getcommentsforroom.GetCommentsForRoomOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class GetCommentsForRoomOutputToGetCommentsForRoomBFFOutput implements Converter<GetCommentsForRoomOutput, GetCommentsForRoomBFFOutput> {
    @Override
    public GetCommentsForRoomBFFOutput convert(GetCommentsForRoomOutput input) {
        log.info("Start GetCommentsForRoomOutput to GetCommentsForRoomBFFOutput input: {}", input);

        GetCommentsForRoomBFFOutput output = GetCommentsForRoomBFFOutput.builder()
                .id(input.getId())
//                .userId(input.getUserId())
                .content(input.getContent())
                .publishDate(input.getPublishDate())
                .lastEditedBy(input.getLastEditedBy())
                .lastEditedDate(input.getLastEditedDate())
                .build();

        log.info("End GetCommentsForRoomOutput to GetCommentsForRoomBFFOutput output: {}", output);
        return output;
    }
}
