package xyz.thishome.phone.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.thishome.common.pojo.PhoneMsg;
import xyz.thishome.phone.pojo.TbUser;
import xyz.thishome.phone.pojo.TbUserAddress;
import xyz.thishome.phone.service.AddressService;
import xyz.thishome.phone.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserService userService;

    //获取所有用户地址
    @PostMapping("/getList")
    public PhoneMsg getAddress(@RequestParam("token") String token, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        TbUser userByToken = userService.getUserByToken(token);
        if (userByToken == null) {
            return PhoneMsg.bulid("用户未登录");
        }
        return PhoneMsg.success(addressService.getList(userByToken.getId()));
    }

    //添加地址
    @PostMapping("/add")
    public PhoneMsg addAddess(TbUserAddress tbUserAddress, @RequestParam("token") String token, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        TbUser userByToken = userService.getUserByToken(token);
        if (userByToken == null) {
            return PhoneMsg.bulid("用户未登录");
        }

        if (StringUtils.isBlank(tbUserAddress.getCity()) ||
                StringUtils.isBlank(tbUserAddress.getDistrict()) ||
                StringUtils.isBlank(tbUserAddress.getProvince()) ||
                StringUtils.isBlank(tbUserAddress.getAddress())) {
            return PhoneMsg.bulid("省、市、县（区）和详细地址不能为空！");
        }
        Date date = new Date();
        tbUserAddress.setCreated(date);
        tbUserAddress.setUpdated(date);
        tbUserAddress.setUserId(userByToken.getId());
        tbUserAddress.setStatus(1);
        addressService.addAddress(tbUserAddress);

        return PhoneMsg.success();
    }

    //更新地址
    @PutMapping("/update")
    public PhoneMsg update(TbUserAddress tbUserAddress, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        addressService.updateAddress(tbUserAddress);
        return PhoneMsg.success();
    }

    //删除地址
    @DeleteMapping("/delete/{id}")
    public PhoneMsg delete(@PathVariable("id") Long addressId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        addressService.delAddress(addressId);
        return PhoneMsg.success();
    }

}
