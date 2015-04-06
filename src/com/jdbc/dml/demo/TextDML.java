/**  
 * 工程: jdbcdemo <br>
 * 标题: TextDML.java <br>
 * 描述: TODO <br>
 * 作者: xiaoxiaolan <br>
 * 时间: 2015-4-4 下午5:46:17 <br>
 * 版权: Copyright 2015 1000CHI Software Technology Co.,Ltd. <br>
 * All rights reserved.
 *
 */

package com.jdbc.dml.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.util.DBUtilFactory;

/**
 * 类: TextDML <br>
 * 描述: TODO <br>
 * 作者: xiaoxiaolan <br>
 * 时间: 2015-4-4 下午5:46:17
 */
public class TextDML {

	private static Connection conn=null;

	/** 
	 * 方法: main <br>
	 * 描述: 直接新增记录到数据库表中 <br>
	 * 作者: xiaoxiaolan <br>
	 * 时间: 2015-4-4 下午5:46:17
	 * @param args
	 */
	public static void main(String[] args) {

        Statement stmt=null;
		ResultSet rs=null;
		
		try {
			
			conn=DBUtilFactory.getFactory();
			
			stmt = conn.createStatement();
			String sql="insert into unit values (6,'宣传部','宣传理念和设计','1')";
			stmt.executeUpdate(sql);
		}catch (SQLException e) {
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
