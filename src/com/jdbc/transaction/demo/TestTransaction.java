package com.jdbc.transaction.demo;

import java.sql.*;

import com.jdbc.util.DBUtilFactory;
public class TestTransaction {

private static Connection conn=null;

/**
 * 
 * 方法: main <br>
 * 描述:运用事务处理：
 *  事务处理是为了保证数据的一致性：就是多个SQL语句要么同时成功执行，要么同时失败。
 * 设置conn.setAutoCommit(false),语句都执行完毕，并提交之后，恢复现场：conn.rollback(); conn.setAutoCommit(true)  <br>
 * 作者: xiaoxiaolan <br>
 * 时间: 2015-4-6 下午1:04:39
 * @param args
 */
	public static void main(String[] args) {
		Statement stmt = null;
		
		try {
	        conn=DBUtilFactory.getFactory();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.addBatch("insert into student values (1, 'xiaolan', '很优秀！')");
			stmt.addBatch("insert into student values (2, 'xiaocao', '很优秀！')");
			stmt.addBatch("insert into student values (3, 'xiaocan', '良好不过还需要加油！')");
			stmt.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e) {
			
			e.printStackTrace();
			
			try {
				if(conn != null)
				{//恢复现场
					conn.rollback();
					conn.setAutoCommit(true);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
