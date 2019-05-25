package xyz.thishome.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.thishome.bean.T_MALL_CLASS_2;

import java.util.List;

public interface T_MALL_CLASS_2_mapper {

    /**
     * 根据分类1编号获取相应的分类2列表
     *
     * @return
     */
    List<T_MALL_CLASS_2> getListForClass1Id(Integer class1_Id);

}
