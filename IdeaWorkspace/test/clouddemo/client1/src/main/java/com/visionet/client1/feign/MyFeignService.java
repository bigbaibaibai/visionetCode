package com.visionet.client1.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "name", url = "localhost:8001")
public interface MyFeignService {

    @PostMapping("/getSuccess")
    Person get(Person person);

}
