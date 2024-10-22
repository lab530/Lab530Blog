package com.lab530.md.controller;

import com.lab530.common.domain.R;
import com.lab530.md.domain.Md;
import com.lab530.md.service.MdService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Markdown API")
@RequestMapping("/md")
@RestController
@RequiredArgsConstructor
public class MdController {
    private final MdService mdService;
    @GetMapping("/get/{id}")
    public Md md(@PathVariable Long id){
        Md byId = mdService.getById(id);
        return byId;
    }
    @GetMapping("/list")
    public String hello(){
        return "hello";
    }
}
