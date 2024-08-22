package com.tinqinacademy.bff.domain;

import com.tinqinacademy.authentication.restexport.UserClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "userClient", url = "http://localhost:8082")
public interface UserFeignClient extends UserClient {
}
