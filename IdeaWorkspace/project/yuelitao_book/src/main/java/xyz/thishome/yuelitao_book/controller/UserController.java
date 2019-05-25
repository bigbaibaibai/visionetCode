package xyz.thishome.yuelitao_book.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.thishome.yuelitao_book.pojo.UserAccount;
import xyz.thishome.yuelitao_book.pojo.UserAddress;
import xyz.thishome.yuelitao_book.service.UserService;
import xyz.thishome.yuelitao_book.util.BookMsg;
import xyz.thishome.yuelitao_book.util.CookieUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //用户注册
    @PostMapping("/regist")
    public BookMsg regist(UserAccount userAccount,
                          HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //判空
        if (userAccount == null || StringUtils.isBlank(userAccount.getYhMch()) ||
                StringUtils.isBlank(userAccount.getYhMm())) {
            return BookMsg.bulid("用户名和密码不能为空！");
        }

        //判断用户名是否存在
        UserAccount userForUsername = userService.getUserForUsername(userAccount.getYhMch());
        if (userForUsername != null) {
            return BookMsg.bulid("用户名已存在！");
        }
        //添加用户
        UserAccount addUser = userService.addUser(userAccount);

        //生成token，把用户对象存到redis，key根据token生成
        String token = UUID.randomUUID().toString();
        userService.addToeknToRedis(token, addUser);

//        //把token写到cookie中
//        CookieUtils.setCookie(request, response, "token", token);
        //返回注册的用户
        return BookMsg.success(token);
    }

    //用户登录
    @PostMapping("/login")
    public BookMsg login(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //判空
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return BookMsg.bulid("用户名和密码不能为空！");
        }

        //查数据库
        UserAccount userForLogin = userService.getUserForLogin(username, password);
        if (userForLogin == null) {
            return BookMsg.bulid("用户名或密码不正确！");
        }

        //生成token，把用户对象存到redis，key根据token生成，30分钟过期
        String token = UUID.randomUUID().toString();
        userService.addToeknToRedis(token, userForLogin);
//        //把token写入cookie
//        CookieUtils.setCookie(request, response, "token", token);
        //返回登录用户
        return BookMsg.success(token);
    }

    //用户删除
    @DeleteMapping("/delUser")
    public BookMsg delUser(@RequestParam("userId") Integer userId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        userService.delUser(userId);
        return BookMsg.success();
    }


    //用户注销
    @PostMapping("/logout")
    public BookMsg logout(@RequestParam("token") String token, HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //从cookie中删除token
        userService.delTokenFromRedis(token);
        return BookMsg.success();
    }

    //通过token获取登录对象
    @PostMapping("/getUserForToken")
    public BookMsg getUserForToken(@RequestParam("token") String token, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        UserAccount userFromRedisByToken = userService.getUserFromRedisByToken(token);
        if (userFromRedisByToken == null) {
            return BookMsg.bulid("用户未登录！");
        }
        return BookMsg.success(userFromRedisByToken);
    }

    //根据用户id获取用户信息
    @GetMapping("/getUserForId/{userId}")
    public BookMsg getUserForId(@PathVariable("userId") Integer userId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        UserAccount uesrForId = userService.getUesrForId(userId);
        return BookMsg.success(uesrForId);
    }

    //用户信息更新
    @PostMapping("/updateUser")
    public BookMsg updateUser(UserAccount userAccount, @RequestParam(value = "address", required = false) String address,
                              HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //判空
        if (userAccount == null || userAccount.getId() == null) {
            return BookMsg.bulid("信息不足");
        }
        //修改
        userService.updateUser(userAccount);
        if (address != null) {
            userService.addAddress(userAccount.getId(), address);
        }
        UserAccount uesrForId = userService.getUesrForId(userAccount.getId());
        uesrForId.setYhMm(null);
        //返回用户对象
        return BookMsg.success(uesrForId);
    }

    @GetMapping("/getAddress/{userId}")
    public BookMsg getAddress(@PathVariable("userId") Integer userId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        UserAddress address = userService.getUserAddress(userId);
        if (address == null) {
            return BookMsg.bulid("用户地址为空");
        }
        return BookMsg.success(address);
    }

}
