package com.tinqinacademy.bff.core.processors.hotel.system;

import com.tinqinacademy.bff.api.operations.hotel.system.adminupdateinfoforroom.AdminUpdateInfoForRoomBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.system.adminupdateinfoforroom.AdminUpdateInfoForRoomBFFOperation;
import com.tinqinacademy.bff.api.operations.hotel.system.adminupdateinfoforroom.AdminUpdateInfoForRoomBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.hotel.api.models.exceptions.Errors;
import com.tinqinacademy.hotel.api.models.operations.system.adminupdateinfoforroom.AdminUpdateInfoForRoomInput;
import com.tinqinacademy.hotel.api.models.operations.system.adminupdateinfoforroom.AdminUpdateInfoForRoomOperation;
import com.tinqinacademy.hotel.api.models.operations.system.adminupdateinfoforroom.AdminUpdateInfoForRoomOutput;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static io.vavr.API.$;
import static io.vavr.API.Match;
import static io.vavr.Predicates.instanceOf;

@Service
@Slf4j
public class AdminUpdateInfoForRoomOperationProcessor extends BaseOperationProcessor implements AdminUpdateInfoForRoomBFFOperation {

    public AdminUpdateInfoForRoomOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator) {
        super(conversionService, errorMapper, validator);
    }

    @Override
    public Either<Errors, AdminUpdateInfoForRoomBFFOutput> process(AdminUpdateInfoForRoomBFFInput input) {
        return null;
    }
}
