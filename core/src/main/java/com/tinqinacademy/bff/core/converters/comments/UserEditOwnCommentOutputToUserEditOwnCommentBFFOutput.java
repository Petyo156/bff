package com.tinqinacademy.bff.core.converters.comments;

import com.tinqinacademy.bff.api.operations.comments.hotel.usereditowncomment.UserEditOwnCommentBFFOutput;
import com.tinqinacademy.comments.api.operations.hotel.usereditowncomment.UserEditOwnCommentOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserEditOwnCommentOutputToUserEditOwnCommentBFFOutput implements Converter<UserEditOwnCommentOutput, UserEditOwnCommentBFFOutput> {
    @Override
    public UserEditOwnCommentBFFOutput convert(UserEditOwnCommentOutput input) {
        log.info("Start UserEditOwnCommentOutput to UserEditOwnCommentBFFOutput input: {}", input);

        UserEditOwnCommentBFFOutput output = UserEditOwnCommentBFFOutput.builder()
                .id(input.getId())
                .build();

        log.info("End UserEditOwnCommentOutput to UserEditOwnCommentBFFOutput output: {}", output);
        return output;
    }
}
