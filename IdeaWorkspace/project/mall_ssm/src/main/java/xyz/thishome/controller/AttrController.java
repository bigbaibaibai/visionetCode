package xyz.thishome.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.thishome.bean.MODEL_T_MALL;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/attr")
public class AttrController {

    @RequestMapping("/add")
    public void addAttr(@RequestParam("flbh2") Integer flbh2, MODEL_T_MALL model_t_mall, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

    }

}
