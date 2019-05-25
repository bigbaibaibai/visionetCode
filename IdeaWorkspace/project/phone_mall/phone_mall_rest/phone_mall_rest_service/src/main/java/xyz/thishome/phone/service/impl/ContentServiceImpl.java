package xyz.thishome.phone.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.thishome.common.key.RedisKey;
import xyz.thishome.common.utils.JsonUtils;
import xyz.thishome.phone.mapper.TbContentMapper;
import xyz.thishome.phone.pojo.TbContent;
import xyz.thishome.phone.pojo.TbContentExample;
import xyz.thishome.phone.service.ContentService;
import xyz.thishome.util.RedisUtil;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper contentMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<TbContent> getContent(Long categoryId) {

        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        //根据内容分类获取页面内容
        List<TbContent> contents = contentMapper.selectByExample(example);
        return contents;
    }

    @Override
    public List<TbContent> getContentFromRedis(Long categoryId) {
        String json = redisUtil.get(getKey(categoryId));
        if (StringUtils.isBlank(json)) {
            return null;
        }
        redisUtil.expire(getKey(categoryId), RedisKey.PAGE_CONTENT_REDIS_EXPIRE);
        List<TbContent> tbContents = JsonUtils.jsonToList(json, TbContent.class);
        return tbContents;
    }

    @Override
    public void saveContentToRedis(Long categoryId, List<TbContent> contents) {
        String toJson = JsonUtils.objectToJson(contents);
        redisUtil.set(getKey(categoryId), toJson, RedisKey.PAGE_CONTENT_REDIS_EXPIRE);
    }

    @Override
    public void delContentRedis(Long categoryId) {
        redisUtil.del(getKey(categoryId));
    }

    public String getKey(Long categoryId) {
        return RedisKey.PAGE_CONTENT_REDIS_KEY + ":" + categoryId;
    }

}
