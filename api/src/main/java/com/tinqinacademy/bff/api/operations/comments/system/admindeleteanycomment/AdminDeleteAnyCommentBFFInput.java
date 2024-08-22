package com.tinqinacademy.bff.api.operations.comments.system.admindeleteanycomment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqinacademy.comments.api.base.OperationInput;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@ToString
public class AdminDeleteAnyCommentBFFInput implements OperationInput {
    @JsonIgnore
    private String commentId;
}
