package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.operations.hotel.system.admincreateroom.AdminCreateRoomBFFOutput;
import com.tinqinacademy.bff.api.operations.hotel.system.registervisitor.RegisterVisitorBFFOutput;
import com.tinqinacademy.hotel.api.models.operations.system.registervisitor.RegisterVisitorOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegisterVisitorOutputToRegisterVisitorBFFOutput implements Converter<RegisterVisitorOutput, RegisterVisitorBFFOutput> {
    @Override
    public RegisterVisitorBFFOutput convert(RegisterVisitorOutput input) {
        log.info("Start RegisterVisitorOutput to RegisterVisitorBFFOutput input: {}", input);

        RegisterVisitorBFFOutput output = RegisterVisitorBFFOutput.builder()
                .build();

        log.info("End RegisterVisitorOutput to RegisterVisitorBFFOutput output: {}", output);
        return output;
    }
}
