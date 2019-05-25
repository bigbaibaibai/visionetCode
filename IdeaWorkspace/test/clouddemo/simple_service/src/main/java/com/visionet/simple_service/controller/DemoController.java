package com.visionet.simple_service.controller;

import com.visionet.common.utils.EncryptUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/getJson")
    public String getJson(@RequestBody String json) throws Exception {
        String jsonStr = EncryptUtils.i.encrypt(json, "sdn_ddos");
        return jsonStr;
    }

}
