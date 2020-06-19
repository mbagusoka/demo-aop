package com.demo.aop.controller;

import com.demo.aop.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/success")
    public void successMethod() {
        demoService.doSuccess("My dream is..");
    }

    @GetMapping("/failed")
    public void failedMethod() {
        demoService.doFailed("It failed");
    }
}
