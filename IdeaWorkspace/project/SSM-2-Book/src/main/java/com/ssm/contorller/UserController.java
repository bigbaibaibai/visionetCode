package com.ssm.contorller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssm.bean.Msg;
import com.ssm.entites.User;
import com.ssm.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 登录请求响应函数
	 * 
	 * @param session
	 * @param user
	 * @return
	 */
	@RequestMapping("/login")
	public Msg login(HttpSession session, @Valid User user, BindingResult result) {
		// 如果有输入格式错误，获取错误的集合，返回第一个格式错误的信息
		List<FieldError> fieldErrors = result.getFieldErrors();
		if (fieldErrors.size() > 0) {
			return Msg.FAIL().changeMsg(fieldErrors.get(0).getDefaultMessage());
		}

		String userName = user.getUserName();
		String passWord = user.getPassWord();

		// 用户名或密码为空
		if (userName == null || passWord == null || userName.trim().equals("") || passWord.trim().equals("")) {
			return Msg.FAIL().changeMsg("用户名或密码不能为空！");
		}
		User userSelect = userService.getUser(user);
		if (userSelect != null && user.getPassWord().equals(userSelect.getPassWord())) {
			session.setAttribute("user", userSelect);
			return Msg.SUCCESS().changeMsg("登录成功！");
		}
		return Msg.FAIL().changeMsg("用户名和密码不匹配！");
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/addUser")
	public Msg addUser(HttpSession session, @Valid User user, BindingResult result) {
		// 如果有输入格式错误，获取错误的集合，返回第一个格式错误的信息
		List<FieldError> fieldErrors = result.getFieldErrors();
		if (fieldErrors.size() > 0) {
			return Msg.FAIL().changeMsg(fieldErrors.get(0).getDefaultMessage());
		}

		String userName = user.getUserName();
		String passWord = user.getPassWord();

		// 用户名或密码为空
		if (userName == null || passWord == null || userName.trim().equals("") || passWord.trim().equals("")) {
			return Msg.FAIL().changeMsg("用户名或密码不能为空！");
		}
		if (userService.getUser(user) == null) {
			userService.addUser(user);
			session.setAttribute("user", user);
			return Msg.SUCCESS().changeMsg("注册成功！");
		}

		return Msg.FAIL().changeMsg("用户名已存在！");
	}

}
