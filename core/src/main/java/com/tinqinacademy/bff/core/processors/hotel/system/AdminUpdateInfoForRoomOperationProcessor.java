package com.tinqinacademy.bff.core.processors.hotel.system;

import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.hotel.system.adminpartialupdate.AdminPartialUpdateBFFOutput;
import com.tinqinacademy.bff.api.operations.hotel.system.adminupdateinfoforroom.AdminUpdateInfoForRoomBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.system.adminupdateinfoforroom.AdminUpdateInfoForRoomBFFOperation;
import com.tinqinacademy.bff.api.operations.hotel.system.adminupdateinfoforroom.AdminUpdateInfoForRoomBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.hotel.api.models.operations.system.adminpartialupdate.AdminPartialUpdateInput;
import com.tinqinacademy.hotel.api.models.operations.system.adminpartialupdate.AdminPartialUpdateOutput;
import com.tinqinacademy.hotel.api.models.operations.system.adminupdateinfoforroom.AdminUpdateInfoForRoomInput;
import com.tinqinacademy.hotel.api.models.operations.system.adminupdateinfoforroom.AdminUpdateInfoForRoomOutput;
import com.tinqinacademy.hotel.restexport.HotelClient;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static io.vavr.API.*;
import static io.vavr.Predicates.instanceOf;

@Service
@Slf4j
public class AdminUpdateInfoForRoomOperationProcessor extends BaseOperationProcessor implements AdminUpdateInfoForRoomBFFOperation {
    private final HotelClient hotelClient;

    @Autowired
    public AdminUpdateInfoForRoomOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator, HotelClient hotelClient) {
        super(conversionService, errorMapper, validator);
        this.hotelClient = hotelClient;
    }

    @Override
    public Either<Errors, AdminUpdateInfoForRoomBFFOutput> process(AdminUpdateInfoForRoomBFFInput input) {
        return Try.of(() -> {
                    log.info("Start adminUpdateInfoForRoom input: {}", input);

                    validateInput(input);

                    AdminUpdateInfoForRoomInput adminPartialUpdateInput = conversionService.convert(input, AdminUpdateInfoForRoomInput.class);

                    AdminUpdateInfoForRoomOutput adminUpdateInfoForRoomOutput = hotelClient.adminUpdateInfoForRoom(adminPartialUpdateInput, input.getId());

                    AdminUpdateInfoForRoomBFFOutput output = conversionService.convert(adminUpdateInfoForRoomOutput, AdminUpdateInfoForRoomBFFOutput.class);

                    log.info("End adminUpdateInfoForRoom output: {}", output);
                    return output;
                })
                .toEither()
                .mapLeft(throwable -> Match(throwable).of(
                        Case($(instanceOf(IllegalArgumentException.class)),
                                errorMapper.handleError(throwable, HttpStatus.BAD_REQUEST))
                ));
    }
}
