/**  
 * 工程: jdbcdemo <br>
 * 标题: TextDML2.java <br>
 * 描述: TODO <br>
 * 作者: xiaoxiaolan <br>
 * 时间: 2015-4-4 下午6:03:52 <br>
 * 版权: Copyright 2015 1000CHI Software Technology Co.,Ltd. <br>
 * All rights reserved.
 *
 */

package com.jdbc.dml.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.util.DBUtilFactory;

/**
 * 类: TextDML2 <br>
 * 描述: TODO <br>
 * 作者: xiaoxiaolan <br>
 * 时间: 2015-4-4 下午6:03:52
 */
public class TextDML2 {

	private static Connection conn=null;

	/** 
	 * 方法: main <br>
	 * 描述: 通过传参的方式进行新增记录 <br>
	 * 作者: xiaoxiaolan <br>
	 * 时间: 2015-4-4 下午6:03:52
	 * @param args
	 */
	public static void main(String[] args) {

        Statement stmt=null;
		
		if(args.length != 4) {
			System.out.println("Parameter Error! Please Input Again!");
			System.exit(-1);
		}
		
		int id = 0;
		
		try {
			id = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.out.println("Parameter Error! id should be Number Format!");
			System.exit(-1);
		}
		
		String name = args[1];
		String description = args[2];
		String parentId=args[3];
		
		try {
			
			conn=DBUtilFactory.getFactory();
			
			stmt = conn.createStatement();
			String sql="insert into unit values (" + id + ",'" + name + "','" + description +"','" + parentId+ "')";
			stmt.executeUpdate(sql);
			//把构建出来的SQL语句打印出来放到MySQL客户端软件中的运行SQL命令行中来测试。
			System.out.println(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
        
        try {
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
