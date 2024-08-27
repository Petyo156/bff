package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.hotel.system.registervisitor.RegisterVisitorBFFInput;
import com.tinqinacademy.hotel.api.models.operations.hotel.checkroom.CheckRoomAvailabilityInput;
import com.tinqinacademy.hotel.api.models.operations.system.registervisitor.RegisterVisitorInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegisterVisitorBFFInputToRegisterVisitorInput implements Converter<RegisterVisitorBFFInput, RegisterVisitorInput> {
    @Override
    public RegisterVisitorInput convert(RegisterVisitorBFFInput input) {
        log.info("Start RegisterVisitorBFFInput to RegisterVisitorInput input: {}", input);

        RegisterVisitorInput output = RegisterVisitorInput.builder()
                .startDate(input.getStartDate())
                .endDate(input.getEndDate())
                .roomNumber(input.getRoomNumber())
                .build();

        log.info("End RegisterVisitorBFFInput to RegisterVisitorInput output: {}", output);
        return output;
    }
}
