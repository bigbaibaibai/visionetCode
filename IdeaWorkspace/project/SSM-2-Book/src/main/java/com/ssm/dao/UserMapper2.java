package com.ssm.dao;

import java.util.List;

import com.ssm.entites.User;

public interface UserMapper2 {
	/**
	 * ����User������ӵ����ݿ���
	 * 
	 * @param user
	 */
	void addUser(User user);

	/**
	 * ��ȡUser����
	 * 
	 * @param user
	 * @return
	 */
	List<User> getUserAll();

	/**
	 * ����һ��User���󣬻�ȡUser
	 * 
	 * @param user
	 * @return
	 */
	User getUser(User user);
}
