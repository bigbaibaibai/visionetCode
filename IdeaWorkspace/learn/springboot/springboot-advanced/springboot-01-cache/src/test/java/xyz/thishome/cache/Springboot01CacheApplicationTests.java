package xyz.thishome.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.thishome.cache.bean.Employee;
import xyz.thishome.cache.mapper.EmployeeMapper;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void contextLoads() {
        // Employee empForId = employeeMapper.getEmpForId(1);
        String s = UUID.randomUUID().toString();
        employeeMapper.insertEmp(new Employee(0, s.substring(0, 5), s.substring(6, 14), 0, 0));
        System.out.println(employeeMapper);
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisTemplate jsonRedisTemplate;

    @Test
    public void testRedis(){
        //这里会使用jdk默认的序列化机制（JdkSerializationRedisSerializer）
        redisTemplate.opsForValue().set("k3",new Employee(1,"小红","123@qq.com",0,1));
        Object k3 = redisTemplate.opsForValue().get("k3");
        System.out.println(k3);
    }

    @Test
    public void testJsonRedisTemplate(){
        jsonRedisTemplate.opsForValue().set("k3",new Employee(1,"小红","123@qq.com",0,1));
        Object k3 = jsonRedisTemplate.opsForValue().get("k3");
        System.out.println(k3);
    }

    @Test
    public void testStringRedis(){
        stringRedisTemplate.opsForValue().set("k2","v2");
        String k2 = stringRedisTemplate.opsForValue().get("k2");
        System.out.println(k2);
    }

}

