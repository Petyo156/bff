package com.tinqinacademy.bff.api.operations.comments.system.admineditanycomment;

import com.tinqinacademy.comments.api.base.OperationOutput;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AdminEditAnyCommentBFFOutput implements OperationOutput {
    private String id;
}
