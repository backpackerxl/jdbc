package com.mysql.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.dao.AdminDao;
import com.mysql.module.Admin;
import com.mysql.util.DBUtilPro;

public class AdminDaoimpl implements AdminDao {

	@Override
	public Admin login(String username) {
		// TODO Auto-generated method stub
		Admin a = null;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			cn = DBUtilPro.getConnection();
			ps = cn.prepareStatement("select * from admin where username =?");
			ps.setNString(1, username);
			rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt(1);
				String NAME = rs.getString(2);
				String phone = rs.getString(3);
				String username1 = rs.getString(4);
				String password = rs.getString(5);
				a = new Admin(id, NAME, phone, username1, password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closePreparedStatement(ps);
			closeConnection(cn);
		}
		return a;
	}

	@Override
	public boolean validataUserName(String username) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			cn = DBUtilPro.getConnection();
			ps = cn.prepareStatement("select * from admin where username =?");
			ps.setNString(1, username);
			rs = ps.executeQuery();

			if (rs.next()) {
				// 用户名存在
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closePreparedStatement(ps);
			closeConnection(cn);
		}
		return flag;
	}

	private void closeConnection(Connection cn) {
		// TODO Auto-generated method stub
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void closePreparedStatement(PreparedStatement ps) {
		// TODO Auto-generated method stub
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void closeResultSet(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int register(Admin admin) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection cn = null;
		PreparedStatement ps = null;
		try {
			cn = DBUtilPro.getConnection();
			ps = cn.prepareStatement("insert into admin value(id,?,?,?,?)");
			ps.setNString(1, admin.getNAME());
			ps.setNString(2, admin.getPhone());
			ps.setNString(3, admin.getUsername());
			ps.setNString(4, admin.getPassword());
			i = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closePreparedStatement(ps);
			closeConnection(cn);
		}
		return i;
	}

	@Override
	public int updataAdmin(Admin ad) {
		Connection cn = null;
		PreparedStatement ps = null;
		int i = 0;
		try {
			cn = DBUtilPro.getConnection();
			ps = (PreparedStatement) cn
					.prepareStatement("update admin set  NAME= ? ,phone = ? ,username = ?, password = ?  where id = ?");
			ps.setNString(1, ad.getNAME());
			ps.setNString(2, ad.getPhone());
			ps.setNString(3, ad.getUsername());
			ps.setNString(4, ad.getPassword());
			ps.setInt(5, ad.getId());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closePreparedStatement(ps);
			closeConnection(cn);
		}
		return i;
	}
}
