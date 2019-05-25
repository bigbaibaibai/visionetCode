package xyz.thishome.phone.service;

import xyz.thishome.phone.pojo.TbItemCat;

import java.util.List;

public interface ItemCartService {

    List<TbItemCat> getCartNoParent(Integer size);

    List<TbItemCat> getCartNoChild(Integer size);

    void addToRedis(String key,List<TbItemCat> itemCats,Long expire);

    List<TbItemCat> getCartListFromRedis(String key,Long expire);

}
