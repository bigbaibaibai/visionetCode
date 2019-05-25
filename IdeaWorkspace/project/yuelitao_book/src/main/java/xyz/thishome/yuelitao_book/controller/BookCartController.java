package xyz.thishome.yuelitao_book.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.thishome.yuelitao_book.pojo.BookCartVo;
import xyz.thishome.yuelitao_book.pojo.BookProduct;
import xyz.thishome.yuelitao_book.pojo.BookProductVo;
import xyz.thishome.yuelitao_book.service.BookCartService;
import xyz.thishome.yuelitao_book.service.BookService;
import xyz.thishome.yuelitao_book.util.BookMsg;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/bookCart")
public class BookCartController {

    @Autowired
    private BookCartService bookCartService;

    //通过用户id获取用户购物车列表
    @GetMapping("/getCart/{userId}")
    public BookMsg getCart(@PathVariable("userId") Integer userId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        BookCartVo bookCart = bookCartService.getBookCart(userId);
        return BookMsg.success(bookCart);
    }

    //通过商品id，从购物车中删除一个商品
    @DeleteMapping("/delBook")
    public BookMsg delBookFromCart(@RequestParam("userId") Integer userId, @RequestParam("bookId") Integer bookId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //根据userId从redis获取购物车
        BookCartVo bookCart = bookCartService.getBookCart(userId);
        //根据bookId删除商品
        bookCart.removeBookOneForId(bookId);
        //把购物车存入redis中，key由userId生成
        bookCartService.setBookCart(userId, bookCart);
        return BookMsg.success();
    }


    //通过商品id，修改购物车中商品数量
    @PutMapping("/updateBookNum")
    public BookMsg updateBookNum(@RequestParam("userId") Integer userId, @RequestParam("bookId") Integer bookId,
                                 @RequestParam("num") Integer num, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //获取购物车
        BookCartVo bookCart = bookCartService.getBookCart(userId);
        //修改bookId对应的商品数量
        if (num <= 0) {
            bookCart.removeBookOneForId(bookId);
        }
        bookCart.findBookOneForId(bookId).setNumber(num);

        //把购物车存到redis中
        bookCartService.setBookCart(userId, bookCart);
        return BookMsg.success();
    }

    @Autowired
    private BookService bookService;

    //通过商品id，添加一个商品到购物车
    @PutMapping("/addBookOne")
    public BookMsg addBookOne(@RequestParam("userId") Integer userId, @RequestParam("bookId") Integer bookId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        //获取购物车
        BookCartVo bookCart = bookCartService.getBookCart(userId);
//        List<BookProductVo> bookProducts = bookCart.getBookProducts();
        BookProductVo bookProductVo = bookCart.findBookOneForId(bookId);
        //如果购物车中有该商品，则数量+1
        if (bookProductVo != null) {
            bookProductVo.setNumber(bookProductVo.getNumber() + 1);
        } else {
            // 如果购物车中没有该商品，获取该商品对象，存入购物车
            BookProduct bookForId = bookService.getBookForId(bookId);
            //构建新购物车中的购物项
            BookProductVo newBookProductVo = new BookProductVo();
            BeanUtils.copyProperties(bookForId, newBookProductVo);
            newBookProductVo.setNumber(1);
            //添加到购物车，键为用户ID
            bookCart.addToListForId(newBookProductVo);
        }
        //把购物车存到redis中
        bookCartService.setBookCart(userId, bookCart);
        return BookMsg.success();
    }

}
