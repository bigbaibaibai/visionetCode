package xyz.thishome.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @PostMapping("/")
    public String receive(ZfbRequestBean zfbRequestBean) {
        System.out.println(JsonUtil.object2Json(zfbRequestBean));
        return "hello";
    }

}
