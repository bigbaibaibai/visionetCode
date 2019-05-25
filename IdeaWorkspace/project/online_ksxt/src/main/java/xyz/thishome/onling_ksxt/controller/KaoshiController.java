package xyz.thishome.onling_ksxt.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.thishome.onling_ksxt.pojo.*;
import xyz.thishome.onling_ksxt.service.HistoryService;
import xyz.thishome.onling_ksxt.service.KaoshiService;
import xyz.thishome.onling_ksxt.service.QuestionService;
import xyz.thishome.onling_ksxt.util.JsonUtils;
import xyz.thishome.onling_ksxt.util.KsxtMsg;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kaoshi")
public class KaoshiController {

    @Autowired
    private KaoshiService kaoshiService;

    @Autowired
    private QuestionService questionService;


    @GetMapping("/getFillOne")
    public KsxtMsg getFillOne(@RequestParam("type") String type, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        if (type.equals("0")) {
            return KsxtMsg.success(kaoshiService.getFill());
        } else {
            return KsxtMsg.success(kaoshiService.getPanduan());
        }
    }

    @GetMapping("/getChoiseOne")
    public KsxtMsg getChoiseOne(@RequestParam("type") String type, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        if (type.equals("0")) {
            return KsxtMsg.success(kaoshiService.getChoise());
        } else {
            return KsxtMsg.success(kaoshiService.getSomeChoise());
        }

    }

    @GetMapping("/addIdToRedis")
    public KsxtMsg updateIds(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        kaoshiService.addQuestionIdToRedis();
        return KsxtMsg.success();
    }

    //储存一道填空判断，获取一道填空判断
    @PostMapping("/getNextFill")
    public KsxtMsg getNextFill(@RequestParam("stuId") Integer stuId, @RequestParam("fillId") Integer fillId, @RequestParam("answer") String answer, @RequestParam("type") String type, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //id不为空
        if (stuId == null || fillId == null || StringUtils.isBlank(answer)) {
            return KsxtMsg.bulid("学号、题目id和答案不能为空！");
        }
        FillOrQuestion fillForId = questionService.getFillForId(fillId);
        //判断正误
        boolean isTrue = fillForId.getAnswer().equals(answer);

        //封装对象
        FillVo fillVo = new FillVo();
        BeanUtils.copyProperties(fillForId, fillVo);
        fillVo.setTrue(isTrue);
        fillVo.setStuAnswer(answer);
        //存储到redis中
        kaoshiService.saveFill(stuId, fillVo);

        //获取下一题
        FillOrQuestion fill = null;
        if (type.equals("0")) {
            fill = kaoshiService.getFill();
        } else {
            fill = kaoshiService.getPanduan();
        }


        //返回正确或者错误，和下一题
        Map<String, Object> map = new HashMap<>();
        map.put("isTrue", isTrue);
        map.put("item", fill);
        return KsxtMsg.success(map);
    }

    //储存一道选择，获取一道选择
    @PostMapping("/getNextChoise")
    public KsxtMsg getNextChoise(@RequestParam("stuId") Integer stuId, @RequestParam("choiseId") Integer choiseId, @RequestParam("answer") String answer, @RequestParam("type") String type, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //id不为空
        if (stuId == null || choiseId == null || StringUtils.isBlank(answer)) {
            return KsxtMsg.bulid("学号、题目id和答案不能为空！");
        }
        Choise choiseForId = questionService.getChoiseForId(choiseId);
        //判断正误
        boolean isTrue = choiseForId.getAnswer().equals(answer);

        //封装对象
        ChoiseVo choiseVo = new ChoiseVo();
        BeanUtils.copyProperties(choiseForId, choiseVo);
        choiseVo.setTrue(isTrue);
        choiseVo.setStuAnswer(answer);
        //存储到redis中
        kaoshiService.savcChoise(stuId, choiseVo);

        //获取下一题
        Choise choise = null;
        if (type.equals("0")) {
            choise = kaoshiService.getChoise();
        } else {
            choise = kaoshiService.getSomeChoise();
        }
        //返回正确或者错误，和下一题
        Map<String, Object> map = new HashMap<>();
        map.put("isTrue", isTrue);
        map.put("item", choise);
        return KsxtMsg.success(map);
    }


    //提交试卷
    @PostMapping("/commit")
    public KsxtMsg commmit(@RequestParam("stuId") Integer stuId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //获取试卷
        Paper paper = kaoshiService.getPaper(stuId);
        //清除试卷缓存
        kaoshiService.clearPaper(stuId);
        //计算成绩
        int gread = 0;
        List<ChoiseVo> choises = paper.getChoises();
        for (ChoiseVo choise : choises) {
            if (choise.isTrue()) {
                gread += 4;
            }
        }
        List<FillVo> fills = paper.getFills();
        for (FillVo fill : fills) {
            if (fill.isTrue()) {
                gread += 4;
            }
        }

        //封装对象
        TestHistory testHistory = new TestHistory();
        testHistory.setSubject(paper.getSubject());
        testHistory.setGrade(gread);
        testHistory.setUserId(stuId);
        testHistory.setTextPaper(JsonUtils.objectToJson(paper));
        //保存到数据库
        historyService.saveHistory(testHistory);
        return KsxtMsg.success(gread);
    }

    @Autowired
    private HistoryService historyService;


}
