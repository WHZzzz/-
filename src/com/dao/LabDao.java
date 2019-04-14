package com.dao;

import com.db.DBHelper;
import com.bean.LabBean;

import java.util.*;
import java.sql.*;

public class LabDao {
	
	//��ѯ����ʵ����
	public List<LabBean> GetList(String strwhere,String strorder){
		String sql="select * from lab";
		if(!(isInvalid(strwhere)))
		{
			sql+=" where "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<LabBean> list=new ArrayList<LabBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				LabBean cnbean=new LabBean();
				cnbean.setLab_ID(rs.getInt("Lab_ID"));
				cnbean.setLab_Name(rs.getString("Lab_Name"));
				cnbean.setLab_Introduction(rs.getString("Lab_Introduction"));
				list.add(cnbean);
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
		return list;
	}
	
	//����ʵ����ID��ѯʵ����
	public LabBean GetBean(int id){
		String sql="select * from Lab where Lab_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		LabBean cnbean=new LabBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setLab_ID(rs.getInt("Lab_ID"));
				cnbean.setLab_Name(rs.getString("Lab_Name"));
				cnbean.setLab_Introduction(rs.getString("Lab_Introduction"));
				
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
	
	//���ʵ����
	public void Add(LabBean cnbean){
		String sql="insert into Lab (";
		sql+="Lab_Name,Lab_Introduction";
		sql+=") values(";
		sql+="'"+cnbean.getLab_Name()+"','"+cnbean.getLab_Introduction()+"'";
		sql+=")";
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
	//�޸�ʵ������Ϣ
	public void Update(LabBean cnbean){
		String sql="update Lab set ";
		sql+="Lab_Name='"+cnbean.getLab_Name()+"',";
		sql+="Lab_Introduction='"+cnbean.getLab_Introduction()+"'";
		
		sql+=" where Lab_ID='"+cnbean.getLab_ID()+"'";
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
	//ɾ��ʵ����
	public void Delete(String strwhere){
		String sql="delete from Lab where ";
		sql+=strwhere;
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

	
	//�ж��Ƿ�Ϊ��
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//����
	public static void main(String[] args) {
		System.out.println("");
	}
	
}

