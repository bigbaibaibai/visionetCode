package com.ssm.entites;

import java.util.List;

import javax.validation.constraints.Pattern;

public class User {
	private Integer id;
	@Pattern(regexp = "^([a-zA-Z0-9_-]{3,16})$", message = "用户名英文或数字3-16位！")
	private String userName;

	@Pattern(regexp = "^[\\w_-]{1,16}$", message = "密码格式不正确！")
	private String passWord;

	@Pattern(regexp = "^1[3|4|5|7|8|9][0-9]{9}$", message = "手机号码格式不正确！")
	private String phoneNumber;

	@Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$", message = "邮箱格式不正确！")
	private String email;

	@Pattern(regexp = "^[\\w\\u4e00-\\u9fa5]{1,12}$", message = "昵称不合法！")
	private String nickName;

	private CardItem cardItem;

	private List<Trade> trades;

	public User(Integer id, @Pattern(regexp = "^([a-zA-Z0-9_-]{3,16})$", message = "用户名英文或数字3-16位！") String userName,
			@Pattern(regexp = "^[\\w_-]{1,16}$", message = "密码格式不正确！") String passWord,
			@Pattern(regexp = "^1[3|4|5|7|8|9][0-9]{9}$", message = "手机号码格式不正确！") String phoneNumber,
			@Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$", message = "邮箱格式不正确！") String email,
			@Pattern(regexp = "^[\\w\\u4e00-\\u9fa5]{1,12}$", message = "昵称不合法！") String nickName) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.nickName = nickName;
	}

	public User(@Pattern(regexp = "^([a-zA-Z0-9_-]{3,16})$", message = "用户名英文或数字3-16位！") String userName,
			@Pattern(regexp = "^[\\w_-]{1,16}$", message = "密码格式不正确！") String passWord,
			@Pattern(regexp = "^1[3|4|5|7|8|9][0-9]{9}$", message = "手机号码格式不正确！") String phoneNumber,
			@Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$", message = "邮箱格式不正确！") String email,
			@Pattern(regexp = "^[\\w\\u4e00-\\u9fa5]{1,12}$", message = "昵称不合法！") String nickName) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.nickName = nickName;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", nickName=" + nickName + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public CardItem getCardItem() {
		return cardItem;
	}

	public void setCardItem(CardItem cardItem) {
		this.cardItem = cardItem;
	}

	public List<Trade> getTrades() {
		return trades;
	}

	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

}