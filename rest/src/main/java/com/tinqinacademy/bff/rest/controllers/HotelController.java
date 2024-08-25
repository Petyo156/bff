package com.tinqinacademy.bff.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqinacademy.bff.api.operations.hotel.hotel.basicinfo.BasicInfoForRoomBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.hotel.bookroom.BookSpecifiedRoomBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.hotel.checkroom.CheckRoomAvailabilityBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.hotel.unbookbookedroom.UnbookBookedRoomBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.system.admincreateroom.AdminCreateRoomBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.system.adminpartialupdate.AdminPartialUpdateBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.system.adminreportvisitor.AdminReportVisitorBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.system.adminupdateinfoforroom.AdminUpdateInfoForRoomBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.system.deleteroom.DeleteRoomBFFInput;
import com.tinqinacademy.bff.api.operations.hotel.system.registervisitor.RegisterVisitorBFFInput;
import com.tinqinacademy.bff.core.processors.hotel.hotel.BasicInfoForRoomOperationProcessor;
import com.tinqinacademy.bff.core.processors.hotel.hotel.BookSpecifiedRoomOperationProcessor;
import com.tinqinacademy.bff.core.processors.hotel.hotel.CheckRoomAvailabilityOperationProcessor;
import com.tinqinacademy.bff.core.processors.hotel.hotel.UnbookBookedRoomOperationProcessor;
import com.tinqinacademy.bff.core.processors.hotel.system.*;
import com.tinqinacademy.hotel.api.models.apimapping.RestApiMappingHotel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
public class HotelController extends BaseController{

    private final ObjectMapper objectMapper;

    private final CheckRoomAvailabilityOperationProcessor checkRoomAvailabilityOperationProcessor;
    private final BookSpecifiedRoomOperationProcessor bookSpecifiedRoomOperationProcessor;
    private final UnbookBookedRoomOperationProcessor unbookBookedRoomOperationProcessor;
    private final BasicInfoForRoomOperationProcessor basicInfoForRoomOperationProcessor;

    private final RegisterVisitorOperationProcessor registerVisitorOperationProcessor;
    private final AdminReportVisitorOperationProcessor adminReportVisitorOperationProcessor;
    private final AdminCreateRoomOperationProcessor adminCreateRoomOperationProcessor;
    private final AdminUpdateInfoForRoomOperationProcessor adminUpdateInfoForRoomOperationProcessor;
    private final AdminPartialUpdateOperationProcessor adminPartialUpdateOperationProcessor;
    private final DeleteRoomOperationProcessor deleteRoomOperationProcessor;

    @Autowired
    public HotelController(ObjectMapper objectMapper, CheckRoomAvailabilityOperationProcessor checkRoomAvailabilityOperationProcessor, BookSpecifiedRoomOperationProcessor bookSpecifiedRoomOperationProcessor,
                           UnbookBookedRoomOperationProcessor unbookBookedRoomOperationProcessor, BasicInfoForRoomOperationProcessor basicInfoForRoomOperationProcessor, RegisterVisitorOperationProcessor registerVisitorOperationProcessor,
                           AdminReportVisitorOperationProcessor adminReportVisitorOperationProcessor, AdminCreateRoomOperationProcessor adminCreateRoomOperationProcessor, AdminUpdateInfoForRoomOperationProcessor adminUpdateInfoForRoomOperationProcessor, AdminPartialUpdateOperationProcessor adminPartialUpdateOperationProcessor, DeleteRoomOperationProcessor deleteRoomOperationProcessor) {
        this.objectMapper = objectMapper;
        this.checkRoomAvailabilityOperationProcessor = checkRoomAvailabilityOperationProcessor;
        this.bookSpecifiedRoomOperationProcessor = bookSpecifiedRoomOperationProcessor;
        this.unbookBookedRoomOperationProcessor = unbookBookedRoomOperationProcessor;
        this.basicInfoForRoomOperationProcessor = basicInfoForRoomOperationProcessor;
        this.registerVisitorOperationProcessor = registerVisitorOperationProcessor;
        this.adminReportVisitorOperationProcessor = adminReportVisitorOperationProcessor;
        this.adminCreateRoomOperationProcessor = adminCreateRoomOperationProcessor;
        this.adminUpdateInfoForRoomOperationProcessor = adminUpdateInfoForRoomOperationProcessor;
        this.adminPartialUpdateOperationProcessor = adminPartialUpdateOperationProcessor;
        this.deleteRoomOperationProcessor = deleteRoomOperationProcessor;
    }

    @GetMapping(RestApiMappingHotel.GET_checkAvailability_PATH)
    public ResponseEntity<?> checkAvailability(
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate,
            @RequestParam("bedSize") String bedSize,
            @RequestParam("bathroomType") String bathroomType) {

        CheckRoomAvailabilityBFFInput input = CheckRoomAvailabilityBFFInput.builder()
                .endDate(endDate)
                .startDate(startDate)
                .bathroomType(bathroomType)
                .bedSize(bedSize)
                .build();

        return handleOperation(checkRoomAvailabilityOperationProcessor.process(input), HttpStatus.BAD_REQUEST);
    }

