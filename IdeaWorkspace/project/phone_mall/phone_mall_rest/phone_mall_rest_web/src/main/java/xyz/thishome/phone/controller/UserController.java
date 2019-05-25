package xyz.thishome.phone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.thishome.common.pojo.PhoneMsg;
import xyz.thishome.phone.pojo.TbUser;
import xyz.thishome.phone.service.UserService;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/getById")
    public PhoneMsg getUserById(@RequestParam("userId") Long userId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        TbUser userById = userService.getUserById(userId);
        userById.setPassword(null);
        return PhoneMsg.success(userById);
    }

    @PostMapping("/getForToken")
    public PhoneMsg getUserByToken(@RequestParam("token") String token, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        TbUser userByToken = userService.getUserByToken(token);
        return PhoneMsg.success(userByToken);
    }

    @PutMapping("/update")
    public PhoneMsg updateUser(TbUser user, @RequestParam("token") String token, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        userService.updateUser(user, token);
        return PhoneMsg.success();
    }


}
