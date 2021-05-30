package com.mysql.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import com.alibaba.druid.util.StringUtils;
import com.mysql.dao.StudentDao;
import com.mysql.module.Student;
import com.mysql.util.DBUtilPro;

public class StudentDaoimpl implements StudentDao {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Vector> selectAllStudents(Student stu) {
		List<Vector> list = new ArrayList<>();
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			cn = DBUtilPro.getConnection();
			StringBuilder sql = new StringBuilder("select * from stu_tab where 1=1	");
			if (!StringUtils.isEmpty(stu.getName())) {
				sql.append("and name like '%" + stu.getName() + "%'");
			}
			System.out.println(sql.toString());
			ps = cn.prepareStatement(sql.toString());

			rs = ps.executeQuery();

			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt(1));
				v.add(rs.getString(2));
				v.add(rs.getString(3));
				v.add(rs.getString(4));
				v.add(rs.getString(5));
				v.add(rs.getString(6));
				list.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closePreparedStatement(ps);
			closeConnection(cn);
		}
		return list;
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
	public int deleteStudent(int result) {
		// TODO Auto-generated method stub
		Connection cn = null;
		PreparedStatement ps = null;
		int i = 0;
		try {
			cn = DBUtilPro.getConnection();
			ps = cn.prepareStatement("delete from stu_tab  where id =?");
			ps.setInt(1, result);
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
	public int updateStudent(Student stu) {
		Connection cn = null;
		PreparedStatement ps = null;
		int i = 0;
		try {
			cn = DBUtilPro.getConnection();
			ps = (PreparedStatement) cn.prepareStatement(
					"update stu_tab set  name= ? ,age = ? ,sex = ?, birthday = ? ,class = ? where id = ?");
			ps.setNString(1, stu.getName());
			ps.setNString(2, stu.getAge());
			ps.setNString(3, stu.getSex());
			ps.setNString(4, stu.getBirthday());
			ps.setNString(5, stu.getClass1());
			ps.setInt(6, stu.getId());
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
	public int register(Student stu) {
		int i = 0;
		Connection cn = null;
		PreparedStatement ps = null;
		try {
			cn = DBUtilPro.getConnection();
			ps = cn.prepareStatement("insert into stu_tab value(id,?,?,?,?,?)");
			ps.setNString(1, stu.getName());
			ps.setNString(2, stu.getAge());
			ps.setNString(3, stu.getSex());
			ps.setNString(4, stu.getBirthday());
			ps.setNString(5, stu.getClass1());
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
