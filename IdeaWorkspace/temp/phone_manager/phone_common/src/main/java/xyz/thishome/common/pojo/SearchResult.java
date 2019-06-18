package xyz.thishome.common.pojo;


import java.util.List;

/**
 * 封装了搜索需要返回总信息的pojo
 */
public class SearchResult {

    //商品信息列表
    private List<SearchItem> itemList;
    //总页码数
    private Integer pageCount;
    //当前第几页
    private Integer pageNo;

    public List<SearchItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<SearchItem> itemList) {
        this.itemList = itemList;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}
