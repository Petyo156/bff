package com.tinqinacademy.bff.rest;

import com.tinqinacademy.comments.restexport.CommentClient;
import com.tinqinacademy.hotel.restexport.HotelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeignController {

    private final CommentClient commentClient;
    private final HotelClient hotelClient;

    @Autowired
    public FeignController(CommentClient commentClient, HotelClient hotelClient) {
        this.commentClient = commentClient;
        this.hotelClient = hotelClient;
    }


    //  Comments

    @GetMapping("/hotel/{roomId}/comment")
    public ResponseEntity<?> getRoomComments(
            @PathVariable("roomId") String roomId){
        return commentClient.getRoomComments(roomId);
    }

    //  Hotel



}
