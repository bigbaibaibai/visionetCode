package xyz.thishome.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.thishome.mapper.BgmMapper;
import xyz.thishome.pojo.Bgm;
import xyz.thishome.service.BgmService;

import java.util.List;

@Service
public class BgmServiceImpl implements BgmService {

    @Autowired
    private BgmMapper bgmMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Bgm> queryBgmList() {

        List<Bgm> bgms = bgmMapper.selectByExample(null);

        return bgms;
    }
}
