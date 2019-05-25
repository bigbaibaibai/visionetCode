package xyz.thishome.phone.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.thishome.common.utils.JsonUtils;
import xyz.thishome.phone.mapper.TbItemCatMapper;
import xyz.thishome.phone.pojo.TbItemCat;
import xyz.thishome.phone.pojo.TbItemCatExample;
import xyz.thishome.phone.service.ItemCartService;
import xyz.thishome.util.RedisUtil;

import java.util.List;

@Service
public class ItemCartServiceImpl implements ItemCartService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<TbItemCat> getCartNoParent(Integer size) {
        PageHelper.startPage(1, size);
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(0L);
        example.setOrderByClause("sort_order");
        List<TbItemCat> tbItemCats = itemCatMapper.selectByExample(example);
        PageInfo<TbItemCat> of = PageInfo.of(tbItemCats);
        return of.getList();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<TbItemCat> getCartNoChild(Integer size) {
        PageHelper.startPage(1, size);
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andIsParentEqualTo(false);
        example.setOrderByClause("sort_order");
        List<TbItemCat> tbItemCats = itemCatMapper.selectByExample(example);
        PageInfo<TbItemCat> of = PageInfo.of(tbItemCats);
        return of.getList();
    }

    @Override
    public void addToRedis(String key, List<TbItemCat> itemCats, Long expire) {
        if (itemCats != null && itemCats.size() > 0)
            redisUtil.set(key, JsonUtils.objectToJson(itemCats), expire);
    }

    @Override
    public List<TbItemCat> getCartListFromRedis(String key, Long expire) {
        String json = redisUtil.get(key);
        if (StringUtils.isBlank(json)) {
            return null;
        }
        List<TbItemCat> tbItemCats = JsonUtils.jsonToList(json, TbItemCat.class);
        redisUtil.expire(key, expire);
        return tbItemCats;
    }
}
