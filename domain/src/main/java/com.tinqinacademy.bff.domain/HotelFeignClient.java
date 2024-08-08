package com.tinqinacademy.bff.domain;

import com.tinqinacademy.hotel.restexport.HotelClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "hotelClient", url = "http://localhost:8080")
public interface HotelFeignClient extends HotelClient {

}
