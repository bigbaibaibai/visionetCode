package xyz.thishome.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/hello")
    public Map<String, Object> hello(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from employee");
        System.out.println(maps);
        Map<String, Object> map = new HashMap<>();
        map.put("hello", "hello");
        return map;
    }

}

