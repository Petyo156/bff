package com.tinqinacademy.bff.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqinacademy.comments.restexport.CommentClient;
import com.tinqinacademy.hotel.restexport.HotelClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class CommentsRestExportConfiguration {
    private final ObjectMapper objectMapper;

    private final String commentsUrl = "http://localhost:8081";

    @Autowired
    public CommentsRestExportConfiguration(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Bean(name = "CommentClient")
    public CommentClient authenticationRestClient() {
        return Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .target(CommentClient.class, commentsUrl);
    }
}
