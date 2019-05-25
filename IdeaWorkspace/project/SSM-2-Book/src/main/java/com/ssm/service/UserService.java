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
	 * 检查用户名和密码是否匹配，-1用户名和密码不匹配 ，0用户名或密码为空，1登录成功
	 * 
	 * @param session
	 * @param user
	 * @return
	 */
	public User getUser(User user) {
		// 查看redis中是否有该数据
		User userSelect = userJedis.getUserFromRedis(user);
		// 如果redis不存在该用户，则从数据库中查找并存到redis中
		if (userSelect == null) {
			System.out.println("数据库中查询");
			// 获取查询数据库中是否有匹配的用户和密码
			UserExample userExample = new UserExample();
			Criteria criteria = userExample.createCriteria();
			criteria.andUserNameEqualTo(user.getUserName());
			criteria.andPassWordEqualTo(user.getPassWord());
			List<User> users = userMapper.selectByExample(userExample);
			userSelect = users.size() > 0 ? users.get(0) : null;
			// 如果没有找到user则返回-1
			if (userSelect == null) {
				// 用户名密码不匹配
				return null;
			}
			// 如果找到，存入redis缓存中
			userJedis.addUserToRedis(userSelect);
		} else {
			System.out.println("redis中查询");
		}
		// 查询成功
		return userSelect;
	}

	/**
	 * 返回-1，用户名已存在，返回1，注册成功！
	 * 
	 * @param session
	 * @param user
	 * @return
	 */
	public void addUser(User user) {
		userMapper.insert(user);
	}

}
