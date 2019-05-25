package xyz.thishome.yuelitao_book.service;

import xyz.thishome.yuelitao_book.pojo.BookCartVo;

public interface BookCartService {

    //通过用户ID获取购物车对象
    BookCartVo getBookCart(Integer userId);

    //设置购物车对象
    void setBookCart(Integer userId, BookCartVo bookCartVo);

    //清空购物车
    void clearBookCart(Integer userId);

}
