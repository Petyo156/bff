package com.tinqinacademy.bff.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqinacademy.authentication.api.apimapping.RestApiMappingAuthentication;
import com.tinqinacademy.authentication.api.operations.changepassword.ChangePasswordInput;
import com.tinqinacademy.authentication.api.operations.confirmregistration.ConfirmRegistrationInput;
import com.tinqinacademy.authentication.api.operations.demote.DemoteUserInput;
import com.tinqinacademy.authentication.api.operations.login.LoginUserInput;
import com.tinqinacademy.authentication.api.operations.promote.PromoteUserInput;
import com.tinqinacademy.authentication.api.operations.recoverpassword.RecoverPasswordInput;
import com.tinqinacademy.authentication.api.operations.registeruser.RegisterUserInput;
import com.tinqinacademy.bff.domain.UserFeignClient;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignUsersController {
    private final UserFeignClient userFeignClient;
    private final ObjectMapper objectMapper;

    @Autowired
    public FeignUsersController(UserFeignClient userFeignClient, ObjectMapper objectMapper) {
        this.userFeignClient = userFeignClient;
        this.objectMapper = objectMapper;
    }

    @PostMapping(RestApiMappingAuthentication.POST_CHANGEPASSWORD_PATH)
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordInput input) {

        return userFeignClient.changePassword(input);
    }

    @PostMapping(RestApiMappingAuthentication.POST_CONFIRMREGISTRATION_PATH)
    public ResponseEntity<?> confirmRegistration(
            @RequestBody ConfirmRegistrationInput input) {

        return userFeignClient.confirmRegistration(input);
    }

    @PostMapping(RestApiMappingAuthentication.POST_DEMOTE_PATH)
    public ResponseEntity<?> demoteUser(
            @RequestBody DemoteUserInput input) {

        return userFeignClient.demoteUser(input);
    }

    @PostMapping(RestApiMappingAuthentication.POST_LOGIN_PATH)
    public ResponseEntity<?> loginUser(
            @RequestBody LoginUserInput input) {

        return userFeignClient.loginUser(input);
    }

    @PostMapping(RestApiMappingAuthentication.POST_PROMOTE_PATH)
    public ResponseEntity<?> promoteUser(
            @RequestBody PromoteUserInput input) {

        return userFeignClient.promoteUser(input);
    }

    @PostMapping(RestApiMappingAuthentication.POST_RECOVERPASSWORD_PATH)
    public ResponseEntity<?> recoverPassword(
            @RequestBody RecoverPasswordInput input) {

        return userFeignClient.recoverPassword(input);
    }

    @PostMapping(RestApiMappingAuthentication.POST_REGISTER_PATH)
    public ResponseEntity<?> registerUser(
            @RequestBody RegisterUserInput input) {

        return userFeignClient.registerUser(input);
    }
}
