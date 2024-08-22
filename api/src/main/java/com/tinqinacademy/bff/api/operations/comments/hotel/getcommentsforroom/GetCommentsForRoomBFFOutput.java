package com.tinqinacademy.bff.api.operations.comments.hotel.getcommentsforroom;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class GetCommentsForRoomBFFOutput {
    private String id;
    private String firstName;
    private String lastName;
    private String content;
    private LocalDate publishDate;
    private LocalDate lastEditedDate;
    private String lastEditedBy;
}
