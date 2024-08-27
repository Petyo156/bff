package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.hotel.system.registervisitor.RegisterVisitorBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.system.registervisitor.RegisterVisitorsBFFDataInput;
import com.tinqinacademy.hotel.api.models.operations.hotel.checkroom.CheckRoomAvailabilityInput;
import com.tinqinacademy.hotel.api.models.operations.system.registervisitor.RegisterVisitorInput;
import com.tinqinacademy.hotel.api.models.operations.system.registervisitor.RegisterVisitorsDataInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegisterVisitorsDataBFFInputToRegisterVisitorsDataInput implements Converter<RegisterVisitorsBFFDataInput, RegisterVisitorsDataInput> {

    @Override
    public RegisterVisitorsDataInput convert(RegisterVisitorsBFFDataInput input) {
        log.info("Start RegisterVisitorsDataBFFInput to RegisterVisitorsDataInput input: {}", input);

        RegisterVisitorsDataInput output = RegisterVisitorsDataInput.builder()
                .birthDate(input.getBirthDate())
                .cardIssueAuthorityID(input.getCardIssueAuthorityID())
                .cardIssueDateID(input.getCardIssueDateID())
                .cardNoID(input.getCardNoID())
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .phoneNo(input.getPhoneNo())
                .build();

        log.info("End RegisterVisitorsDataBFFInput to RegisterVisitorsDataInput output: {}", output);
        return output;
    }
}
