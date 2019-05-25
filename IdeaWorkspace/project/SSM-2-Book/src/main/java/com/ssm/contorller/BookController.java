package com.ssm.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssm.bean.Msg;
import com.ssm.entites.Book;
import com.ssm.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	/**
	 * 获取精选图书，状态为2的图书
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getChoicenessBook", method = RequestMethod.GET)
	public Msg getChoicenessBook() {
		List<Book> coicenessBooks = bookService.getCoicenessBooks();
		return Msg.SUCCESS().add("coicenessBooks", coicenessBooks);
	}
	
	/**
	 * 获取最新图书，状态为2的图书
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getNewBook", method = RequestMethod.GET)
	public Msg getNewBook() {
		List<Book> newBooks = bookService.getNewBooks();
		return Msg.SUCCESS().add("coicenessBooks", newBooks);
	}
	
	/**
	 * 获取最新图书，状态为2的图书
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getSpecialPriceBook", method = RequestMethod.GET)
	public Msg getSpecialPriceBook() {
		List<Book> newBooks = bookService.getSpecialPriceBooks();
		return Msg.SUCCESS().add("coicenessBooks", newBooks);
	}
	

}
