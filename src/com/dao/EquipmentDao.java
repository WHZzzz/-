package com.dao;

import com.db.DBHelper;
import com.bean.EquipmentBean;

import java.util.*;
import java.sql.*;

public class EquipmentDao {
	
	//鑾峰彇鍒楄〃
	public List<EquipmentBean> GetList(String strwhere,String strorder){
		String sql="select * from Equipment,Lab where Equipment_LabID=Lab_ID";
		if(!(isInvalid(strwhere)))
		{
			sql+=" and "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<EquipmentBean> list=new ArrayList<EquipmentBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				EquipmentBean cnbean=new EquipmentBean();
				cnbean.setEquipment_ID(rs.getInt("Equipment_ID"));
				cnbean.setEquipment_LabID(rs.getInt("Equipment_LabID"));
				cnbean.setEquipment_Name(rs.getString("Equipment_Name"));
				cnbean.setEquipment_Type(rs.getString("Equipment_Type"));
				cnbean.setEquipment_Number(rs.getString("Equipment_Number"));
				cnbean.setEquipment_Model(rs.getString("Equipment_Model"));
				cnbean.setEquipment_Fac(rs.getString("Equipment_Fac"));
				cnbean.setEquipment_Price(rs.getString("Equipment_Price"));
				cnbean.setEquipment_Bdate(rs.getString("Equipment_Bdate"));
				cnbean.setEquipment_Operator(rs.getString("Equipment_Operator"));

				cnbean.setLab_Name(rs.getString("Lab_Name"));
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
	public EquipmentBean GetBean(int id){
		String sql="select * from Equipment,Lab where Equipment_LabID=Lab_ID and Equipment_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		EquipmentBean cnbean=new EquipmentBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setEquipment_ID(rs.getInt("Equipment_ID"));
				cnbean.setEquipment_LabID(rs.getInt("Equipment_LabID"));
				cnbean.setEquipment_Name(rs.getString("Equipment_Name"));
				cnbean.setEquipment_Type(rs.getString("Equipment_Type"));
				cnbean.setEquipment_Number(rs.getString("Equipment_Number"));
				cnbean.setEquipment_Model(rs.getString("Equipment_Model"));
				cnbean.setEquipment_Fac(rs.getString("Equipment_Fac"));
				cnbean.setEquipment_Price(rs.getString("Equipment_Price"));
				cnbean.setEquipment_Bdate(rs.getString("Equipment_Bdate"));
				cnbean.setEquipment_Operator(rs.getString("Equipment_Operator"));

				cnbean.setLab_Name(rs.getString("Lab_Name"));
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
	
	//鑾峰彇鎸囧畾Equipment_Name鐨凟quipment_ID
	public EquipmentBean GetEqBean(String name){
		String sql="select * from Equipment where Equipment_Name='"+name+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		EquipmentBean cnbean=new EquipmentBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setEquipment_ID(rs.getInt("Equipment_ID"));
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
	public void Add(EquipmentBean cnbean){
		String sql="insert into Equipment (";
		sql+="Equipment_LabID,Equipment_Name,Equipment_Type,Equipment_Number,Equipment_Model,Equipment_Fac,Equipment_Price,Equipment_Bdate,Equipment_Operator";
		sql+=") values(";
		sql+="'"+cnbean.getEquipment_LabID()+"','"+cnbean.getEquipment_Name()+"','"+cnbean.getEquipment_Type()+"','"+cnbean.getEquipment_Number()+"','"+cnbean.getEquipment_Model()+"','"+cnbean.getEquipment_Fac()+"','"+cnbean.getEquipment_Price()+"','"+cnbean.getEquipment_Bdate()+"','"+cnbean.getEquipment_Operator()+"'";
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
	//淇敼
	public void Update(EquipmentBean cnbean){
		String sql="update Equipment set ";
		sql+="Equipment_LabID='"+cnbean.getEquipment_LabID()+"',";
		sql+="Equipment_Name='"+cnbean.getEquipment_Name()+"',";
		sql+="Equipment_Type='"+cnbean.getEquipment_Type()+"',";
		sql+="Equipment_Number='"+cnbean.getEquipment_Number()+"',";
		sql+="Equipment_Model='"+cnbean.getEquipment_Model()+"',";
		sql+="Equipment_Fac='"+cnbean.getEquipment_Fac()+"',";
		sql+="Equipment_Price='"+cnbean.getEquipment_Price()+"',";
		sql+="Equipment_Bdate='"+cnbean.getEquipment_Bdate()+"',";
		sql+="Equipment_Operator='"+cnbean.getEquipment_Operator()+"'";

		sql+=" where Equipment_ID='"+cnbean.getEquipment_ID()+"'";
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
		String sql="delete from Equipment where ";
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

