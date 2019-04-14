package com.dao;

import com.db.DBHelper;
import com.bean.ApplyBean;


import java.util.*;
import java.sql.*;

public class ApplyDao {
	
	//鑾峰彇鍒楄〃
	public List<ApplyBean> GetList(String strwhere,String strorder){
		String sql="select * from app ";
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
		List<ApplyBean> list=new ArrayList<ApplyBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				ApplyBean cnbean=new ApplyBean();
				cnbean.setApp_id(rs.getInt("app_id"));
				cnbean.setApp_reason(rs.getString("app_reason"));
				cnbean.setSeq_name(rs.getString("seq_name"));
				cnbean.setSeq_type(rs.getString("seq_type"));
				cnbean.setSeq_model(rs.getString("seq_model"));
				cnbean.setSeq_num(rs.getString("seq_num"));
				cnbean.setApp_date(rs.getString("app_date"));
				cnbean.setDet_inf(rs.getString("det_inf"));
				cnbean.setIf_agree(rs.getString("if_agree"));
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
	
	//鑾峰彇鎸囧畾ID鐨勫疄浣揃ean
	public ApplyBean GetBean(int id){
		String sql="select * from app where app_id="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		ApplyBean cnbean=new ApplyBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setApp_id(rs.getInt("app_id"));
				cnbean.setApp_reason(rs.getString("app_reason"));
				cnbean.setSeq_name(rs.getString("seq_name"));
				cnbean.setSeq_type(rs.getString("seq_type"));
				cnbean.setSeq_model(rs.getString("seq_model"));
				cnbean.setSeq_num(rs.getString("seq_num"));
				cnbean.setApp_date(rs.getString("app_date"));
				cnbean.setDet_inf(rs.getString("set_inf"));
				cnbean.setIf_agree(rs.getString("if_agree"));
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
	
	//鑾峰彇鎸囧畾Equipm_Name鐨凟quipment_ID
	public ApplyBean GetEqBean(String name){
		String sql="select * from app where seq_name='"+name+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		ApplyBean cnbean=new ApplyBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setApp_id(rs.getInt("app_id"));
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
	
	//娣诲姞
	public void Add(ApplyBean cnbean){
		String sql="insert into app (";
		sql+="app_reason,seq_name,seq_type,seq_model,seq_num,app_date,det_inf";
		sql+=") values(";
		sql+="'"+cnbean.getApp_reason()+"','"+cnbean.getSeq_name()+"','"+cnbean.getSeq_type()+"','"+cnbean.getSeq_model()+"','"+cnbean.getSeq_num()+"','"+cnbean.getApp_date()+"','"+cnbean.getDet_inf()+"'";
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
		//鍒犻櫎
	public void Delete(String strwhere){
		String sql="delete from app where ";
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

	
	//鍒ゆ柇鏄惁绌哄��
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//娴嬭瘯
	public static void main(String[] args) {
		System.out.println("");
	}
	
}

