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
	 * ��¼������Ӧ����
	 * 
	 * @param session
	 * @param user
	 * @return
	 */
	@RequestMapping("/login")
	public Msg login(HttpSession session, @Valid User user, BindingResult result) {
		// ����������ʽ���󣬻�ȡ����ļ��ϣ����ص�һ����ʽ�������Ϣ
		List<FieldError> fieldErrors = result.getFieldErrors();
		if (fieldErrors.size() > 0) {
			return Msg.FAIL().changeMsg(fieldErrors.get(0).getDefaultMessage());
		}

		String userName = user.getUserName();
		String passWord = user.getPassWord();

		// �û���������Ϊ��
		if (userName == null || passWord == null || userName.trim().equals("") || passWord.trim().equals("")) {
			return Msg.FAIL().changeMsg("�û��������벻��Ϊ�գ�");
		}
		User userSelect = userService.getUser(user);
		if (userSelect != null && user.getPassWord().equals(userSelect.getPassWord())) {
			session.setAttribute("user", userSelect);
			return Msg.SUCCESS().changeMsg("��¼�ɹ���");
		}
		return Msg.FAIL().changeMsg("�û��������벻ƥ�䣡");
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/addUser")
	public Msg addUser(HttpSession session, @Valid User user, BindingResult result) {
		// ����������ʽ���󣬻�ȡ����ļ��ϣ����ص�һ����ʽ�������Ϣ
		List<FieldError> fieldErrors = result.getFieldErrors();
		if (fieldErrors.size() > 0) {
			return Msg.FAIL().changeMsg(fieldErrors.get(0).getDefaultMessage());
		}

		String userName = user.getUserName();
		String passWord = user.getPassWord();

		// �û���������Ϊ��
		if (userName == null || passWord == null || userName.trim().equals("") || passWord.trim().equals("")) {
			return Msg.FAIL().changeMsg("�û��������벻��Ϊ�գ�");
		}
		if (userService.getUser(user) == null) {
			userService.addUser(user);
			session.setAttribute("user", user);
			return Msg.SUCCESS().changeMsg("ע��ɹ���");
		}

		return Msg.FAIL().changeMsg("�û����Ѵ��ڣ�");
	}

}
