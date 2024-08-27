package com.tinqinacademy.bff.core.converters.comments;

import com.tinqinacademy.bff.api.operations.comments.hotel.getcommentsforroom.GetCommentsForRoomListBFFOutput;
import com.tinqinacademy.comments.api.operations.hotel.getcommentsforroom.GetCommentsForRoomListOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class GetCommentsForRoomOutputListToGetCommentsForRoomBFFOutputList implements Converter<GetCommentsForRoomListOutput, GetCommentsForRoomListBFFOutput> {
    private final GetCommentsForRoomOutputToGetCommentsForRoomBFFOutput commentsConverter;

    @Override
    public GetCommentsForRoomListBFFOutput convert(GetCommentsForRoomListOutput input) {
        log.info("Start converting from GetCommentsOutputList to GetCommentsBFFOutputList with input: {}", input);

        GetCommentsForRoomListBFFOutput output = GetCommentsForRoomListBFFOutput.builder()
                .list(input.getList().stream()
                        .map(commentsConverter::convert)
                        .toList())
                .build();

        log.info("End converting from GetCommentsOutputList to GetCommentsBFFOutputList with output: {}", output);
        return output;
    }
}