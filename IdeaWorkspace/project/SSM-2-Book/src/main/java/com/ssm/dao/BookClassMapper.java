package com.ssm.dao;

import com.ssm.entites.BookClass;
import com.ssm.entites.BookClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookClassMapper {
    long countByExample(BookClassExample example);

    int deleteByExample(BookClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BookClass record);

    int insertSelective(BookClass record);

    List<BookClass> selectByExample(BookClassExample example);

    BookClass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BookClass record, @Param("example") BookClassExample example);

    int updateByExample(@Param("record") BookClass record, @Param("example") BookClassExample example);

    int updateByPrimaryKeySelective(BookClass record);

    int updateByPrimaryKey(BookClass record);
}