package com.jdbc.updatableresultset.demo;

import java.sql.*;

import com.jdbc.util.DBUtilFactory;
/**
 * 
 * 类: TestUpdataRs <br>
 * 描述: 把结果集设置为可更新的，则我们可以对结果集进行操作，然后结果集会自动把更新的状态同步到数据库。相当于改内存中的东西。 <br>
 * 作者: xiaoxiaolan <br>
 * 时间: 2015-4-6 下午1:55:45
 */
public class TestUpdataRs {
    private static Connection conn=null;

	public static void main(String args[]) throws Exception{
	try{
	        conn=DBUtilFactory.getFactory();
	        
	    Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	    
	    ResultSet rs=stmt.executeQuery("select * from emp");
	    
	    rs.next();
	    //更新一行数据
	    rs.updateString("name","AAAA");
	    rs.updateRow();

	    //插入新行
	    rs.moveToInsertRow();
	    rs.updateInt(1, 9999);
	    rs.updateString("name","AAAA");
	    rs.updateInt("sal", 99);
	    rs.insertRow();
	    //将光标移动到新建的行
	    rs.moveToCurrentRow();

	    //取消更新
	    rs.absolute(5);
	    rs.deleteRow();

	    //取消更新
	    //rs.cancelRowUpdates();

	  }catch(SQLException e){
	    e.printStackTrace();
	  }
    }
}
