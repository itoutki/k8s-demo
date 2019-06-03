package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    private String podName;
    private String version;

    public DemoController(@Value("${my.label.version:None}")String version,
                          @Value("${my.pod.name:None}") String podName) {
        this.version = version;
        this.podName = podName;
    }

    @GetMapping("/version")
    @ResponseBody
    public String getVersion() {
        return "{\"version\": \"" + version + "\"}";
    }

    @GetMapping("/pod")
    @ResponseBody
    public String getPodName() {
        return "{\"podname\": \"" + podName + "\"}";
    }

    @GetMapping("/")
    public String getDemoPage() {
        return "demo";
    }
}
