package com.visionet.service1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestServiceController {

    @PostMapping("/getSuccess")
    public Person send(@RequestBody Person person) {
        person.setAge("19");
        return person;
    }

}
