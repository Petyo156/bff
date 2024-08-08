package com.tinqinacademy.bff.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqinacademy.bff.domain.HotelFeignClient;
import com.tinqinacademy.hotel.api.models.apimapping.RestApiMappingHotel;
import com.tinqinacademy.hotel.api.models.operations.hotel.bookroom.BookSpecifiedRoomInput;
import com.tinqinacademy.hotel.api.models.operations.system.admincreateroom.AdminCreateRoomInput;
import com.tinqinacademy.hotel.api.models.operations.system.adminpartialupdate.AdminPartialUpdateInput;
import com.tinqinacademy.hotel.api.models.operations.system.adminupdateinfoforroom.AdminUpdateInfoForRoomInput;
import com.tinqinacademy.hotel.api.models.operations.system.registervisitor.RegisterVisitorInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class FeignHotelController {

    private final HotelFeignClient hotelFeignClient;
    private final ObjectMapper objectMapper;

    @Autowired
    public FeignHotelController(HotelFeignClient hotelFeignClient, ObjectMapper objectMapper) {
        this.hotelFeignClient = hotelFeignClient;
        this.objectMapper = objectMapper;
    }

    @GetMapping(RestApiMappingHotel.GET_checkAvailability_PATH)
    public ResponseEntity<?> checkAvailability(
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate,
            @RequestParam("bedSize") String bedSize,
            @RequestParam("bathroomType") String bathroomType) {

        return hotelFeignClient.checkAvailability(startDate, endDate, bedSize, bathroomType);
    }

    @GetMapping(RestApiMappingHotel.GET_basicInfoForRoom_PATH)
    public ResponseEntity<?> basicInfoForRoom(
            @PathVariable("roomId") String roomId) {

        return hotelFeignClient.basicInfoForRoom(roomId);
    }

    @PostMapping(RestApiMappingHotel.POST_bookSpecifiedRoom_PATH)
    public ResponseEntity<?> bookSpecifiedRoom(
            @RequestBody BookSpecifiedRoomInput bookSpecifiedRoomInput,
            @PathVariable("roomId") String roomId) {

        return hotelFeignClient.bookSpecifiedRoom(bookSpecifiedRoomInput, roomId);
    }

    @DeleteMapping(RestApiMappingHotel.DELETE_unbookBookedRoom_PATH)
    public ResponseEntity<?> unbookBookedRoom(
            @PathVariable String bookingId) {

        return hotelFeignClient.unbookBookedRoom(bookingId);
    }

    @PostMapping(RestApiMappingHotel.POST_registerVisitor_PATH)
    public ResponseEntity<?> registerVisitor(
            @RequestBody RegisterVisitorInput input) {

        return hotelFeignClient.registerVisitor(input);
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

        return hotelFeignClient.adminReportVisitor(visitorsData, startDate, endDate, firstName,
                lastName, phoneNo, cardNoID, cardValidityID, cardIssueAuthorityID, cardIssueDateID);
    }

    @PostMapping(RestApiMappingHotel.POST_adminCreateRoom_PATH)
    public ResponseEntity<?> adminCreateRoom(
            @RequestBody AdminCreateRoomInput input) {

        return hotelFeignClient.adminCreateRoom(input);
    }

    @PutMapping(RestApiMappingHotel.PUT_adminUpdateInfoForRoom_PATH)
    public ResponseEntity<?> adminUpdateInfoForRoom(
            @RequestBody AdminUpdateInfoForRoomInput adminUpdateInfoForRoomInput,
            @PathVariable("id") String id) {

        return hotelFeignClient.adminUpdateInfoForRoom(adminUpdateInfoForRoomInput, id);
    }

    @PatchMapping(value = RestApiMappingHotel.PATCH_adminPartialUpdate_PATH, consumes = "application/json-patch+json")
    public ResponseEntity<?> adminPartialUpdate(
            @RequestBody AdminPartialUpdateInput adminPartialUpdateInput,
            @PathVariable("id") String id) {

        return hotelFeignClient.adminPartialUpdate(adminPartialUpdateInput, id);
    }

    @DeleteMapping(RestApiMappingHotel.DELETE_deleteRoom_PATH)
    public ResponseEntity<?> deleteRoom(
            @PathVariable("id") String id) {

        return hotelFeignClient.deleteRoom(id);
    }

}
