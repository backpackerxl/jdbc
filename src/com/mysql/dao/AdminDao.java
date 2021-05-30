package com.mysql.dao;

import com.mysql.module.Admin;

public interface AdminDao {

	Admin login(String username);

	boolean validataUserName(String username);

	int register(Admin admin);

	int updataAdmin(Admin ad);

}
