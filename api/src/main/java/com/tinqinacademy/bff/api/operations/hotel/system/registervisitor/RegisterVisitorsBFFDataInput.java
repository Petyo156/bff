package com.tinqinacademy.bff.api.operations.hotel.system.registervisitor;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RegisterVisitorsBFFDataInput {
    @NotNull(message = "firstName can't be null!")
    @Size(min = 1, message = "firstName - atleast 1 char long")
    private String firstName;

    @NotNull(message = "lastName can't be null!")
    @Size(min = 1, message = "lastName - atleast 1 char long")
    private String lastName;

    @NotNull(message = "phoneNo can't be null!")
    @Size(min = 5, max = 5, message = "phoneNo - 5 chars long")
    private String phoneNo;

    @NotNull(message = "cardNoID can't be null!")
    @Size(min = 1, max = 5)
    private String cardNoID;

    @NotNull(message = "cardValidityID can't be null!")
    @Size(min = 1, max = 5)
    private String cardValidityID;

    @NotNull(message = "cardIssueAuthorityID can't be null!")
    @Size(min = 1, max = 5)
    private String cardIssueAuthorityID;

    @FutureOrPresent
    private LocalDate cardIssueDateID;

    @Past
    private LocalDate birthDate;
}
