package xyz.thishome.yuelitao_book.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.thishome.yuelitao_book.pojo.BookClass;
import xyz.thishome.yuelitao_book.pojo.BookClassExample;

import java.util.List;

public interface BookClassMapper {
    int countByExample(BookClassExample example);

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