package xyz.thishome.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.thishome.bean.T_MALL_PRODUCT;
import xyz.thishome.mapper.SpuMapper;
import xyz.thishome.service.SpuService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuMapper spuMapper;


    @Override
    public void save_spu(List<String> list_image, T_MALL_PRODUCT spu) {
        spu.setShp_tp(list_image.get(0));
        //插入spu信息
        spuMapper.insert_spu(spu);
        //把mapper参数封装成map
        Map<String,Object> map = new HashMap<>();
        map.put("spu_id",spu.getId());
        map.put("list_image",list_image);
        //插入图片信息
        spuMapper.insert_images(map);

    }
}
