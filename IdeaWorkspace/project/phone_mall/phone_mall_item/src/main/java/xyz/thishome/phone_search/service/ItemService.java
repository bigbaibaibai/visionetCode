package xyz.thishome.phone_search.service;

import com.github.pagehelper.PageInfo;
import xyz.thishome.phone.pojo.*;
import xyz.thishome.phone_search.pojo.ItemResult;
import xyz.thishome.phone_search.pojo.SearchItem;
import xyz.thishome.phone_search.pojo.SearchResult;

import java.util.List;

public interface ItemService {

//    //全文检索
//    List<TbItem> query(String query, Integer pageNo, Integer size);

    //通过id获取一个商品信息
    TbItem getItemForId(Long itemId);

//    //通过分类名称，按热度排序，分页获取商品信息
//    PageInfo<TbItem> getItemForClassId(Long classId, Integer pageNo, Integer size);
//
//    //获取热门商品
//    PageInfo<TbItem> getHotItemList(Integer size);

    //根据key从redis中获取图书列表
    List<TbItem> getItemListFormRedis(String key);

    //通过key和图书列表，存入redis
    void addItemListToRedis(String key, List<TbItem> itemList);

    //把商品存入redis中
    void saveToRedis(String key, ItemResult item, Long expire);

    //从商品中查询redis
    ItemResult getFromRedis(String key, Long expire);

    //查询
    PageInfo<TbItem> query(String query,Long classId, Integer pageNo, Integer size);

    //查询商品详情
    TbItemDesc getItemDesc(Long itemId);

    //查询商品参数
    TbItemParamItem getItemParamItem(Long itemId);

    //查询商品图片列表
    List<TbItemImage> getItemImages(Long itemId);
}
