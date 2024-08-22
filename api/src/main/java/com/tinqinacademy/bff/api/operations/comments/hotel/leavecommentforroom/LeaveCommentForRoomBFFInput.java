package com.tinqinacademy.bff.api.operations.comments.hotel.leavecommentforroom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqinacademy.bff.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@ToString
public class LeaveCommentForRoomBFFInput implements OperationInput {
    @JsonIgnore
    private String roomId;

    @NotBlank(message = "firstName can not be blank")
    private String firstName;

    @NotBlank(message = "lastName can not be blank")
    private String lastName;

    @NotBlank(message = "content can not be blank")
    private String content;
}
