package com.lab530.md2.controller;



import com.lab530.api.client.MdClient;
import com.lab530.api.dto.Md;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Markdown API")
@RequestMapping("/md2")
@RestController
@RequiredArgsConstructor
@Slf4j
public class MdController {
    private final MdClient mdclient;
    @GetMapping("/{id}")
    public Md get(@PathVariable("id") Long id){
        log.info("get markdown by id: " + id);
        return mdclient.getById(id);
    }

}
