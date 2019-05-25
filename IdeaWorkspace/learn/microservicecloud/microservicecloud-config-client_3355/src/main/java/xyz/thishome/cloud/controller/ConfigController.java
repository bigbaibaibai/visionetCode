package xyz.thishome.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConfigController {

    @Value("${server.port}")
    private String port;

    @Value("${spring.profiles}")
    private String profiles;

    @Value("${spring.application.name}")
    private String name;

    @GetMapping("/config")
    public Map getConfig() {
        Map map = new HashMap();
        map.put("port", port);
        map.put("profiles", profiles);
        map.put("name", name);
        return map;
    }

}
