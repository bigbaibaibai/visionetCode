package xyz.thishome.yuelitao_book.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xyz.thishome.yuelitao_book.mapper.BookClassMapper;
import xyz.thishome.yuelitao_book.mapper.BookProductMapper;
import xyz.thishome.yuelitao_book.pojo.BookClass;
import xyz.thishome.yuelitao_book.pojo.BookProduct;
import xyz.thishome.yuelitao_book.pojo.BookProductExample;
import xyz.thishome.yuelitao_book.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookProductMapper bookProductMapper;

    @Autowired
    private BookClassMapper bookClassMapper;

    @Override
    public boolean kcIsFill(Integer bookId, Integer num) {
        BookProduct bookProduct = bookProductMapper.selectByPrimaryKey(bookId);
        if (bookProduct != null) {
            return bookProduct.getKc() > num;
        }
        return false;
    }

    @Override
    public BookProduct getBookForId(Integer bookId) {
        return bookProductMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public List<BookClass> getBookClassList() {
        List<BookClass> bookClasses = bookClassMapper.selectByExample(null);
        return bookClasses;
    }

    @Value("${PAGR_HOT_NUM}")
    private Integer PAGR_HOT_NUM;

    @Override
    public List<BookProduct> getBookHot() {
        return bookProductMapper.getBookHotForNum(PAGR_HOT_NUM);
    }

    @Value("${PAGE_TOP_NUM}")
    private Integer PAGE_TOP_NUM;

    @Override
    public List<BookProduct> getBookTopList() {
        return bookProductMapper.getBookXlTopList(PAGE_TOP_NUM);
    }

    @Value("${PAGEHELPER_PAGE_SIZE}")
    private Integer PAGEHELPER_PAGE_SIZE;

    @Override
    public PageInfo<BookProduct> getBookList(Integer pageNo, String query, Integer bookClassId) {
        //构建条件
        BookProductExample example = new BookProductExample();
        BookProductExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isBlank(query)) {
            criteria.andBookMchLike("%" + query + "%");
        }
        if (bookClassId != null) {
            criteria.andFlbhEqualTo(bookClassId);
        }
        //分页处理
        PageHelper.startPage(pageNo, PAGEHELPER_PAGE_SIZE);
        List<BookProduct> bookProducts = bookProductMapper.selectByExample(example);
        //获取分页信息
        PageInfo<BookProduct> pageInfo = new PageInfo<>(bookProducts);

        return pageInfo;
    }

}
