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
	 * ��ȡ��ѡͼ�飬״̬Ϊ2��ͼ��
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getChoicenessBook", method = RequestMethod.GET)
	public Msg getChoicenessBook() {
		List<Book> coicenessBooks = bookService.getCoicenessBooks();
		return Msg.SUCCESS().add("coicenessBooks", coicenessBooks);
	}
	
	/**
	 * ��ȡ����ͼ�飬״̬Ϊ2��ͼ��
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getNewBook", method = RequestMethod.GET)
	public Msg getNewBook() {
		List<Book> newBooks = bookService.getNewBooks();
		return Msg.SUCCESS().add("coicenessBooks", newBooks);
	}
	
	/**
	 * ��ȡ����ͼ�飬״̬Ϊ2��ͼ��
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getSpecialPriceBook", method = RequestMethod.GET)
	public Msg getSpecialPriceBook() {
		List<Book> newBooks = bookService.getSpecialPriceBooks();
		return Msg.SUCCESS().add("coicenessBooks", newBooks);
	}
	

}
