package com.jdbc.scroll.demo;

import java.sql.*;

import com.jdbc.util.DBUtilFactory;
/**
 * 
 * 类: TestScroll <br>
 * 描述: Movable ResultSet
 * 设置结果集为可滚动结果集 <br>
 * 作者: xiaoxiaolan <br>
 * 时间: 2015-4-6 下午1:28:28
 */

public class TestScroll {
	private static Connection conn=null;

	public static void main(String args[]) throws Exception {
		try {
	        conn=DBUtilFactory.getFactory();
	        //只要对结果集设置以下两个静态常量，结果集就可以滚动。不过为了保险起见，能只用next就能实现的就不要使用可滚动结果集。
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt
					.executeQuery("select * from emp order by sal");
			rs.next();//获取下一条。
			System.out.println(rs.getInt(1));
			rs.last();//获取最后一条
			System.out.println(rs.getString(1));
			System.out.println(rs.isLast());//判断是否是最后一条记录
			System.out.println(rs.isAfterLast());
			System.out.println(rs.getRow());//获取结果集中记录的条数。
			rs.previous();//获取当前记录的前一条记录。
			System.out.println(rs.getString(1));
			rs.absolute(6);//绝对定位到第六条记录
			System.out.println(rs.getString(1));//以字符串的方式获取当前记录的第一个字段的值。
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
