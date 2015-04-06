package com.jdbc.batch.demo;

import java.sql.*;

import com.jdbc.util.DBUtilFactory;
public class TestBatch {
private static Connection conn=null;

/**
 * 
 * 方法: main <br>
 * 描述: 使用批处理省去了每次操作记录时都要去申明一个SQL语句的重复操作。<br>
 * 作者: xiaoxiaolan <br>
 * 时间: 2015-4-6 下午12:12:11
 * @param args
 * @throws Exception
 */

	public static void main(String[] args) throws Exception {
        conn=DBUtilFactory.getFactory();
		/*
		Statement stmt = conn.createStatement();
		stmt.addBatch("insert into dept2 values (1, 'xiaolan', '很优秀！')");
		stmt.addBatch("insert into dept2 values (2, 'xiaocao', '很优秀！')");
		stmt.addBatch("insert into dept2 values (3, 'xiaocan', '良好需要加油！')");
		stmt.executeBatch();
		stmt.close();
		*/
		
		PreparedStatement ps = conn.prepareStatement("insert into student values (?, ?, ?)");
		ps.setInt(1, 1);
		ps.setString(2, "xiaolan");
		ps.setString(3, "很优秀！");
		ps.addBatch();
		
		ps.setInt(1, 2);
		ps.setString(2, "xiaocao");
		ps.setString(3, "很优秀！");
		ps.addBatch();
		
		ps.setInt(1, 3);
		ps.setString(2, "xiaocan");
		ps.setString(3, "良好需要加油！");
		ps.addBatch();
		
		ps.executeBatch();
		ps.close();
		
		conn.close();

	}

}
