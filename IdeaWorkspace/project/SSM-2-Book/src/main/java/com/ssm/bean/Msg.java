package com.ssm.bean;

import java.util.HashMap;

//code=100�ɹ�
//code=200ʧ��
public class Msg {

	// ����һ��map��ֵ�ԣ����淵��json������
	private HashMap<String, Object> values = new HashMap<String, Object>();

	private String msg;
	private int code;

	public static Msg SUCCESS() {
		Msg msg = new Msg();
		msg.setCode(100);
		msg.setMsg("�����ɹ�");
		return msg;
	}

	public static Msg FAIL() {
		Msg msg = new Msg();
		msg.setCode(200);
		msg.setMsg("����ʧ��");
		return msg;
	}

	public Msg add(String key, Object value) {
		values.put(key, value);
		return this;
	}
	
	public Msg changeMsg(String msg) {
		setMsg(msg);
		return this;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public HashMap<String, Object> getValues() {
		return values;
	}

	public void setValues(HashMap<String, Object> values) {
		this.values = values;
	}

}
