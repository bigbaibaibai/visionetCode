package xyz.thishome.base.controller;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import xyz.thishome.base.pojo.Label;
import xyz.thishome.base.service.LabelService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping
    public Result findAll() {
        List<Label> all = labelService.findAll();
        return new Result(true, StatusCode.OK, "查询所有", all);
    }

    @GetMapping("/{labelId}")
    public Result findById(@PathVariable("labelId") String lableId) {
        Label byId = labelService.findById(lableId);
        return new Result(true, StatusCode.OK, "通过id查询", byId);
    }

    @PostMapping
    public Result save(@RequestBody Label label) {
        labelService.save(label);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @PutMapping("/{labelId}")
    public Result update(@PathVariable("labelId") String labelId, @RequestBody Label label) {
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    @DeleteMapping("/labelId")
    public Result deleteById(@PathVariable("labelId") String lableId) {
        labelService.delete(lableId);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @PostMapping("/search")
    public Result search(@RequestBody Label label) {
        List<Label> searchList = labelService.findSearchList(label);
        return new Result(true, StatusCode.OK, "搜索", searchList);
    }

    @PostMapping("/search/{page}/{size}")
    public Result searchPage(@PathVariable("page") int page, @PathVariable("size") int size,
                             @RequestBody Label label) {

        Page<Label> pageData = labelService.findSearchPage(label, page, size);
        PageResult<Label> pageResult = new PageResult<>(pageData.getTotalElements(), pageData.getContent());
        return new Result(true, StatusCode.OK, "搜索", pageResult);
    }

}
