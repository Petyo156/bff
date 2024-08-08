package com.tinqinacademy.bff.domain;

import com.tinqinacademy.comments.restexport.CommentClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "commentClient", url = "http://localhost:8081")
public interface CommentFeignClient extends CommentClient {
}
