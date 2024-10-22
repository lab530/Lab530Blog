package com.lab530.api.client;

import com.lab530.api.dto.Md;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "md-service")
public interface MdClient {
    @GetMapping("/md/get/{id}")
    Md getById(@RequestParam("id") Long id);
}
