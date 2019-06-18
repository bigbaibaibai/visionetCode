package xyz.thishome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.thishome.common.pojo.EasyUIResult;
import xyz.thishome.common.pojo.TaotaoResult;
import xyz.thishome.pojo.TbItem;
import xyz.thishome.pojo.TbItemDesc;
import xyz.thishome.pojo.TbItemParamItem;
import xyz.thishome.service.ItemService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品控制器
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 通过id获取商品
     */
    @RequestMapping("/{id}")
    public Map<String, Object> getItemById(@PathVariable("id") long id) {
        TbItem itemById = itemService.getItemById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("item", itemById);
        return map;
    }

    /**
     * 获商品列表，分页后商品信息
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    public EasyUIResult getList(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "rows", defaultValue = "30") int rows) {

        return itemService.getListItem(page, rows);
    }

    /**
     * 添加商品信息
     *
     * @param item       表单中商品信息
     * @param desc       商品描述
     * @param itemParams 商品参数规格JSON
     * @return TaotaoResult
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public TaotaoResult itemSave(TbItem item, @RequestParam("desc") String desc,
                                 @RequestParam("itemParams") String itemParams,
                                 @RequestParam("image") String [] images) {
        return itemService.createItem(item, desc, itemParams, images);
    }

    /**
     * 删除分类信息
     *
     * @param contentId
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public TaotaoResult deleteItem(@RequestParam("ids") List<Long> itemIds) {
        for (Long itemId : itemIds) {
            itemService.deleteItem(itemId);
        }
        return TaotaoResult.ok();
    }

    @RequestMapping("/getDesc/{itemId}")
    public TaotaoResult getDesc(@PathVariable("itemId") Long itemId) {
        TbItemDesc itemDesc = itemService.getItemDesc(itemId);
        return TaotaoResult.ok(itemDesc);
    }

    @RequestMapping("/getParam/{itemId}")
    public TaotaoResult getParam(@PathVariable("itemId") Long itemId) {
        TbItemParamItem itemParamItem = itemService.getParam(itemId);
        return TaotaoResult.ok(itemParamItem);
    }

    //更新商品信息
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public TaotaoResult updateItem(TbItem item, @RequestParam("desc") String desc, @RequestParam("itemParams") String itemParams) {
        itemService.updateItem(item, desc, itemParams);
        return TaotaoResult.ok();
    }

    //上架商品
    @RequestMapping(value = "instock", method = RequestMethod.POST)
    public TaotaoResult instock(@RequestParam("ids") List<Long> itemIds) {
        for (Long itemId : itemIds) {
            itemService.instock(itemId);
        }
        return TaotaoResult.ok();
    }

    //下架商品
    @RequestMapping(value = "reshelf", method = RequestMethod.POST)
    public TaotaoResult reshelf(@RequestParam("ids") List<Long> itemIds) {
        for (Long itemId : itemIds) {
            itemService.reshelf(itemId);
        }
        return TaotaoResult.ok();
    }

}
