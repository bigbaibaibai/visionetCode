package xyz.thishome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xyz.thishome.bean.T_MALL_PRODUCT;
import xyz.thishome.service.SpuService;
import xyz.thishome.util.MyFileUpload;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/spu")
public class SpuController {

    @Autowired
    private SpuService spuService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public T_MALL_PRODUCT addSpu(@RequestParam(value = "files") MultipartFile[] multipartFiles, T_MALL_PRODUCT t_mall_product, HttpServletResponse response) throws IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");

        //上传图片
        List<String> upload_images = MyFileUpload.upload_images(multipartFiles);

        System.out.println(upload_images);
        //保存spu信息
        spuService.save_spu(upload_images, t_mall_product);

        return t_mall_product;
    }

    @RequestMapping("/hello")
    public String hello(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return "success";
    }

}
