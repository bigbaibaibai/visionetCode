package com.ssm.jedis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssm.entites.User;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class UserJedis {

	@Autowired
	private JedisPool jedisPool;

	public User getUserFromRedis(User user) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			// 查询redis数据库中是否有该用户数据
			Map<String, String> userRedis = jedis.hgetAll("userName" + user.getUserName());
			if (!userRedis.isEmpty()) {
				String id = userRedis.get("id");
				String userName = userRedis.get("userName");
				String passWord = userRedis.get("passWord");
				String phoneNumber = userRedis.get("phoneNumber");
				String email = userRedis.get("email");
				String nickName = userRedis.get("nickName");
				return new User(Integer.valueOf(id), userName, passWord, phoneNumber, email, nickName);
			}
			return null;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	public void addUserToRedis(User user) {

		if (user == null) {
			return;
		}
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Map<String, String> hash = new HashMap<String, String>();
			hash.put("id", String.valueOf(user.getId()));
			hash.put("userName", user.getUserName());
			hash.put("passWord", user.getPassWord());
			hash.put("email", user.getEmail());
			if (user.getPhoneNumber() != null) {
				hash.put("phoneNumber", user.getPhoneNumber());
			}
			if (user.getNickName() != null) {
				hash.put("nickName", user.getNickName());
			}
			jedis.hmset("userName" + user.getUserName(), hash);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}
}
