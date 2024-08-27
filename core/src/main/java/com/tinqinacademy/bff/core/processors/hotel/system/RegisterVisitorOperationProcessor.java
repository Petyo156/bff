package com.tinqinacademy.bff.core.processors.hotel.system;

import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.hotel.system.registervisitor.RegisterVisitorBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.system.registervisitor.RegisterVisitorBFFOperation;
import com.tinqinacademy.bff.api.operations.hotel.system.registervisitor.RegisterVisitorBFFOutput;
import com.tinqinacademy.bff.api.operations.hotel.system.registervisitor.RegisterVisitorsBFFDataInput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.hotel.api.models.operations.system.registervisitor.RegisterVisitorInput;
import com.tinqinacademy.hotel.api.models.operations.system.registervisitor.RegisterVisitorOutput;
import com.tinqinacademy.hotel.api.models.operations.system.registervisitor.RegisterVisitorsDataInput;
import com.tinqinacademy.hotel.restexport.HotelClient;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.vavr.API.*;
import static io.vavr.Predicates.instanceOf;

@Slf4j
@Service
public class RegisterVisitorOperationProcessor extends BaseOperationProcessor implements RegisterVisitorBFFOperation {
    private final HotelClient hotelClient;

    @Autowired
    public RegisterVisitorOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator, HotelClient hotelClient) {
        super(conversionService, errorMapper, validator);
        this.hotelClient = hotelClient;
    }

    @Override
    public Either<Errors, RegisterVisitorBFFOutput> process(RegisterVisitorBFFInput input) {
        return Try.of(() -> {
                    log.info("Start registerVisitor input: {}", input);

                    validateInput(input);

                    RegisterVisitorInput registerVisitorInput = conversionService.convert(input, RegisterVisitorInput.class);

                    RegisterVisitorsDataInput registerVisitorsDataInput = conversionService.convert(input.getRegisterVisitorsDataInputList(), RegisterVisitorsDataInput.class);

                    registerVisitorInput.setRegisterVisitorsDataInputList(List.of(registerVisitorsDataInput));

                    RegisterVisitorOutput registerVisitorOutput = hotelClient.registerVisitor(registerVisitorInput);

                    RegisterVisitorBFFOutput output = conversionService.convert(registerVisitorOutput, RegisterVisitorBFFOutput.class);

                    log.info("End registerVisitor output: {}", output);
                    return output;
                })
                .toEither()
                .mapLeft(throwable -> Match(throwable).of(
                        Case($(instanceOf(IllegalArgumentException.class)),
                                errorMapper.handleError(throwable, HttpStatus.BAD_REQUEST))
                ));
    }
}
