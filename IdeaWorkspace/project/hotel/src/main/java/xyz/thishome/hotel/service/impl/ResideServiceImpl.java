package xyz.thishome.hotel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.thishome.hotel.mapper.HouseMapper;
import xyz.thishome.hotel.mapper.ResideMapper;
import xyz.thishome.hotel.mapper.UserMapper;
import xyz.thishome.hotel.pojo.*;
import xyz.thishome.hotel.service.ResideService;

import java.util.Date;
import java.util.List;

@Service
public class ResideServiceImpl implements ResideService {

    @Autowired
    private ResideMapper resideMapper;

    @Autowired
    private HouseMapper houseMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Reside insert(Reside reside) {
        //补全用户信息
        User user = userMapper.selectByPrimaryKey(reside.getUserId());
        reside.setUserPhone(user.getUserPhone());
        reside.setLastname(user.getLastname());
        //设置该房间为已预约
        House house = new House();
        house.setHouseStatus(1);
        HouseExample houseExample = new HouseExample();
        HouseExample.Criteria criteria = houseExample.createCriteria();
        criteria.andHouseNumberEqualTo(reside.getHostNumber());
        houseMapper.updateByExampleSelective(house, houseExample);
        //插入数据
        reside.setAppointmentTime(new Date());
        reside.setCreationTime(new Date());
        reside.setResideStatus(0);
        resideMapper.insertSelective(reside);
        return reside;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Reside> getAll() {
        ResideExample example = new ResideExample();
        example.setOrderByClause("check_in_time desc");
        List<Reside> resides = resideMapper.selectByExample(example);
        return resides;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Reside get(Integer resideId) {
        return resideMapper.selectByPrimaryKey(resideId);
    }
}
