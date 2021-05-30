package com.mysql.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.activation.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mysql.jdbc.Connection;

public class DBUtilPro {
	private static javax.sql.DataSource dataSource;
	static {
		try {
			InputStream in = new FileInputStream("D:/Users/Administrator/eclipse-workspace/JDBC/lib/druid.properties");
			Properties p = new Properties();
			// 加载配置文件，获取四大参数，可以创建连接对象，通过数据源创建
			p.load(in);
			dataSource = DruidDataSourceFactory.createDataSource(p);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 返回数据源对象
	 * 
	 * @return
	 */
	public static DataSource getDataSource() {
		return (DataSource) dataSource;

	}

	/**
	 * 通过数据库连接池创建连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static java.sql.Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	/**
	 * 关闭结果集
	 * 
	 * @param rs
	 */
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭预处理对象
	 * 
	 * @param ps
	 */
	public static void closePreparedStatement(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭连接
	 * 
	 * @param cn
	 */
	public static void closeConnection(Connection cn) {
		if (cn != null) {
			try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 用于释放查询的资源
	 * 
	 * @param cn
	 * @param ps
	 * @param rs
	 */
	public static void close(Connection cn, PreparedStatement ps, ResultSet rs) {
		closeResultSet(rs);
		closePreparedStatement(ps);
		closeConnection(cn);
	}

	/**
	 * 用于释放增删改的资源
	 * 
	 * @param cn
	 * @param ps
	 */
	public static void close(Connection cn, PreparedStatement ps) {
		closePreparedStatement(ps);
		closeConnection(cn);
	}

}
