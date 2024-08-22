package com.tinqinacademy.bff.api.operations.comments.system.admineditanycomment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqinacademy.comments.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@ToString
public class AdminEditAnyCommentBFFInput implements OperationInput {
    @JsonIgnore
    private String commentId;

    @NotBlank(message = "roomNo cant be blank")
    private String roomNo;

    @NotBlank(message = "firstName cant be blank")
    private String firstName;

    @NotBlank(message = "lastName cant be blank")
    private String lastName;

    @NotBlank(message = "content cant be blank")
    private String content;
}
