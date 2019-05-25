package xyz.thishome.onling_ksxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.thishome.onling_ksxt.mapper.TestHistoryMapper;
import xyz.thishome.onling_ksxt.pojo.TestHistory;
import xyz.thishome.onling_ksxt.service.HistoryService;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private TestHistoryMapper testHistoryMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveHistory(TestHistory testHistory) {
        testHistoryMapper.insertSelective(testHistory);
    }
}
