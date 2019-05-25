package xyz.thishome.yuelitao_book.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.thishome.yuelitao_book.pojo.UserPay;
import xyz.thishome.yuelitao_book.pojo.UserPayExample;

import java.util.List;

public interface UserPayMapper {
    int countByExample(UserPayExample example);

    int deleteByExample(UserPayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserPay record);

    int insertSelective(UserPay record);

    List<UserPay> selectByExample(UserPayExample example);

    UserPay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserPay record, @Param("example") UserPayExample example);

    int updateByExample(@Param("record") UserPay record, @Param("example") UserPayExample example);

    int updateByPrimaryKeySelective(UserPay record);

    int updateByPrimaryKey(UserPay record);
}