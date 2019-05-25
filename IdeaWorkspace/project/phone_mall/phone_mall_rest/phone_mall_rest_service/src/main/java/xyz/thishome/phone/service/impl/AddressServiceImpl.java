package xyz.thishome.phone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.thishome.phone.mapper.TbUserAddressMapper;
import xyz.thishome.phone.pojo.TbUserAddress;
import xyz.thishome.phone.pojo.TbUserAddressExample;
import xyz.thishome.phone.service.AddressService;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private TbUserAddressMapper userAddressMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addAddress(TbUserAddress userAddress) {
        userAddressMapper.insertSelective(userAddress);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void delAddress(Long addressId) {
        TbUserAddress tbUserAddress = new TbUserAddress();
        tbUserAddress.setId(addressId);
        tbUserAddress.setStatus(0);
        userAddressMapper.updateByPrimaryKeySelective(tbUserAddress);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateAddress(TbUserAddress userAddress) {
        userAddressMapper.updateByPrimaryKeySelective(userAddress);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<TbUserAddress> getList(Long userId) {
        TbUserAddressExample example = new TbUserAddressExample();
        TbUserAddressExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andStatusEqualTo(1);
        List<TbUserAddress> userAddresses = userAddressMapper.selectByExample(example);
        return userAddresses;
    }
}
