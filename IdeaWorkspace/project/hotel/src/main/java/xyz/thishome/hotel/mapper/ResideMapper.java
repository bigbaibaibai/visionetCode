package xyz.thishome.hotel.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.thishome.hotel.pojo.Reside;
import xyz.thishome.hotel.pojo.ResideExample;

import java.util.List;

public interface ResideMapper {
    int countByExample(ResideExample example);

    int deleteByExample(ResideExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Reside record);

    int insertSelective(Reside record);

    List<Reside> selectByExample(ResideExample example);

    Reside selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Reside record, @Param("example") ResideExample example);

    int updateByExample(@Param("record") Reside record, @Param("example") ResideExample example);

    int updateByPrimaryKeySelective(Reside record);

    int updateByPrimaryKey(Reside record);
}