package xyz.thishome.hotel.service;

import xyz.thishome.hotel.pojo.House;

import java.util.List;

public interface HouseService {

    /**
     * 获取空闲的房间
     *
     * @return
     */
    List<House> getLeisureHouse();

    /**
     * 通过级别获取空闲房间，0普通，1标准，2豪华
     *
     * @param level
     * @return
     */
    List<House> getLeisureHouseForLevel(Integer level);

    /**
     * 获取所有房间
     *
     * @return
     */
    List<House> getHouseList();

    /**
     * 通过房间号获取房间
     *
     * @param house
     * @return
     */
    House getHouseForHouseNumber(Integer houseId);

    /**
     * 通过房间ID获取房间对象
     *
     * @return
     */
    House getHouseForId(Integer houseId);

    /**
     * 保存房间到数据库中
     *
     * @param house
     * @return
     */
    House saveHouse(House house);

    /**
     * 根据房间号删除房间
     *
     * @return
     */
    void delete(Integer houseId);

    /**
     * 房间信息修改
     *
     * @param user
     * @return
     */
    House edit(House user);

}
