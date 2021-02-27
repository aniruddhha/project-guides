package com.ani.project.anicloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiGatewayController {
    @GetMapping("/fallback")
    public String fallback() {
        return "data not available";
    }
}
