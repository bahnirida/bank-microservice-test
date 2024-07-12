package org.example.customer.web;

import lombok.AllArgsConstructor;
import org.example.customer.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
@RefreshScope
public class ConfigTestController {
    private GlobalConfig globalConfig;

//    @GetMapping("/testConfig")
//    public Map<String, Integer> getParams() {
//        return Map.of("p1", p1, "p2", p2, "x", x, "y", y);
//    }
    @GetMapping("/testConfig")
    public GlobalConfig getParams() {
        return globalConfig;
    }
}
