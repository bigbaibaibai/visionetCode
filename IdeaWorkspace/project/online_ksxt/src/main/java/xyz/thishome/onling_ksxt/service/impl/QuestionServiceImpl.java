package xyz.thishome.onling_ksxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.thishome.onling_ksxt.mapper.ChoiseMapper;
import xyz.thishome.onling_ksxt.mapper.FillOrQuestionMapper;
import xyz.thishome.onling_ksxt.pojo.Choise;
import xyz.thishome.onling_ksxt.pojo.FillOrQuestion;
import xyz.thishome.onling_ksxt.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private FillOrQuestionMapper fillOrQuestionMapper;
    @Autowired
    private ChoiseMapper choiseMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public FillOrQuestion getFillForId(Integer id) {
        return fillOrQuestionMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Choise getChoiseForId(Integer id) {
        return choiseMapper.selectByPrimaryKey(id);
    }
}
