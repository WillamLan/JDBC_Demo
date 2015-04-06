/**  
 * 工程: jdbcdemo <br>
 * 标题: TestPerfectJDBC.java <br>
 * 描述: TODO <br>
 * 作者: xiaoxiaolan <br>
 * 时间: 2015-4-4 下午5:30:59 <br>
 * 版权: Copyright 2015 1000CHI Software Technology Co.,Ltd. <br>
 * All rights reserved.
 *
 */

package com.jdbc.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.util.DBUtilFactory;

/**
 * 类: TestPerfectJDBC <br>
 * 描述: 进行相应的异常处理的JDBC类 <br>
 * 作者: xiaoxiaolan <br>
 * 时间: 2015-4-4 下午5:30:59
 */
public class TestHandlerExceptionJDBC {

	private static Connection conn=null;

	/** 
	 * 方法: main <br>
	 * 描述: TODO <br>
	 * 作者: xiaoxiaolan <br>
	 * 时间: 2015-4-4 下午5:30:59
	 * @param args
	 */
	public static void main(String[] args) {
        Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=DBUtilFactory.getFactory();
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from unit");
			while(rs.next()){
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("parentId"));
				System.out.println(rs.getInt("parentId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
        
        try {
        	if(rs !=null){
        	rs.close();
        	rs=null;
        	}
        	if(stmt !=null){
        		stmt.close();
        		stmt=null;
        	}
            if(conn !=null){
			conn.close();
			 conn=null;
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		}
	}
