package xyz.thishome.service;

import xyz.thishome.bean.T_MALL_PRODUCT;

import java.util.List;

public interface SpuService {

    /**
     * spu信息添加
     *
     * @param list_image 图片url集合
     * @param spu
     */
    void save_spu(List<String> list_image, T_MALL_PRODUCT spu);

}
