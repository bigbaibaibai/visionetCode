package xyz.thishome.hotel.service;

import xyz.thishome.hotel.pojo.Reside;

import java.util.List;

public interface ResideService {

    /**
     * 添加入住信息
     *
     * @param reside
     * @return
     */
    Reside insert(Reside reside);

    /**
     * 获取全部入住信息，按入住时间排序
     *
     * @return
     */
    List<Reside> getAll();

    /**
     * 通过id获取入住信息
     *
     * @param resideId
     * @return
     */
    Reside get(Integer resideId);

}
