package xyz.thishome.hotel.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import xyz.thishome.hotel.pojo.User;
import xyz.thishome.hotel.service.UserService;
import xyz.thishome.hotel.util.HotelMsg;
import xyz.thishome.hotel.util.MD5Utils;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 用户相关业务
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${Access_Control_Allow_Origin}")
    private String Access_Control_Allow_Origin;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public HotelMsg login(User user, HttpServletResponse response) throws Exception {
        response.addHeader("Access-Control-Allow-Origin", Access_Control_Allow_Origin);

        //判断用户名密码是否为空
        if (user == null || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return HotelMsg.bulid("用户名和密码不能为空！");
        }
        //密码md5加密处理
        user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
        //从数据库中查询用户
        User loginUser = userService.login(user);
        if (loginUser == null) {
            return HotelMsg.bulid("用户名或密码不正确！");
        }
        loginUser.setPassword("");
        return HotelMsg.success(loginUser);
    }

    @PostMapping("/regist")
    public HotelMsg regist(User user, HttpServletResponse response) throws Exception {
        response.addHeader("Access-Control-Allow-Origin", Access_Control_Allow_Origin);

        //关键信息是否为空
        if (user == null || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return HotelMsg.bulid("用户名和密码不能为空！");
        }
        //判断身份证号是否为空
        if (user.getIdCard() == null) {
            return HotelMsg.bulid("身份证号不能为空！");
        }

        //判断用户名是否存在
        User sameUser = userService.getUser(user.getUsername());
        if (sameUser != null) {
            return HotelMsg.bulid("用户名已存在");
        }
        //判断身份证是否存在
        sameUser = userService.getUser(user.getIdCard());
        if (sameUser != null) {
            return HotelMsg.bulid("身份证号已存在");
        }
        //密码md5加密处理
        user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
        //添加到数据库中
        userService.saveUser(user);
        //返回对象密码置空
        user.setPassword("");
        return HotelMsg.success(user);
    }

    @PostMapping("/delete")
    public HotelMsg delUser(@RequestParam("idCard") Integer userId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", Access_Control_Allow_Origin);
        userService.delete(userId);
        return HotelMsg.success();
    }

    @PostMapping("/update")
    public HotelMsg edit(User user, HttpServletResponse response) throws Exception {
        response.addHeader("Access-Control-Allow-Origin", Access_Control_Allow_Origin);
        //判断用户名是否存在
        User sameUser = userService.getUser(user.getUsername());
        if (sameUser != null) {
            return HotelMsg.bulid("用户名已存在");
        }
        if (user.getPassword() != null) {
            //密码md5加密处理
            user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
        }
        userService.edit(user);
        return HotelMsg.success(user);
    }

    @PostMapping("/get")
    public HotelMsg getUser(@RequestParam("userId") Integer userId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", Access_Control_Allow_Origin);
        User user = userService.getUser(userId);
        user.setPassword("");
        return HotelMsg.success(user);
    }

    @GetMapping("/getForName")
    public HotelMsg getUser(@RequestParam("username") String username, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", Access_Control_Allow_Origin);
        User user = userService.getUser(username);
        user.setPassword("");
        return HotelMsg.success(user);
    }

    @GetMapping("/getAll")
    public HotelMsg getUserAll(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", Access_Control_Allow_Origin);
        List<User> userList = userService.getUserList();
        for (User user : userList) {
            user.setPassword("");
        }
        return HotelMsg.success(userList);
    }
}
