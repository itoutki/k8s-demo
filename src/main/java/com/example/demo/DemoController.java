package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @GetMapping("/version")
    @ResponseBody
    public String getVersion() {
        return "{\"version\": \"v000\"}";
    }

    @GetMapping("/")
    public String getDemoPage() {
        return "demo";
    }
}
