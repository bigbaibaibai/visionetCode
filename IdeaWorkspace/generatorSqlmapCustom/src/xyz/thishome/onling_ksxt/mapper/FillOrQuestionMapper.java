package xyz.thishome.onling_ksxt.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.thishome.onling_ksxt.pojo.FillOrQuestion;
import xyz.thishome.onling_ksxt.pojo.FillOrQuestionExample;

public interface FillOrQuestionMapper {
    int countByExample(FillOrQuestionExample example);

    int deleteByExample(FillOrQuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FillOrQuestion record);

    int insertSelective(FillOrQuestion record);

    List<FillOrQuestion> selectByExample(FillOrQuestionExample example);

    FillOrQuestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FillOrQuestion record, @Param("example") FillOrQuestionExample example);

    int updateByExample(@Param("record") FillOrQuestion record, @Param("example") FillOrQuestionExample example);

    int updateByPrimaryKeySelective(FillOrQuestion record);

    int updateByPrimaryKey(FillOrQuestion record);
}