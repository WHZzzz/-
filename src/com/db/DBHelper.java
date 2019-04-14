package com.db;

import java.sql.*;

public class DBHelper {	
	private String dbUrl="jdbc:mysql://localhost:3306/lab";
	private String dbUser="root";
	private String dbPassword="root";
	private String jdbcName="com.mysql.jdbc.Driver";
	
	//杩炴帴鏁版嵁搴�
	public Connection getConn(){
		Connection conn = null;
		try{
			Class.forName(jdbcName);
		}
		catch(Exception e){}
		try{
			conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
		}
		catch(SQLException ex){}
		return conn;		
	}
	
//  娴嬭瘯
	public static void main(String[] args)
	{
		System.out.println(new DBHelper().getConn());
		
	}
	
}
