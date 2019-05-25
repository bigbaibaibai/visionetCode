package xyz.thishome.onling_ksxt.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.thishome.onling_ksxt.mapper.ChoiseMapper;
import xyz.thishome.onling_ksxt.mapper.FillOrQuestionMapper;
import xyz.thishome.onling_ksxt.pojo.*;
import xyz.thishome.onling_ksxt.service.KaoshiService;
import xyz.thishome.onling_ksxt.util.JsonUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class KaoshiServiceImpl implements KaoshiService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private FillOrQuestionMapper fillOrQuestionMapper;

    @Autowired
    private ChoiseMapper choiseMapper;

    private String CHOISE_ID_LIST_REDIS_KEY = "CHOISE_ID_LIST_REDIS_KEY";
    private String FILL_ID_LIST_REDIS_KEY = "FILL_ID_LIST_REDIS_KEY";
    private String STUDENT_PAPER_REDIS_KEY = "STUDENT_PAPER_REDIS_KEY";
    private String SOME_CHOISE_ID_LIST_REDIS_KEY = "SOME_CHOISE_ID_LIST_REDIS_KEY";
    private String PANDUAN_ID_LIST_REDIS_KEY = "PANDUAN_ID_LIST_REDIS_KEY";

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void addQuestionIdToRedis() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        //把所有填空id存到redis中
        List<Integer> idList = fillOrQuestionMapper.getIdList("0");
        String json = JsonUtils.objectToJson(idList);
        valueOperations.set(FILL_ID_LIST_REDIS_KEY, json);

        //把所有判断id存到redis中
        idList = fillOrQuestionMapper.getIdList("1");
        json = JsonUtils.objectToJson(idList);
        valueOperations.set(PANDUAN_ID_LIST_REDIS_KEY, json);


        //把所有单项选择id存到redis中
        idList = choiseMapper.getIdList("0");
        json = JsonUtils.objectToJson(idList);
        valueOperations.set(CHOISE_ID_LIST_REDIS_KEY, json);

        //把所有多选id存到redis中
        idList = choiseMapper.getIdList("1");
        json = JsonUtils.objectToJson(idList);
        valueOperations.set(SOME_CHOISE_ID_LIST_REDIS_KEY, json);

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public FillOrQuestion getFill() {
        Integer id = getId(FILL_ID_LIST_REDIS_KEY);
        FillOrQuestion fillOrQuestion = fillOrQuestionMapper.selectByPrimaryKey(id);
//        if (fillOrQuestion == null) {
//            return getFill();
//        }
        return fillOrQuestion;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public FillOrQuestion getPanduan() {
        Integer id = getId(PANDUAN_ID_LIST_REDIS_KEY);
        FillOrQuestion fillOrQuestion = fillOrQuestionMapper.selectByPrimaryKey(id);
//        if (fillOrQuestion == null) {
//            return getFill();
//        }
        return fillOrQuestion;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Choise getSomeChoise() {
        Integer id = getId(SOME_CHOISE_ID_LIST_REDIS_KEY);
        Choise choise = choiseMapper.selectByPrimaryKey(id);
//        if (choise == null) {
//            return getFill();
//        }
        return choise;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Choise getChoise() {
        Integer id = getId(CHOISE_ID_LIST_REDIS_KEY);
        Choise choise = choiseMapper.selectByPrimaryKey(id);
//        if (choise == null) {
//            return getFill();
//        }
        return choise;
    }

    private Integer getId(String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String json = valueOperations.get(key);
        List<Integer> ids = JsonUtils.jsonToList(json, Integer.class);
        double random = Math.random();
        int index = (int) (ids.size() * random);
        Integer id = ids.get(index);
        return id;
    }

    @Override
    public void saveFill(Integer stuId, FillVo fillVo) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        Paper paper = getPaper(stuId);
        paper.getFills().add(fillVo);
        valueOperations.set(STUDENT_PAPER_REDIS_KEY + ":" + stuId, JsonUtils.objectToJson(paper));
    }

    @Override
    public void savcChoise(Integer stuId, ChoiseVo choiseVo) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        Paper paper = getPaper(stuId);
        paper.getChoises().add(choiseVo);
        valueOperations.set(STUDENT_PAPER_REDIS_KEY + ":" + stuId, JsonUtils.objectToJson(paper));
    }

    public Paper getPaper(Integer stuId) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String json = valueOperations.get(STUDENT_PAPER_REDIS_KEY + ":" + stuId);
        Paper paper = null;
        if (StringUtils.isBlank(json)) {
            paper = new Paper();
            paper.setStuId(stuId);
        } else {
            paper = JsonUtils.jsonToPojo(json, Paper.class);
        }
        redisTemplate.expire(STUDENT_PAPER_REDIS_KEY + ":" + stuId,30, TimeUnit.MINUTES);
        return paper;
    }

    @Override
    public void clearPaper(Integer stuId) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        redisTemplate.expire(STUDENT_PAPER_REDIS_KEY + ":" + stuId,0, TimeUnit.SECONDS);
        valueOperations.set(STUDENT_PAPER_REDIS_KEY + ":" + stuId, "");
    }
}
