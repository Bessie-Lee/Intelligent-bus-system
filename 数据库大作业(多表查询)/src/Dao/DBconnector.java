package Dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnector {
	private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver"; // 驱动串
	private static final String DBURL = "jdbc:mysql://localhost:3306/busmanage";// 连接URL
	private static final String DBUSER = "root"; // 用户名
	private static final String DBPASSWORD = "123456"; // 密码
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DBDRIVER);//加载驱动
			//获取连接
			conn = (Connection) DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("驱动加载异常");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("连接异常");
		}
		return conn;
	}

}
