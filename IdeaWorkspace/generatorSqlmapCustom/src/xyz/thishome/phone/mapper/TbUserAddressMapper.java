package xyz.thishome.phone.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.thishome.phone.pojo.TbUserAddress;
import xyz.thishome.phone.pojo.TbUserAddressExample;

public interface TbUserAddressMapper {
    int countByExample(TbUserAddressExample example);

    int deleteByExample(TbUserAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbUserAddress record);

    int insertSelective(TbUserAddress record);

    List<TbUserAddress> selectByExample(TbUserAddressExample example);

    TbUserAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbUserAddress record, @Param("example") TbUserAddressExample example);

    int updateByExample(@Param("record") TbUserAddress record, @Param("example") TbUserAddressExample example);

    int updateByPrimaryKeySelective(TbUserAddress record);

    int updateByPrimaryKey(TbUserAddress record);
}