package com.dao;
import com.db.DBHelper;
import com.bean.UserBean;

import java.sql.*;

public class UserDao {

	//验证登录
	public String CheckLogin(String username, String password){
		String id = null;
		String sql="select * from user where user_name='"+username+"' and user_pass='"+password+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				id = rs.getString("user_id");
			}
		}
		catch(SQLException ex){}
		return id;
	}
	//验证密码
	public boolean CheckPassword(String id, String password){
		boolean ps = false;
		String sql="select * from user where user_id='"+id+"' and user_pass='"+password+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				ps=true;
			}
		}
		catch(SQLException ex){}
		return ps;
	}
	
	//根据指定设备名查找实体BEAN
		public UserBean GetBean(int id){
			String sql="select * from User where user_id='"+id+"'";
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			UserBean cnbean=new UserBean();
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				
				while(rs.next()){
					cnbean.setuser_id(rs.getInt("user_id"));
					cnbean.setuser_name(rs.getString("user_name"));
					cnbean.setuser_pass(rs.getString("user_pass"));
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null)
						conn.close();
					if (stat != null)
						stat.close();
					if (rs != null)
						rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return cnbean;
		}
		//修改表信息
		public void Update(UserBean cnbean){
			String sql="update user set ";
			
			sql+="user_name='"+cnbean.getuser_name()+"',";
			sql+="user_pass='"+cnbean.getuser_pass()+"'";
			sql+=" where user_id="+cnbean.getuser_id()+"";
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			try{
				stat = conn.createStatement();
				
				stat.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null)
						conn.close();
					if (stat != null)
						stat.close();
					if (rs != null)
						rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
}
