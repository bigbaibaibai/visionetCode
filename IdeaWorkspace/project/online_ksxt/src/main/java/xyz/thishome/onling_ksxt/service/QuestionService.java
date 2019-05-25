package xyz.thishome.onling_ksxt.service;

import xyz.thishome.onling_ksxt.pojo.Choise;
import xyz.thishome.onling_ksxt.pojo.FillOrQuestion;

/**
 * 题相关的服务
 */
public interface QuestionService {

    //指定ID获取一道填空题
    FillOrQuestion getFillForId(Integer id);

    //指定Id获取一道选择题
    Choise getChoiseForId(Integer id);

}
