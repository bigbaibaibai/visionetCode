package xyz.thishome.yuelitao_book.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.thishome.yuelitao_book.pojo.BookProduct;
import xyz.thishome.yuelitao_book.pojo.BookProductExample;

import java.util.List;

public interface BookProductMapper {
    int countByExample(BookProductExample example);

    int deleteByExample(BookProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BookProduct record);

    int insertSelective(BookProduct record);

    List<BookProduct> selectByExample(BookProductExample example);

    BookProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BookProduct record, @Param("example") BookProductExample example);

    int updateByExample(@Param("record") BookProduct record, @Param("example") BookProductExample example);

    int updateByPrimaryKeySelective(BookProduct record);

    int updateByPrimaryKey(BookProduct record);

    //获取状态为1的图书，获取前num本
    List<BookProduct> getBookHotForNum(Integer num);

    //获取销量前num的书
    List<BookProduct> getBookXlTopList(Integer num);
}