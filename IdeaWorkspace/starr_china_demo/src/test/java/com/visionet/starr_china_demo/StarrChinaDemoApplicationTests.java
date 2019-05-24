package com.visionet.starr_china_demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.ribbon.apache.HttpClientUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StarrChinaDemoApplicationTests {

    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetUrl() {
        ResponseEntity<String> entity = restTemplate.getForEntity("http://www.baidu.com", String.class);
        String body = entity.getBody();
        System.out.println(entity.getStatusCode());
        System.out.println(entity.getHeaders());
        System.out.println(body);
    }

}
