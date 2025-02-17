package com.example.clientsservice.user.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("user-service")
public interface UserClient {

}
