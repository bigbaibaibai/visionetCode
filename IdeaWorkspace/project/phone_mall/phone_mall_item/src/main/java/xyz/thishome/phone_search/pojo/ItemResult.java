package xyz.thishome.phone_search.pojo;

import xyz.thishome.phone.pojo.TbItem;
import xyz.thishome.phone.pojo.TbItemImage;

import java.util.List;

public class ItemResult extends TbItem {

    private String desc;
    private String param;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public List<TbItemImage> getItemImages() {
        return itemImages;
    }

    public void setItemImages(List<TbItemImage> itemImages) {
        this.itemImages = itemImages;
    }

    private List<TbItemImage> itemImages;

}
