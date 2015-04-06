/**  
 * 工程: jdbcdemo <br>
 * 标题: DBUtilFactory.java <br>
 * 描述: TODO <br>
 * 作者: xiaoxiaolan <br>
 * 时间: 2015-4-6 下午2:28:39 <br>
 * 版权: Copyright 2015 1000CHI Software Technology Co.,Ltd. <br>
 * All rights reserved.
 *
 */

package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 类: DBUtilFactory <br>
 * 描述: 实现数据库连接的工厂类 <br>
 * 作者: xiaoxiaolan <br>
 * 时间: 2015-4-6 下午2:28:39
 */
public class DBUtilFactory {
	private static String username = "xxl";
	private static String password = "shenglan520";
	private static String url = "jdbc:mysql://learndemodb.mysql.rds.aliyuncs.com:3306/hrproject?characterEncoding=UTF-8";
	private static Connection conn = null;

	public static Connection getFactory() {
		try {
			Class.forName("com.mysql.jdbc.Driver");//实例化数据库连接驱动
			conn = DriverManager.getConnection(url, username, password);//建立（获得）与具体的数据库连接
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