    @GetMapping(RestApiMappingHotel.GET_basicInfoForRoom_PATH)
    public ResponseEntity<?> basicInfoForRoom(
            @PathVariable("roomId") String roomId) {

        BasicInfoForRoomBFFInput input = BasicInfoForRoomBFFInput.builder()
                .roomId(String.valueOf(roomId))
                .build();

        return handleOperation(basicInfoForRoomOperationProcessor.process(input), HttpStatus.BAD_REQUEST);
    }

    @PostMapping(RestApiMappingHotel.POST_bookSpecifiedRoom_PATH)
    public ResponseEntity<?> bookSpecifiedRoom(
            @Valid @RequestBody BookSpecifiedRoomBFFInput bookSpecifiedRoomInput,
            @PathVariable("roomId") String roomId) {

        BookSpecifiedRoomBFFInput input = bookSpecifiedRoomInput.toBuilder()
                .roomId(roomId)
                .build();

        return handleOperation(bookSpecifiedRoomOperationProcessor.process(input), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(RestApiMappingHotel.DELETE_unbookBookedRoom_PATH)
    public ResponseEntity<?> unbookBookedRoom(
            @PathVariable String bookingId) {

        UnbookBookedRoomBFFInput input = UnbookBookedRoomBFFInput.builder()
                .bookingId(bookingId)
                .build();

        return handleOperation(unbookBookedRoomOperationProcessor.process(input), HttpStatus.BAD_REQUEST);
    }


    @PostMapping(RestApiMappingHotel.POST_registerVisitor_PATH)
    public ResponseEntity<?> registerVisitor(
            @Valid @RequestBody RegisterVisitorBFFInput input) {

        return handleOperation(registerVisitorOperationProcessor.process(input), HttpStatus.BAD_REQUEST);
    }

    @GetMapping(RestApiMappingHotel.GET_adminReportVisitor_PATH)
    public ResponseEntity<?> adminReportVisitor(
            @RequestParam("visitorsData") List<String> visitorsData,
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("phoneNo") String phoneNo,
            @RequestParam("cardNoID") String cardNoID,
            @RequestParam("cardValidityID") String cardValidityID,
            @RequestParam("cardIssueAuthorityID") String cardIssueAuthorityID,
            @RequestParam("cardIssueDateID") LocalDate cardIssueDateID) {
        //hardcoded
        AdminReportVisitorBFFInput input = AdminReportVisitorBFFInput.builder()
                .cardIssueAuthorityID(cardIssueAuthorityID)
                .endDate(endDate)
                .cardNoID(cardNoID)
                .cardIssueDateID(cardIssueDateID)
                .startDate(startDate)
                .firstName(firstName)
                .lastName(lastName)
                .phoneNo(phoneNo)
                .cardValidityID(cardValidityID)
                .build();

        return handleOperation(adminReportVisitorOperationProcessor.process(input), HttpStatus.BAD_REQUEST);
    }

    @PostMapping(RestApiMappingHotel.POST_adminCreateRoom_PATH)
    public ResponseEntity<?> adminCreateRoom(
            @Valid @RequestBody AdminCreateRoomBFFInput input) {
        return handleOperation(adminCreateRoomOperationProcessor.process(input), HttpStatus.BAD_REQUEST);
    }

    @PutMapping(RestApiMappingHotel.PUT_adminUpdateInfoForRoom_PATH)
    public ResponseEntity<?> adminUpdateInfoForRoom(
            @Valid @RequestBody AdminUpdateInfoForRoomBFFInput adminUpdateInfoForRoomInput,
            @PathVariable("id") String id) {

        AdminUpdateInfoForRoomBFFInput input = adminUpdateInfoForRoomInput.toBuilder()
                .id(id)
                .build();

        return handleOperation(adminUpdateInfoForRoomOperationProcessor.process(input), HttpStatus.BAD_REQUEST);
    }

    @PatchMapping(value = RestApiMappingHotel.PATCH_adminPartialUpdate_PATH, consumes = "application/json-patch+json")
    public ResponseEntity<?> adminPartialUpdate(
            @Valid @RequestBody AdminPartialUpdateBFFInput adminPartialUpdateInput,
            @PathVariable("id") String id) {

        AdminPartialUpdateBFFInput input = adminPartialUpdateInput.toBuilder()
                .roomId(UUID.fromString(id))
                .build();

        return handleOperation(adminPartialUpdateOperationProcessor.process(input), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(RestApiMappingHotel.DELETE_deleteRoom_PATH)
    public ResponseEntity<?> deleteRoom(
            @PathVariable("id") String id) {
        DeleteRoomBFFInput input = DeleteRoomBFFInput.builder()
                .id(id)
                .build();

        return handleOperation(deleteRoomOperationProcessor.process(input), HttpStatus.BAD_REQUEST);
    }
}
