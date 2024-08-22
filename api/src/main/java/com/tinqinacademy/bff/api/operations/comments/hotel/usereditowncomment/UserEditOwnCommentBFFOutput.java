package com.tinqinacademy.bff.api.operations.comments.hotel.usereditowncomment;

import com.tinqinacademy.bff.api.base.OperationOutput;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserEditOwnCommentBFFOutput implements OperationOutput {
    private String id;
}
