package xyz.thishome.phone_search.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import xyz.thishome.common.pojo.PhoneMsg;
import xyz.thishome.phone.pojo.TbItem;
import xyz.thishome.phone.pojo.TbItemDesc;
import xyz.thishome.phone.pojo.TbItemImage;
import xyz.thishome.phone.pojo.TbItemParamItem;
import xyz.thishome.phone_search.pojo.ItemResult;
import xyz.thishome.phone_search.pojo.SearchItem;
import xyz.thishome.phone_search.pojo.SearchResult;
import xyz.thishome.phone_search.service.ItemService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Value("${ITEM_KEY}")
    private String ITEM_KEY;

    @Value("${ITEM_EXPIRE_TIME}")
    private Long ITEM_EXPIRE_TIME;

    //根据ID搜索单个商品
    @GetMapping("/get/{itemId}")
    public PhoneMsg getOne(@PathVariable("itemId") Long itemId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        ItemResult item = null;
        //从缓存中查
        try {
            item = itemService.getFromRedis(ITEM_KEY + ":" + itemId, ITEM_EXPIRE_TIME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (item != null) {
            return PhoneMsg.success(item);
        }

        //从数据库中查
        item = new ItemResult();
        TbItem itemForId = itemService.getItemForId(itemId);
        BeanUtils.copyProperties(itemForId, item);
        TbItemDesc itemDesc = itemService.getItemDesc(itemId);
        if (itemDesc != null) {
            item.setDesc(itemDesc.getItemDesc());
        }
        TbItemParamItem itemParamItem = itemService.getItemParamItem(itemId);
        if (itemParamItem != null) {
            item.setParam(itemParamItem.getParamData());
        }
        List<TbItemImage> itemImages = itemService.getItemImages(itemId);
        if (itemImages != null && itemImages.size() > 0) {
            item.setItemImages(itemImages);
        }

        //存入缓存
        try {
            itemService.saveToRedis(ITEM_KEY + ":" + itemId, item, ITEM_EXPIRE_TIME);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return PhoneMsg.success(item);
    }

    //根据分类名称获取商品列表
    @GetMapping("/query")
    public PhoneMsg getListByClassName(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                       @RequestParam("pageSize") Integer pageSize,
                                       @RequestParam(value = "classId", required = false) Long classId,
                                       @RequestParam(value = "query", required = false) String query,
                                       HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        PageInfo<TbItem> tbItemPageInfo = itemService.query(query, classId, pageNo, pageSize);
        return PhoneMsg.success(tbItemPageInfo);
    }

}
