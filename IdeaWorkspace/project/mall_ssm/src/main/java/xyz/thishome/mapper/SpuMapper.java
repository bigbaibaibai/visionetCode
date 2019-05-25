package xyz.thishome.mapper;

import xyz.thishome.bean.T_MALL_PRODUCT;

import java.util.Map;

public interface SpuMapper {

    /**
     * 插入spu信息
     *
     * @param spu
     */
    void insert_spu(T_MALL_PRODUCT spu);

    /**
     * 插入商品图片
     *
     * @param map
     */
    void insert_images(Map<String, Object> map);
}
