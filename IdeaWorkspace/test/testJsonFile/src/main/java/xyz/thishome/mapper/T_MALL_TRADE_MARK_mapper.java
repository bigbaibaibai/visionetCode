package xyz.thishome.mapper;

import xyz.thishome.bean.T_MALL_TRADE_MARK;

import java.util.List;

public interface T_MALL_TRADE_MARK_mapper {

    /**
     * 通过分类获取品牌ID
     *
     * @return
     */
    List<T_MALL_TRADE_MARK> getPPListForFlId(Integer FlId);

}
