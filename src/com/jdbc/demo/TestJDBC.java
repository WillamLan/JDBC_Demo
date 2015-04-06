/**  
 * 工程: jdbcdemo <br>
 * 标题: TestJDBC.java <br>
 * 描述: TODO <br>
 * 作者: xiaoxiaolan <br>
 * 时间: 2015-4-4 下午5:00:39 <br>
 * 版权: Copyright 2015 1000CHI Software Technology Co.,Ltd. <br>
 * All rights reserved.
 *
 */

package com.jdbc.demo;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;

import com.jdbc.util.DBUtilFactory;

/**
 * 类: TestJDBC <br>
 * 描述: 一个没有处理异常的JDBC测试类 <br>
 * 作者: xiaoxiaolan <br>
 * 时间: 2015-4-4 下午5:00:39
 */
public class TestJDBC {

	private static Connection conn=null;

	/** 
	 * 方法: main <br>
	 * 描述: 对数据库表中的记录进行简单的查询，测试数据库连通情况；，异常往外抛出，该方法未进行异常的具体处理。<br>
	 * 作者: xiaoxiaolan <br>
	 * 时间: 2015-4-4 下午5:00:40
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		conn=DBUtilFactory.getFactory();        
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from unit");
        while(rs.next()){
        	System.out.println(rs.getString("name"));
        	System.out.println(rs.getString("parentId"));
        	System.out.println(rs.getInt("parentId"));
        }
        rs.close();
        stmt.close();
        conn.close();
	}

}
