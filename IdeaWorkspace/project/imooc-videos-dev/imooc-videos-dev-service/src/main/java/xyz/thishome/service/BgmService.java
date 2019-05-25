package xyz.thishome.service;

import xyz.thishome.pojo.Bgm;
import java.util.List;

public interface BgmService {

    /**
     * 查询所有bgm
     * @return
     */
    List<Bgm> queryBgmList();

}
