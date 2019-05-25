package com.ssm.dao;

import com.ssm.entites.CardItem;
import com.ssm.entites.CardItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CardItemMapper {
    long countByExample(CardItemExample example);

    int deleteByExample(CardItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardItem record);

    int insertSelective(CardItem record);

    List<CardItem> selectByExample(CardItemExample example);

    CardItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardItem record, @Param("example") CardItemExample example);

    int updateByExample(@Param("record") CardItem record, @Param("example") CardItemExample example);

    int updateByPrimaryKeySelective(CardItem record);

    int updateByPrimaryKey(CardItem record);
}