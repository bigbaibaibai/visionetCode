package xyz.thishome.hotel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.thishome.hotel.mapper.HouseMapper;
import xyz.thishome.hotel.pojo.House;
import xyz.thishome.hotel.pojo.HouseExample;
import xyz.thishome.hotel.service.HouseService;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseMapper houseMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<House> getLeisureHouse() {
        HouseExample example = new HouseExample();
        HouseExample.Criteria criteria = example.createCriteria();
        criteria.andHouseStatusEqualTo(0);
        List<House> houses = houseMapper.selectByExampleWithBLOBs(example);
        return houses;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<House> getLeisureHouseForLevel(Integer level) {
        HouseExample example = new HouseExample();
        HouseExample.Criteria criteria = example.createCriteria();
        criteria.andHouseStatusEqualTo(0);
        criteria.andHouseLevelEqualTo(level);
        List<House> houses = houseMapper.selectByExampleWithBLOBs(example);
        return houses;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<House> getHouseList() {
        return houseMapper.selectByExampleWithBLOBs(null);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public House getHouseForHouseNumber(Integer houseId) {
        HouseExample example = new HouseExample();
        HouseExample.Criteria criteria = example.createCriteria();
        criteria.andHouseNumberEqualTo(houseId);
        List<House> houses = houseMapper.selectByExampleWithBLOBs(example);
        if (houses != null && houses.size() > 0) {
            return houses.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public House getHouseForId(Integer houseId) {
        HouseExample example = new HouseExample();
        HouseExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(houseId);
        List<House> houses = houseMapper.selectByExampleWithBLOBs(example);
        if (houses != null && houses.size() > 0) {
            return houses.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public House saveHouse(House house) {
        house.setHouseStatus(0);
        houseMapper.insertSelective(house);
        return house;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer houseId) {
        HouseExample example = new HouseExample();
        HouseExample.Criteria criteria = example.createCriteria();
        criteria.andHouseNumberEqualTo(houseId);
        houseMapper.deleteByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public House edit(House house) {
        houseMapper.updateByPrimaryKeyWithBLOBs(house);
        return house;
    }
}
