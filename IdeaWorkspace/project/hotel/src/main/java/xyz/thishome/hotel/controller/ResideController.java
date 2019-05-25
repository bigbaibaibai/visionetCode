package xyz.thishome.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import xyz.thishome.hotel.pojo.Reside;
import xyz.thishome.hotel.service.ResideService;
import xyz.thishome.hotel.util.HotelMsg;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/reside")
public class ResideController {

    @Value("${Access_Control_Allow_Origin}")
    private String Access_Control_Allow_Origin;

    @Autowired
    private ResideService resideService;

    @PostMapping("/reserve")
    public HotelMsg reserve(Reside reside, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", Access_Control_Allow_Origin);
        //关键信息是否为空
        if (reside == null || reside.getUserId() == null || reside.getCheckInTime() == null || reside.getDepartureTime() == null || reside.getUserId() == null) {
            return HotelMsg.bulid("房间号、身份证号、入住时间和离店时间，不能为空！");
        }
        resideService.insert(reside);
        return HotelMsg.success(reside);
    }

    @GetMapping("/getAll")
    public HotelMsg getAll(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", Access_Control_Allow_Origin);
        return HotelMsg.success(resideService.getAll());
    }

    @GetMapping("/get/{resideId}")
    public HotelMsg get(@PathVariable("resideId") Integer resideId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", Access_Control_Allow_Origin);
        return HotelMsg.success(resideService.get(resideId));
    }

}
