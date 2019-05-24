package com.visionet.client1;

import com.google.gson.JsonNull;
import com.visionet.client1.feign.MyFeignService;
import com.visionet.client1.feign.Person;
import com.visionet.client1.feign.StarrChinaFeignService;
import com.visionet.common.utils.EncryptUtils;
import com.visionet.common.utils.GetUrlRequestVo;
import com.visionet.common.utils.GetUrlResultVo;
import com.visionet.common.utils.JsonUtils;
import net.minidev.json.JSONUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Client1ApplicationTests {

    @Autowired
    private MyFeignService myFeignService;

    @Test
    public void contextLoads() {
        Person person = new Person();
        person.setName("hello");
        Person person1 = myFeignService.get(person);
        System.out.println("--------------------------------------");
        System.out.println(person1);
        System.out.println("--------------------------------------");
    }


    @Autowired
    private RestTemplate restTemplate;

    @Value("${url}")
    private String url;


    @Test
    public void testBASE64Util() {
        try {
            GetUrlRequestVo getUrlRequestVo = new GetUrlRequestVo();
            getUrlRequestVo.setOperationType(GetUrlRequestVo.ORDER_TYPE);
            GetUrlRequestVo.Token token = new GetUrlRequestVo.Token();
            token.setBusinessCode("000050");
            token.setUserPassword("ceshi1");
            token.setProductCode(Arrays.asList("000106"));
            token.setThirdOrderNo("000008275");
            token.setOperate("1");
            token.setEmarketCode("DSFCSJG");
            token.setDepositRate("1");
            token.setUserName("ceshi");
            token.setUserCode("0000031615");
            token.setToken("e33c32016f7b8fb71c65b908d89ce208");
            getUrlRequestVo.setToken(token);
            String json = JsonUtils.obj2StringPretty(getUrlRequestVo);

            System.out.println("--------------------------------------");
            System.out.println("加密前：\n" + json);
            String jsonStr = EncryptUtils.i.encrypt(json, "sdn_ddos");
            System.out.println("加密后：\n" + jsonStr);
            System.out.println("--------------------------------------");


            System.out.println(url);
            //发出请求
            ResponseEntity<GetUrlResultVo> mapResponseEntity = restTemplate.postForEntity(url, jsonStr, GetUrlResultVo.class);
            GetUrlResultVo body = mapResponseEntity.getBody();

            String url = body.getData().getObj().get("url");
            System.out.println(url);

//          Map url = starrChinaFeignService.getUrl(jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
