package com.tinqinacademy.bff.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqinacademy.authentication.restexport.AuthenticationRestClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class UserRestExportConfiguration {
    private final ObjectMapper objectMapper;

    private final String userUrl = "http://localhost:8082";

    @Autowired
    public UserRestExportConfiguration(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Bean(name = "UserClient")
    public AuthenticationRestClient authenticationRestClient() {
        return Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .target(AuthenticationRestClient.class, userUrl);
    }
}
