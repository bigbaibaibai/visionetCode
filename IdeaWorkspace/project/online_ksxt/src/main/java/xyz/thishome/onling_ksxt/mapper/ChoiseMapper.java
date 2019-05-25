package xyz.thishome.onling_ksxt.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.thishome.onling_ksxt.pojo.Choise;
import xyz.thishome.onling_ksxt.pojo.ChoiseExample;

import java.util.List;

public interface ChoiseMapper {
    int countByExample(ChoiseExample example);

    int deleteByExample(ChoiseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Choise record);

    int insertSelective(Choise record);

    List<Choise> selectByExample(ChoiseExample example);

    Choise selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Choise record, @Param("example") ChoiseExample example);

    int updateByExample(@Param("record") Choise record, @Param("example") ChoiseExample example);

    int updateByPrimaryKeySelective(Choise record);

    int updateByPrimaryKey(Choise record);

    List<Integer> getIdList(String type);
}