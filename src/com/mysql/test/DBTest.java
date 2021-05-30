package com.mysql.test;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;
import com.mysql.util.DBUtilPro;

public class DBTest {
	@Test
	public void testConn() throws SQLException {
		Connection conn = DBUtilPro.getConnection();
		System.out.println(conn);
	}
}
