package com.mysql.module;

import java.io.Serializable;

/**
 * 模型=数据库有几张表
 * 
 * @author Administrator
 *
 */
public class Admin implements Serializable {
	private int id;
	private String NAME;
	private String phone;
	private String username;
	private String password;
	private static final long serialVersionUID = -5809782578272943999L;

	public Admin(int id, String nAME, String phone, String username, String password) {
		super();
		this.id = id;
		NAME = nAME;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}

	public Admin(String name2, String phone2, String username2, String password2) {
		// TODO Auto-generated constructor stub
		super();
		NAME = name2;
		this.phone = phone2;
		this.username = username2;
		this.password = password2;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", NAME=" + NAME + ", phone=" + phone + ", username=" + username + ", password="
				+ password + "]";
	}

}
