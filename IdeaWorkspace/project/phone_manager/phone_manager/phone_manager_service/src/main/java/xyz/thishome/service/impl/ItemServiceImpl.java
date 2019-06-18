package xyz.thishome.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.thishome.common.pojo.EasyUIResult;
import xyz.thishome.common.pojo.TaotaoResult;
import xyz.thishome.common.utils.IDUtils;
import xyz.thishome.mapper.*;
import xyz.thishome.pojo.*;
import xyz.thishome.service.ItemService;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;

    @Autowired
    private TbItemDescMapper itemDescMapper;

    @Autowired
    private TbItemCatMapper itemCatMapper;

//    @Value("${SEARCH_BASE_URL}")
//    private String SEARCH_BASE_URL;
//
//    @Value("${SEARCH_CONTENT_SYNC_URL}")
//    private String SEARCH_CONTENT_SYNC_URL;

    /**
     * 根据id获取商品
     *
     * @param id
     * @return
     */
    @Override
    public TbItem getItemById(Long id) {
        TbItem tbItem = itemMapper.selectByPrimaryKey(id);
        return tbItem;
    }

    /**
     * 分页获取商品列表
     *
     * @return
     */
    @Override
    public EasyUIResult getListItem(int page, int rows) {
        PageHelper.startPage(page, rows);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        Byte b = 3;
        criteria.andStatusNotEqualTo(b);
        List<TbItem> tbItems = itemMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(tbItems);
        EasyUIResult easyUIResult = new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
        return easyUIResult;
    }

    @Autowired
    private TbItemImageMapper itemImageMapper;

    /**
     * 添加商品
     *
     * @param item       表单中商品信息
     * @param decs       商品描述
     * @param itemParams 商品规格说明JSON
     * @param images
     * @return
     */
    @Override
    public TaotaoResult createItem(TbItem item, String decs, String itemParams, String[] images) {
        //补全id
        long id = IDUtils.genItemId();
        if (images != null && images.length > 0) {
            item.setImage(images[0]);
        }
        item.setId(id);
        //补全状态码，1正常
        item.setStatus((byte) 1);
        //补全更新时间
        item.setUpdated(new Date());
        //补全上架时间
        item.setCreated(new Date());
        //添加商品到数据库中
        itemMapper.insertSelective(item);

        //添加图片到数据库
        if (images != null && images.length > 0) {
            for (String image : images) {
                TbItemImage tbItemImage = new TbItemImage();
                tbItemImage.setItemId(item.getId());
                tbItemImage.setImgUrl(image);
                itemImageMapper.insertSelective(tbItemImage);
            }
        }

        //添加商品规格说明到数据库中
        if (insertItemParams(id, itemParams).getStatus() != 200) {
            throw new RuntimeException("添加商品规格参数异常！");
        }
        //添加商品描述到数据库中
        if (createDesc(id, decs).getStatus() != 200) {
            throw new RuntimeException("添加商品描述异常！");
        }
//        //添加商品信息到搜索引擎中
//        try {
//            importSeach(item, decs);
//        } catch (Exception e) {
//            throw new RuntimeException("添加商品信息到搜索引擎异常！");
//        }
        return TaotaoResult.ok();
    }

    @Override  //设置状态为3
    public void deleteItem(Long itemId) {
        byte b = 3;
        setItemStatus(itemId, b);
    }

    @Override
    public TbItemDesc getItemDesc(Long itemId) {
        TbItemDescExample example = new TbItemDescExample();
        TbItemDescExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        List<TbItemDesc> tbItemDescs = itemDescMapper.selectByExampleWithBLOBs(example);
        if (tbItemDescs != null && tbItemDescs.size() > 0) {
            return tbItemDescs.get(0);
        }
        return null;
    }

    @Override
    public TbItemParamItem getParam(Long itemId) {
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
    public void updateItem(TbItem item, String desc, String itemParams) {
        //更新商品信息
        item.setUpdated(new Date());
        itemMapper.updateByPrimaryKeySelective(item);
        if (!StringUtils.isBlank(desc)) {
            //更新商品描述
            TbItemDesc itemDesc = new TbItemDesc();
            itemDesc.setItemId(item.getId());
            itemDesc.setItemDesc(desc);
            itemDesc.setUpdated(new Date());
            itemDescMapper.updateByPrimaryKeySelective(itemDesc);
        }
        if (!StringUtils.isBlank(itemParams)) {
            //更新商品规格参数
            TbItemParamItem tbItemParamItem = new TbItemParamItem();
            tbItemParamItem.setParamData(itemParams);
            tbItemParamItem.setUpdated(new Date());
            tbItemParamItem.setItemId(item.getId());
            TbItemParamItemExample example = new TbItemParamItemExample();
            TbItemParamItemExample.Criteria criteria = example.createCriteria();
            criteria.andItemIdEqualTo(item.getId());
            itemParamItemMapper.updateByExampleSelective(tbItemParamItem, example);
        }

    }

    @Override
    public void instock(Long itemId) {
        byte b = 2;
        setItemStatus(itemId, b);
    }

    @Override
    public void reshelf(Long itemId) {
        byte b = 1;
        setItemStatus(itemId, b);
    }


    //设置商品状态
    private void setItemStatus(Long itemId, byte itemStatus) {
        TbItem tbItem = new TbItem();
        tbItem.setId(itemId);
        tbItem.setStatus(itemStatus);
        itemMapper.updateByPrimaryKeySelective(tbItem);
    }

//    /**
//     * 导入到搜索引擎中
//     *
//     * @param item
//     * @param decs
//     */
//    pr  ivate void importSeach(TbItem item, String decs) {
//        //获取分类名称
//        TbItemCat tbItemCat = itemCatMapper.selectByPrimaryKey(item.getCid());
//        //封装post请求属性
//        Map<String, String> params = new HashMap();
//        params.put("id", String.valueOf(item.getId()));
//        params.put("title", item.getTitle());
//        params.put("price", String.valueOf(item.getPrice()));
//        params.put("image", item.getImage());
//        params.put("categoryName", tbItemCat.getName());
//        params.put("itemDesc", decs);
//        //向服务端发出请求
//        HttpClientUtil.doPost(SEARCH_BASE_URL + SEARCH_CONTENT_SYNC_URL, params);
//    }


    /**
     * 添加商品描述
     *
     * @param id
     * @param desc
     * @return
     */
    private TaotaoResult createDesc(Long id, String desc) {
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemDesc(desc);
        itemDesc.setItemId(id);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        itemDescMapper.insertSelective(itemDesc);
        return TaotaoResult.ok();
    }

    /**
     * 添加商品规格说明
     *
     * @param itemParams 商品参数规格JSON
     * @param id         商品id
     */
    private TaotaoResult insertItemParams(Long id, String itemParams) {
        TbItemParamItem paramItem = new TbItemParamItem();
        paramItem.setItemId(id);
        paramItem.setParamData(itemParams);
        paramItem.setCreated(new Date());
        paramItem.setUpdated(new Date());
        itemParamItemMapper.insert(paramItem);
        return TaotaoResult.ok();
    }
}
