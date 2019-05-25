package xyz.thishome.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.thishome.common.utils.IMoocJSONResult;
import xyz.thishome.pojo.Bgm;
import xyz.thishome.service.BgmService;

import java.util.List;

@RestController
@RequestMapping("/bgm")
@Api(value = "背景音乐相关业务的接口", tags = {"背景音乐相关业务的controller"})
public class BgmController {

    @Autowired
    private BgmService bgmService;

    @GetMapping("/list")
    @ApiOperation(value = "获取背景音乐列表",notes = "获取背景音乐列表的controller")
    public IMoocJSONResult queryList(){
        List<Bgm> bgms = bgmService.queryBgmList();
        return IMoocJSONResult.ok(bgms);
    }

}
