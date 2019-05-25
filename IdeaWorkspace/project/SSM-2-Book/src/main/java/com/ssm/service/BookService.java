package com.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.BookMapper;
import com.ssm.entites.Book;
import com.ssm.entites.BookExample;
import com.ssm.entites.BookExample.Criteria;

@Service
public class BookService {

	@Autowired
	private BookMapper bookMapper;

	/**
	 * 返回精选书
	 * 
	 * @return
	 */
	public List<Book> getCoicenessBooks() {
		return getStatusBook(2);
	}

	/**
	 * 返回最新书
	 * 
	 * @return
	 */
	public List<Book> getNewBooks() {
		return getStatusBook(3);
	}

	private List<Book> getStatusBook(Integer statusCode) {
		// 如果状态码为空则返回所有图书
		if (statusCode == null) {
			return bookMapper.selectByExample(null);
		}
		// 根据图书状态码返回图书列表
		BookExample example = new BookExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusCodeEqualTo(statusCode);
		List<Book> books = bookMapper.selectByExampleWithBLOBs(example);
		return books;
	}

	/**
	 * 返回特价书
	 * 
	 * @return
	 */
	public List<Book> getSpecialPriceBooks() {
		return getStatusBook(4);
	}

	/**
	 * 返回所有图书
	 * 
	 * @return
	 */
	public List<Book> getAllBooks() {
		return getStatusBook(null);
	}

}
