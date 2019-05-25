package com.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.UserMapper;
import com.ssm.entites.User;
import com.ssm.entites.UserExample;
import com.ssm.entites.UserExample.Criteria;
import com.ssm.jedis.UserJedis;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserJedis userJedis;

	/**
	 * ����û����������Ƿ�ƥ�䣬-1�û��������벻ƥ�� ��0�û���������Ϊ�գ�1��¼�ɹ�
	 * 
	 * @param session
	 * @param user
	 * @return
	 */
	public User getUser(User user) {
		// �鿴redis���Ƿ��и�����
		User userSelect = userJedis.getUserFromRedis(user);
		// ���redis�����ڸ��û���������ݿ��в��Ҳ��浽redis��
		if (userSelect == null) {
			System.out.println("���ݿ��в�ѯ");
			// ��ȡ��ѯ���ݿ����Ƿ���ƥ����û�������
			UserExample userExample = new UserExample();
			Criteria criteria = userExample.createCriteria();
			criteria.andUserNameEqualTo(user.getUserName());
			criteria.andPassWordEqualTo(user.getPassWord());
			List<User> users = userMapper.selectByExample(userExample);
			userSelect = users.size() > 0 ? users.get(0) : null;
			// ���û���ҵ�user�򷵻�-1
			if (userSelect == null) {
				// �û������벻ƥ��
				return null;
			}
			// ����ҵ�������redis������
			userJedis.addUserToRedis(userSelect);
		} else {
			System.out.println("redis�в�ѯ");
		}
		// ��ѯ�ɹ�
		return userSelect;
	}

	/**
	 * ����-1���û����Ѵ��ڣ�����1��ע��ɹ���
	 * 
	 * @param session
	 * @param user
	 * @return
	 */
	public void addUser(User user) {
		userMapper.insert(user);
	}

}
