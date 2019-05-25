package xyz.thishome.phone_sso.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import xyz.thishome.common.pojo.PhoneMsg;
import xyz.thishome.common.utils.MD5Utils;
import xyz.thishome.phone.pojo.TbUser;
import xyz.thishome.phone_sso.service.SsoService;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/sso")
public class SsoController {

    @Value("${SSO_TOKEN}")
    private String SSO_TOKEN;

    @Autowired
    private SsoService ssoService;

    //登录
    @PostMapping("/login")
    public PhoneMsg login(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //判空
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return PhoneMsg.bulid("用户名或密码不能为空");
        }

        //密码Md5加密
        try {
            password = MD5Utils.getMD5Str(password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //查询
        TbUser userForLogin = ssoService.getUserForLogin(username, password);
        if (userForLogin == null) {
            return PhoneMsg.bulid("用户名或密码输入错误");
        }

        userForLogin.setPassword(null);
        //生成token，存到redis中
        String token = UUID.randomUUID().toString();
        ssoService.addUserToRedis(SSO_TOKEN + ":" + token, userForLogin);

        //返回token
        return PhoneMsg.success(token);
    }

    //注册
    @PostMapping("/regist")
    public PhoneMsg regist(TbUser user, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //判空
        if (user == null || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return PhoneMsg.bulid("用户名和密码不能为空");
        }

        //判断用户名是否存在
        TbUser userForUsername = ssoService.getUserForUsername(user.getUsername());
        if (userForUsername != null) {
            return PhoneMsg.bulid("用户名已存在");
        }

        //密码Md5加密
        try {
            user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //补全用户时间戳
        Date date = new Date();
        user.setUpdated(date);
        user.setCreated(date);


        //添加用户
        ssoService.registUser(user);

        //密码置空
        user.setPassword(null);

        //生成token，存入redis
        String token = UUID.randomUUID().toString();
        ssoService.addUserToRedis(SSO_TOKEN + ":" + token, user);

        //返回token
        return PhoneMsg.success(token);
    }


    //登出
    @DeleteMapping("/logout")
    public PhoneMsg logout(@RequestParam("token") String token, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //从redis中删除token
        ssoService.logoutToRedis(SSO_TOKEN + ":" + token);

        return PhoneMsg.success();
    }

}
