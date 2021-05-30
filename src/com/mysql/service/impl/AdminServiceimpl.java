package com.mysql.service.impl;

import com.mysql.dao.AdminDao;
import com.mysql.dao.impl.AdminDaoimpl;
import com.mysql.module.Admin;
import com.mysql.service.AdminService;

public class AdminServiceimpl implements AdminService {
	AdminDao dao = new AdminDaoimpl();

	@Override
	public Admin login(String username) {
		// TODO Auto-generated method stub
		return dao.login(username);
	}

	@Override
	public boolean validataUserName(String username) {
		// TODO Auto-generated method stub
		return dao.validataUserName(username);
	}

	@Override
	public int register(Admin admin) {
		// TODO Auto-generated method stub
		return dao.register(admin);
	}

	@Override
	public int updataAdmin(Admin ad) {
		// TODO Auto-generated method stub
		return dao.updataAdmin(ad);
	}

}
