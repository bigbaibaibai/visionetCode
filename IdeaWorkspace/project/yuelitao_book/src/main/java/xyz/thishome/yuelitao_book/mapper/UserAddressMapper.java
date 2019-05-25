package xyz.thishome.yuelitao_book.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.thishome.yuelitao_book.pojo.UserAddress;
import xyz.thishome.yuelitao_book.pojo.UserAddressExample;

import java.util.List;

public interface UserAddressMapper {

    int countByExample(UserAddressExample example);

    int deleteByExample(UserAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAddress record);

    int insertSelective(UserAddress record);

    List<UserAddress> selectByExample(UserAddressExample example);

    UserAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserAddress record, @Param("example") UserAddressExample example);

    int updateByExample(@Param("record") UserAddress record, @Param("example") UserAddressExample example);

    int updateByPrimaryKeySelective(UserAddress record);

    int updateByPrimaryKey(UserAddress record);
}