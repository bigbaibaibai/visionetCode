package xyz.thishome.hotel.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import xyz.thishome.hotel.pojo.House;
import xyz.thishome.hotel.service.HouseService;
import xyz.thishome.hotel.util.HotelMsg;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/house")
public class HotelController {

    @Value("${Access_Control_Allow_Origin}")
    private String Access_Control_Allow_Origin;

    @Autowired
    private HouseService houseService;

    @GetMapping("/get/{houseId}")
    public HotelMsg getHouse(@PathVariable("houseId") Integer houseId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", Access_Control_Allow_Origin);
        House house = houseService.getHouseForHouseNumber(houseId);
        if (house != null) {
            return HotelMsg.success(house);
        }
        return HotelMsg.bulid("房间不存在");
    }

    @PostMapping("/add")
    public HotelMsg regist(House house, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", Access_Control_Allow_Origin);
        //关键信息是否为空
        if (house == null || house.getHouseNumber() == null || StringUtils.isBlank(house.getHouseFloor()) || house.getHouseLevel() == null) {
            return HotelMsg.bulid("房间号、楼层和房间级别，不能为空！");
        }
        //判断房间号是否已存在
        House house1 = houseService.getHouseForHouseNumber(house.getHouseNumber());
        if (house1 != null) {
            return HotelMsg.bulid("房间号已存在");
        }
        houseService.saveHouse(house);
        return HotelMsg.success(house);
    }

    @GetMapping("/getAll")
    public HotelMsg getAll(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", Access_Control_Allow_Origin);
        return HotelMsg.success(houseService.getHouseList());
    }

    /**
     * 获取空闲的房间（状态为0）
     *
     * @return
     */
    @GetMapping("/getLeisureHouse")
    public HotelMsg getLeisureHouse(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", Access_Control_Allow_Origin);
        return HotelMsg.success(houseService.getLeisureHouse());
    }

    /**
     * 根据级别获取空闲房间，0普通，1标准，2豪华
     *
     * @return
     */
    @GetMapping("/getLeisureHouseForLevel/{level}")
    public HotelMsg getLeisureHouseForLevel(@PathVariable("level") Integer level, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", Access_Control_Allow_Origin);
        return HotelMsg.success(houseService.getLeisureHouseForLevel(level));
    }

    @PostMapping("/delete/{houseId}")
    public HotelMsg delUser(@PathVariable("houseId") Integer houseId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", Access_Control_Allow_Origin);
        houseService.delete(houseId);
        return HotelMsg.success();
    }

    @PostMapping("/update")
    public HotelMsg edit(House house, HttpServletResponse response) {
        //验证房间id是否为空
        response.addHeader("Access-Control-Allow-Origin", Access_Control_Allow_Origin);
        if (house == null || house.getId() == null) {
            return HotelMsg.bulid("房间id为空");
        }
        //查看id对应房间是否存在
        House house1 = houseService.getHouseForId(house.getId());
        if (house1 == null) {
            return HotelMsg.bulid("房间不存在");
        }
        //如果表单中有房间号，判表单中的房间号与数据库中的房间号是否相同
        if (house.getHouseNumber() != null && house.getHouseNumber().compareTo(house1.getHouseNumber()) != 0) {

            //如果不相同，查询表单中的房间号在数据库中对应的房间是否已存在
            House house2 = houseService.getHouseForHouseNumber(house.getHouseNumber());
            //如果存在则返回房间号已存在
            if (house2 != null) {
                return HotelMsg.bulid("房间号已存在");
            }
        }
        houseService.edit(house);
        return HotelMsg.success(house);
    }

}
