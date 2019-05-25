package xyz.thishome.phone_mall_rest_web.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.thishome.phone_mall_rest_web.pojo.TbItemImage;
import xyz.thishome.phone_mall_rest_web.pojo.TbItemImageExample;

public interface TbItemImageMapper {
    int countByExample(TbItemImageExample example);

    int deleteByExample(TbItemImageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbItemImage record);

    int insertSelective(TbItemImage record);

    List<TbItemImage> selectByExample(TbItemImageExample example);

    TbItemImage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbItemImage record, @Param("example") TbItemImageExample example);

    int updateByExample(@Param("record") TbItemImage record, @Param("example") TbItemImageExample example);

    int updateByPrimaryKeySelective(TbItemImage record);

    int updateByPrimaryKey(TbItemImage record);
}