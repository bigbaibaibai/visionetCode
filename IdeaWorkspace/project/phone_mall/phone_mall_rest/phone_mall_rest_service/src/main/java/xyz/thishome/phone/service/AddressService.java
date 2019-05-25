package xyz.thishome.phone.service;

import xyz.thishome.phone.pojo.TbUserAddress;

import java.util.List;

public interface AddressService {

    //添加
    void addAddress(TbUserAddress userAddress);

    //删除
    void delAddress(Long addressId);

    //修改
    void updateAddress(TbUserAddress userAddress);

    //查询
    List<TbUserAddress> getList(Long userId);

}
