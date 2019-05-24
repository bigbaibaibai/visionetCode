package com.visionet.client1.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@FeignClient(name = "starrChina", url = "")
public interface StarrChinaFeignService {

    @PostMapping("/thirdPartyInterface/operation")
    Map getUrl(String json);

}
