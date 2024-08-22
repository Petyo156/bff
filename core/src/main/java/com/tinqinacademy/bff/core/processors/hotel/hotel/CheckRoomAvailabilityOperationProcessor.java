package com.tinqinacademy.bff.core.processors.hotel.hotel;

import com.tinqinacademy.bff.api.operations.hotel.hotel.checkroom.CheckRoomAvailabilityBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.hotel.checkroom.CheckRoomAvailabilityBFFOperation;
import com.tinqinacademy.bff.api.operations.hotel.hotel.checkroom.CheckRoomAvailabilityBFFOutput;
import com.tinqinacademy.bff.core.errorhandling.ErrorMapper;
import com.tinqinacademy.bff.core.processors.BaseOperationProcessor;
import com.tinqinacademy.hotel.api.models.exceptions.Errors;
import com.tinqinacademy.hotel.api.models.operations.hotel.checkroom.CheckRoomAvailabilityInput;
import com.tinqinacademy.hotel.api.models.operations.hotel.checkroom.CheckRoomAvailabilityOperation;
import com.tinqinacademy.hotel.api.models.operations.hotel.checkroom.CheckRoomAvailabilityOutput;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static io.vavr.API.$;
import static io.vavr.API.Match;
import static io.vavr.Predicates.instanceOf;

@Slf4j
@Service
public class CheckRoomAvailabilityOperationProcessor extends BaseOperationProcessor implements CheckRoomAvailabilityBFFOperation {

    @Autowired
    public CheckRoomAvailabilityOperationProcessor(ConversionService conversionService, ErrorMapper errorMapper, Validator validator) {
        super(conversionService, errorMapper, validator);
    }

    @Override
    public Either<Errors, CheckRoomAvailabilityBFFOutput> process(CheckRoomAvailabilityBFFInput input) {
        return null;
    }
}
