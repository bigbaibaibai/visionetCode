package xyz.thishome.yuelitao_book.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.thishome.yuelitao_book.pojo.BookClass;
import xyz.thishome.yuelitao_book.pojo.BookProduct;
import xyz.thishome.yuelitao_book.service.BookService;
import xyz.thishome.yuelitao_book.util.BookMsg;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    //根据分类分页获取20本图书
    @GetMapping("/getListForClass")
    public BookMsg getListForClass(@RequestParam("pageNo") Integer pageNo,
                                   @RequestParam(value = "query", required = false) String query,
                                   @RequestParam(value = "bookClassId", required = false) Integer bookClassId,
                                   HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //查询图书列表
        PageInfo<BookProduct> bookList = bookService.getBookList(pageNo, query, bookClassId);

        //返回图书列表
        return BookMsg.success(bookList);
    }

    //获取热门图书8本
    @GetMapping("/getListHot")
    public BookMsg getListHot(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        List<BookProduct> bookHot = bookService.getBookHot();
        return BookMsg.success(bookHot);
    }

    //获取销量前十的图书列表
    @GetMapping("/getListTop10")
    public BookMsg getListTop10(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        List<BookProduct> bookTopList = bookService.getBookTopList();
        return BookMsg.success(bookTopList);
    }

    //获取所有图书分类
    @GetMapping("/getBookClass")
    public BookMsg getBookClass(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        List<BookClass> bookClassList = bookService.getBookClassList();
        return BookMsg.success(bookClassList);
    }

    //根据id获取图书
    @GetMapping("/getBookForId/{bookId}")
    public BookMsg getBookForId(@PathVariable("bookId") Integer bookId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        BookProduct bookForId = bookService.getBookForId(bookId);
        return BookMsg.success(bookForId);
    }


}
