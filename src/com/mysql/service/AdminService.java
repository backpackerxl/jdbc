package com.mysql.service;

import com.mysql.module.Admin;

public interface AdminService {

	Admin login(String username);

	boolean validataUserName(String username);

	int register(Admin admin);

	int updataAdmin(Admin ad);

}
