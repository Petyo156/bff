package com.tinqinacademy.bff.core.processors.hotel.system;

import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.hotel.system.adminreportvisitor.AdminReportVisitorBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.system.adminreportvisitor.AdminReportVisitorBFFOperation;
import com.tinqinacademy.bff.api.operations.hotel.system.adminreportvisitor.AdminReportVisitorBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.hotel.api.models.operations.system.adminreportvisitor.AdminReportVisitorInput;
import com.tinqinacademy.hotel.api.models.operations.system.adminreportvisitor.AdminReportVisitorOutput;
import com.tinqinacademy.hotel.restexport.HotelClient;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static io.vavr.API.*;
import static io.vavr.Predicates.instanceOf;

@Slf4j
@Service
public class AdminReportVisitorOperationProcessor extends BaseOperationProcessor implements AdminReportVisitorBFFOperation {
    private final HotelClient hotelClient;

    @Autowired
    public AdminReportVisitorOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator, HotelClient hotelClient) {
        super(conversionService, errorMapper, validator);
        this.hotelClient = hotelClient;
    }

    @Override
    public Either<Errors, AdminReportVisitorBFFOutput> process(AdminReportVisitorBFFInput input) {
        return Try.of(() -> {
                    log.info("Start adminReportVisitor input: {}", input);

                    validateInput(input);

                    //AdminReportVisitorInput adminReportVisitorInput = conversionService.convert(input, AdminReportVisitorInput.class);

                    AdminReportVisitorOutput adminReportVisitorOutput = hotelClient.adminReportVisitor(
                            new ArrayList<>(), input.getStartDate(), input.getEndDate(),
                            input.getFirstName(), input.getLastName(), input.getRoomNo(),
                            input.getCardNoID(), input.getCardValidityID(),
                            input.getCardIssueAuthorityID(), input.getCardIssueDateID()
                    );

                    AdminReportVisitorBFFOutput output = conversionService.convert(adminReportVisitorOutput, AdminReportVisitorBFFOutput.class);

                    log.info("End adminReportVisitor output: {}", output);
                    return output;
                })
                .toEither()
                .mapLeft(throwable -> Match(throwable).of(
                        Case($(instanceOf(IllegalArgumentException.class)),
                                errorMapper.handleError(throwable, HttpStatus.BAD_REQUEST))
                ));
    }
}
