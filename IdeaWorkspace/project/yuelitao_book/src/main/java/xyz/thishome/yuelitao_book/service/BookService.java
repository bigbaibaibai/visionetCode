package xyz.thishome.yuelitao_book.service;

import com.github.pagehelper.PageInfo;
import xyz.thishome.yuelitao_book.pojo.BookClass;
import xyz.thishome.yuelitao_book.pojo.BookProduct;

import java.util.List;

public interface BookService {

    //判断库存是否足够
    boolean kcIsFill(Integer bookId, Integer num);

    //通过id获取一本书
    BookProduct getBookForId(Integer bookId);

    //获取所有分类
    List<BookClass> getBookClassList();

    //获取热门图书
    List<BookProduct> getBookHot();

    //获取销量前num名的图书
    List<BookProduct> getBookTopList();

    //获取所有图书（分页使用），如果查询条件和图书分类不为空，根据条件查询
    PageInfo<BookProduct> getBookList(Integer pageNo, String query, Integer bookClassId);

}
