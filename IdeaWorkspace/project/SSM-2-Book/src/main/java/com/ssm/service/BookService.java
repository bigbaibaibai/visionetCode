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
	 * ���ؾ�ѡ��
	 * 
	 * @return
	 */
	public List<Book> getCoicenessBooks() {
		return getStatusBook(2);
	}

	/**
	 * ����������
	 * 
	 * @return
	 */
	public List<Book> getNewBooks() {
		return getStatusBook(3);
	}

	private List<Book> getStatusBook(Integer statusCode) {
		// ���״̬��Ϊ���򷵻�����ͼ��
		if (statusCode == null) {
			return bookMapper.selectByExample(null);
		}
		// ����ͼ��״̬�뷵��ͼ���б�
		BookExample example = new BookExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusCodeEqualTo(statusCode);
		List<Book> books = bookMapper.selectByExampleWithBLOBs(example);
		return books;
	}

	/**
	 * �����ؼ���
	 * 
	 * @return
	 */
	public List<Book> getSpecialPriceBooks() {
		return getStatusBook(4);
	}

	/**
	 * ��������ͼ��
	 * 
	 * @return
	 */
	public List<Book> getAllBooks() {
		return getStatusBook(null);
	}

}
