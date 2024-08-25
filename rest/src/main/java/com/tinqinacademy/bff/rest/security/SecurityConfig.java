package com.tinqinacademy.bff.rest.security;

import com.tinqinacademy.comments.api.apimapping.RestApiMappingComments;
import com.tinqinacademy.hotel.api.models.apimapping.RestApiMappingHotel;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(configurer ->
                        configurer
                                //Permitted
                                //Swagger
                                .requestMatchers("/v2/api-docs",
                                        "/swagger-resources",
                                        "/swagger-resources/**",
                                        "/configuration/ui",
                                        "/configuration/security",
                                        "/swagger-ui.html",
                                        "/webjars/**",
                                        "/v3/api-docs/**",
                                        "/swagger-ui/**").permitAll()
                                //Get
                                .requestMatchers(
                                        HttpMethod.GET,
                                        RestApiMappingHotel.GET_checkAvailability_PATH,
                                        RestApiMappingHotel.GET_basicInfoForRoom_PATH,
                                        RestApiMappingComments.GET_PATH).permitAll()
                                //Admin
                                //Post
                                .requestMatchers(
                                        HttpMethod.POST,
                                        RestApiMappingHotel.POST_registerVisitor_PATH,
                                        RestApiMappingHotel.POST_adminCreateRoom_PATH
                                ).hasRole("admin")
                                //Get
                                .requestMatchers(
                                        HttpMethod.GET,
                                        RestApiMappingHotel.GET_adminReportVisitor_PATH
                                ).hasRole("admin")
                                //Put
                                .requestMatchers(
                                        HttpMethod.PUT,
                                        RestApiMappingHotel.PUT_adminUpdateInfoForRoom_PATH
                                ).hasRole("admin")
                                //Patch
                                .requestMatchers(
                                        HttpMethod.PATCH,
                                        RestApiMappingHotel.PATCH_adminPartialUpdate_PATH,
                                        RestApiMappingComments.PUT_PATH
                                ).hasRole("admin")
                                //Delete
                                .requestMatchers(
                                        HttpMethod.DELETE,
                                        RestApiMappingHotel.DELETE_deleteRoom_PATH,
                                        RestApiMappingComments.DELETE_PATH).hasRole("admin")
                                .anyRequest().authenticated()
                )
                .sessionManagement(sessionConfig ->
                        sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}