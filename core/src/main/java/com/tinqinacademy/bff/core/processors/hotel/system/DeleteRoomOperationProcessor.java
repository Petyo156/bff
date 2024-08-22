package com.tinqinacademy.bff.core.processors.hotel.system;

import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.hotel.system.deleteroom.DeleteRoomBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.system.deleteroom.DeleteRoomBFFOperation;
import com.tinqinacademy.bff.api.operations.hotel.system.deleteroom.DeleteRoomBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.hotel.api.models.operations.system.deleteroom.DeleteRoomInput;
import com.tinqinacademy.hotel.api.models.operations.system.deleteroom.DeleteRoomOperation;
import com.tinqinacademy.hotel.api.models.operations.system.deleteroom.DeleteRoomOutput;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static io.vavr.API.$;
import static io.vavr.API.Match;
import static io.vavr.Predicates.instanceOf;

@Slf4j
@Service
public class DeleteRoomOperationProcessor extends BaseOperationProcessor implements DeleteRoomBFFOperation {

    @Autowired
    public DeleteRoomOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator) {
        super(conversionService, errorMapper, validator);
    }

    @Override
    public Either<Errors, DeleteRoomBFFOutput> process(DeleteRoomBFFInput input) {
        return null;
    }
}
