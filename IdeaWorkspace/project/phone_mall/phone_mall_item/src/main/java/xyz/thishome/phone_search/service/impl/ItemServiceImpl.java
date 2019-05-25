package xyz.thishome.phone_search.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.thishome.common.utils.JsonUtils;
import xyz.thishome.phone.mapper.*;
import xyz.thishome.phone.pojo.*;
import xyz.thishome.phone_search.pojo.ItemResult;
import xyz.thishome.phone_search.service.ItemService;
import xyz.thishome.util.RedisUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Autowired
    private TbItemDescMapper itemDescMapper;

    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;

    @Autowired
    private TbItemImageMapper itemImageMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<TbItem> query(String query, Long classId, Integer pageNo, Integer size) {
        List<Long> ids = new ArrayList<>();
        if (classId != null) {
            List<TbItemCat> itemCats = itemCatMapper.selectByExample(null);
            TbItemCat tbItemCat = itemCatMapper.selectByPrimaryKey(classId);
            getIds(tbItemCat, ids, itemCats);
        }
        PageHelper.startPage(pageNo, size);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        if (query != null) {
            criteria.andTitleLike("%" + query + "%");
            TbItemExample.Criteria or = example.or();
            or.andSellPointLike("%" + query + "%");
            byte b = 1;
            or.andStatusEqualTo(b);
        }
        if (ids.size() > 0) {
            criteria.andCidIn(ids);
        }
        byte b = 1;
        criteria.andStatusEqualTo(b);
        example.setOrderByClause("purpose desc");
        List<TbItem> tbItems = itemMapper.selectByExample(example);
        PageInfo<TbItem> of = PageInfo.of(tbItems);

        return of;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public TbItemDesc getItemDesc(Long itemId) {
        return itemDescMapper.selectByPrimaryKey(itemId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public TbItemParamItem getItemParamItem(Long itemId) {
        TbItemParamItemExample example = new TbItemParamItemExample();
        TbItemParamItemExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        List<TbItemParamItem> tbItemParamItems = itemParamItemMapper.selectByExampleWithBLOBs(example);
        if (tbItemParamItems != null && tbItemParamItems.size() > 0) {
            return tbItemParamItems.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<TbItemImage> getItemImages(Long itemId) {
        TbItemImageExample example = new TbItemImageExample();
        TbItemImageExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        List<TbItemImage> tbItemImages = itemImageMapper.selectByExample(example);
        return tbItemImages;
    }

    private void getIds(TbItemCat tbItemCat, List<Long> ids, List<TbItemCat> itemCats) {
        if (tbItemCat.getIsParent()) {
            for (TbItemCat itemCat : itemCats) {
                if (itemCat.getParentId().compareTo(tbItemCat.getId()) == 0) {
                    getIds(itemCat, ids, itemCats);
                }
            }
        } else {
            ids.add(tbItemCat.getId());
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public TbItem getItemForId(Long itemId) {
        return itemMapper.selectByPrimaryKey(itemId);
    }

//
//    @Override
//    public List<TbItem> getHotItemList(Integer size) {
//        return null;
//    }

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<TbItem> getItemListFormRedis(String key) {

        return null;
    }

    @Override
    public void addItemListToRedis(String key, List<TbItem> itemList) {

    }

    @Override
    public void saveToRedis(String key, ItemResult item, Long expire) {
        if (item != null)
            redisUtil.set(key, JsonUtils.objectToJson(item), expire);
    }

    @Override
    public ItemResult getFromRedis(String key, Long expire) {
        String json = redisUtil.get(key);
        if (StringUtils.isBlank(json)) {
            return null;
        }
        ItemResult item = JsonUtils.jsonToPojo(json, ItemResult.class);
        redisUtil.expire(key, expire);
        return item;
    }

}
