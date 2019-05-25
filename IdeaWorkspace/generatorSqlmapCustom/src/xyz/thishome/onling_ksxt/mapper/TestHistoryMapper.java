package xyz.thishome.onling_ksxt.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.thishome.onling_ksxt.pojo.TestHistory;
import xyz.thishome.onling_ksxt.pojo.TestHistoryExample;

public interface TestHistoryMapper {
    int countByExample(TestHistoryExample example);

    int deleteByExample(TestHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TestHistory record);

    int insertSelective(TestHistory record);

    List<TestHistory> selectByExample(TestHistoryExample example);

    TestHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TestHistory record, @Param("example") TestHistoryExample example);

    int updateByExample(@Param("record") TestHistory record, @Param("example") TestHistoryExample example);

    int updateByPrimaryKeySelective(TestHistory record);

    int updateByPrimaryKey(TestHistory record);
}