package xyz.thishome.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xyz.thishome.common.utils.IMoocJSONResult;
import xyz.thishome.pojo.vo.UsersVo;
import xyz.thishome.service.UserService;

@RestController
@Api(value = "用户相关业务的接口", tags = {"用户相关业务的controller"})
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/uploadFace")
    @ApiOperation(value = "上传用户头像", notes = "上传用户头像的controller")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true,
            dataType = "String", paramType = "update")
    public IMoocJSONResult uploadFace(String userId, @RequestParam("file") MultipartFile[] multipartFiles) {
        if (StringUtils.isBlank(userId)) {
            return IMoocJSONResult.errorMsg("用户id不能为空");
        }
        if (multipartFiles != null && multipartFiles.length > 0) {
            String faceUrlDB = userService.uploadFace(userId, multipartFiles);
            if (null != faceUrlDB) {
                return IMoocJSONResult.ok(faceUrlDB);
            }
        }
        return IMoocJSONResult.errorMsg("上传异常");
    }

    @GetMapping("/query")
    @ApiOperation(value = "查询用户信息",notes = "查询用户信息的controller")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true,
            dataType = "String", paramType = "query")
    public IMoocJSONResult query(String userId){
        UsersVo user = userService.queryUserForId(userId);
        return IMoocJSONResult.ok(user);
    }

}
