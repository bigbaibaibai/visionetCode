package com.ssm.dao;

import java.util.List;

import com.ssm.entites.User;

public interface UserMapper2 {
	/**
	 * 传入User对象，添加到数据库中
	 * 
	 * @param user
	 */
	void addUser(User user);

	/**
	 * 获取User集合
	 * 
	 * @param user
	 * @return
	 */
	List<User> getUserAll();

	/**
	 * 传入一个User对象，获取User
	 * 
	 * @param user
	 * @return
	 */
	User getUser(User user);
}
