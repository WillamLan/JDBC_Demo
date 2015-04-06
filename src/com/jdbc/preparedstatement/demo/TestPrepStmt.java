package com.jdbc.preparedstatement.demo;

import java.sql.*;

import com.jdbc.util.DBUtilFactory;
/**
 * 
 * 类: TestPrepStmt <br>
 * 描述: 使用问好占位符来占位，灵活指定SQL语句中的变量
 * 尽量的使用preparedstatement来对要执行的SQL语句进行预申明 <br>
 * 作者: xiaoxiaolan <br>
 * 时间: 2015-4-6 上午11:24:27
 */

public class TestPrepStmt {

	private static Connection conn=null;

	public static void main(String[] args) {
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
		
		PreparedStatement pstmt = null;
		try {
			conn=DBUtilFactory.getFactory();
			
			pstmt = conn.prepareStatement("insert into unit values (?, ?, ?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, description);
			pstmt.setString(4, parentId);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if(conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
