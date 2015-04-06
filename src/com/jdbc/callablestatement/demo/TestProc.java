package com.jdbc.callablestatement.demo;

import java.sql.*;

import com.jdbc.util.DBUtilFactory;
public class TestProc {
private static Connection conn=null;

/**
 * 
 * 方法: main <br>
 * 描述: 对储存过程进行调用
 * 展示储存过程调用方式，其实，都是先申明，在赋值，然后在执行这么一个套路，只是储存过程执行前需要指定输出参数。 <br>
 * 作者: xiaoxiaolan <br>
 * 时间: 2015-4-6 上午11:53:26
 * @param args
 * @throws Exception
 */
	public static void main(String[] args) throws Exception {
		CallableStatement cstmt=null;
		
		
		conn=DBUtilFactory.getFactory();
		
		 cstmt = conn.prepareCall("{call p(?, ?, ?, ?)}");
		//把第三和第四个参数设置为输出参数，类型为int.
		cstmt.registerOutParameter(3, Types.INTEGER);
		cstmt.registerOutParameter(4, Types.INTEGER);
		//给参数赋值。
		cstmt.setInt(1, 3);
		cstmt.setInt(2, 4);
		cstmt.setInt(4, 5);
		//执行这个储存过程。
		cstmt.execute();
		//打印第三、四个元素的值
		System.out.println(cstmt.getInt(3));
		System.out.println(cstmt.getInt(4));
		cstmt.close();
		conn.close();
	}

}
