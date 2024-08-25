package com.tinqinacademy.bff.domain;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqinacademy.hotel.restexport.HotelClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class HotelRestExportConfiguration {
    private final ObjectMapper objectMapper;

    private final String hotelUrl = "http://localhost:8080";

    @Autowired
    public HotelRestExportConfiguration(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Bean(name = "HotelClient")
    public HotelClient authenticationRestClient() {
        return Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .target(HotelClient.class, hotelUrl);
    }
}
