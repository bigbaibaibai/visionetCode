package xyz.thishome.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.thishome.common.utils.IMoocJSONResult;
import xyz.thishome.common.utils.MD5Utils;
import xyz.thishome.pojo.Users;
import xyz.thishome.pojo.vo.UsersVo;
import xyz.thishome.service.UserService;

@Api(value = "用户注册登录的接口", tags = {"注册登录的controller"})
@RestController
public class RegistLoginController {

    @Autowired
    private UserService userService;

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "用户注册", notes = "用户注册的接口")
    @PostMapping("/regist")
    public IMoocJSONResult regist(@RequestBody Users user) throws Exception {
        //判断用户名密码是否为空
        if (user == null || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return IMoocJSONResult.errorMsg("用户名和密码不能为空！");
        }
        //判断用户名是否已存在
        boolean usernameIsExist = userService.queryUsernameIsExist(user.getUsername());
        //注册用户
        if (!usernameIsExist) {
            //补全用户信息
            user.setNickname(user.getUsername());
            user.setFansCounts(0);
            user.setFollowCounts(0);
            user.setReceiveLikeCounts(0);
            //密码加密
            user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
            //保存用户
            userService.saveUser(user);
            //添加到redis的session中
            user.setPassword("");
            UsersVo usersVo = userService.addToRedisSession(user);
            return IMoocJSONResult.ok(usersVo);
        }
        return IMoocJSONResult.errorMsg("用户名已存在！");
    }

    @ApiOperation(value = "登录接口", notes = "用户登录的接口")
    @PostMapping("/login")
    public IMoocJSONResult login(@RequestBody Users user) throws Exception {
        //判断用户名密码是否为空
        if (user == null || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return IMoocJSONResult.errorMsg("用户名和密码不能为空！");
        }
        //对密码进行MD5加密
        user.setPassword(MD5Utils.getMD5Str(user.getPassword()));

        //调用service方法判断用户名密码是否匹配
        user = userService.queryForLogin(user);

        if (user != null) {
            user.setPassword("");
            UsersVo usersVo = userService.addToRedisSession(user);
            return IMoocJSONResult.ok(usersVo);
        }
        return IMoocJSONResult.errorMsg("用户名密码不匹配！");
    }

    @PostMapping("/logout")
    @ApiOperation(value = "用户注销", notes = "用户注销的接口")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true,
            dataType = "String", paramType = "query")
    public IMoocJSONResult logout(String userId) {
        userService.delSessionForLogout(userId);
        return IMoocJSONResult.ok();
    }

}
