package xyz.thishome.onling_ksxt.service;

import xyz.thishome.onling_ksxt.pojo.*;

public interface KaoshiService {

    /**
     * 添加所有题id到redis中存储
     */
    void addQuestionIdToRedis();

    //随机获取一道填空题
    FillOrQuestion getFill();

    //随机获取一道判断题
    FillOrQuestion getPanduan();

    //随机获取一道多选题
    Choise getSomeChoise();

    //随机获取一道选择题
    Choise getChoise();

    //把填空题存到用户对应redis中
    void saveFill(Integer stuId, FillVo fillVo);

    //把选择题存到用户对象对应的redis中
    void savcChoise(Integer stuId, ChoiseVo choiseVo);

    //获取试卷对象
    Paper getPaper(Integer stuId);

    //清除试卷缓存
    void clearPaper(Integer stuId);

}
