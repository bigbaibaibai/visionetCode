package xyz.thishome.phone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.thishome.common.pojo.PhoneMsg;
import xyz.thishome.phone.pojo.TbContent;
import xyz.thishome.phone.service.ContentService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {

    private Logger logger = LoggerFactory.getLogger(ContentController.class);

    @Autowired
    private ContentService contentService;

    //根据内容分类获取页面内容列表
    @GetMapping("/getContentList/{classId}")
    public PhoneMsg getContentList(@PathVariable("classId") Long classId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //先从缓存查
        List<TbContent> contents = null;
        try {
            contents = contentService.getContentFromRedis(classId);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询页面内容信息，redis异常");
        }

        if (contents != null) {
            logger.debug("查询页面内容，redis中查询");
            return PhoneMsg.success(contents);
        }
        contents = contentService.getContent(classId);

        try {
            contentService.saveContentToRedis(classId, contents);
            logger.debug("保存页面内容信息到redis，保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("保存页面内容信息到redis，出现异常");
        }

        return PhoneMsg.success(contents);
    }

    @DeleteMapping("/delContentList/{classId}")
    public PhoneMsg delContentList(@PathVariable("classId") Long classId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        contentService.delContentRedis(classId);
        return PhoneMsg.success();
    }


}
