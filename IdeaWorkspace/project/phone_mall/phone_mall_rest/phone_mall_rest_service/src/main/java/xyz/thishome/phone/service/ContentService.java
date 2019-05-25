package xyz.thishome.phone.service;

import xyz.thishome.phone.pojo.TbContent;

import java.util.List;

public interface ContentService {

    //根据内容分类获取页面内容列表
    List<TbContent> getContent(Long categoryId);

    //根据内容分类从redis中取内容信息
    List<TbContent> getContentFromRedis(Long categoryId);

    //把内容信息列表存入redis，key由分类ID生成
    void saveContentToRedis(Long categoryId, List<TbContent> contents);

    //根据分类ID删除响应的内容分类
    void delContentRedis(Long categoryId);

}
