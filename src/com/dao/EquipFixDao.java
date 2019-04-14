package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.EquipFixBean;
import com.db.DBHelper;

public class EquipFixDao {
	//鑾峰彇鍒楄〃
		public List<EquipFixBean> GetList(String strwhere,String strorder){
			String sql="select * from Equipfix,Lab,Equipment where Equipment_LabID=Lab_ID";
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
			List<EquipFixBean> list=new ArrayList<EquipFixBean>();
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				while(rs.next()){
					EquipFixBean cnbean=new EquipFixBean();
					cnbean.setFix_id(rs.getInt("fix_id"));
					cnbean.setEquipment_LabID(rs.getInt("Equipment_LabID"));
					cnbean.setFix_name(rs.getString("fix_name"));
					cnbean.setFix_type(rs.getString("fix_type"));
					cnbean.setFix_model(rs.getString("fix_model"));
					cnbean.setFix_num(rs.getString("fix_num"));
					cnbean.setFix_date(rs.getString("fix_date"));
					cnbean.setFix_fac(rs.getString("fix_fac"));
					cnbean.setFix_cost(rs.getString("fix_cost"));
					cnbean.setFix_lia(rs.getString("fix_lia"));

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
		public EquipFixBean GetBean(int id){
			String sql="select * from Equipfix,Lab where Equipment_LabID=Lab_ID and fix_id="+id;
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			EquipFixBean cnbean=new EquipFixBean();
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				while(rs.next()){
					cnbean.setFix_id(rs.getInt("fix_id"));
					cnbean.setEquipment_LabID(rs.getInt("Equipment_LabID"));
					cnbean.setFix_name(rs.getString("fix_name"));
					cnbean.setFix_type(rs.getString("fix_type"));
					cnbean.setFix_model(rs.getString("fix_model"));
					cnbean.setFix_num(rs.getString("fix_num"));
					cnbean.setFix_date(rs.getString("fix_date"));
					cnbean.setFix_fac(rs.getString("fix_fac"));
					cnbean.setFix_cost(rs.getString("fix_cost"));
					cnbean.setFix_lia(rs.getString("fix_lia"));
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
		public EquipFixBean GetEqBean(String name){
			String sql="select * from Equipfix where fix_name='"+name+"'";
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			EquipFixBean cnbean=new EquipFixBean();
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				while(rs.next()){
					cnbean.setFix_id(rs.getInt("fix_id"));
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
		public void Add(EquipFixBean cnbean){
			String sql="insert into Equipfix (";
			sql+="Equipment_LabID,fix_name,fix_type,fix_model,fix_num,fix_date,fix_fac,fix_cost,fix_lia";
			sql+=") values(";
			sql+="'"+cnbean.getEquipment_LabID()+"','"+cnbean.getFix_name()+"','"+cnbean.getFix_type()+"','"+cnbean.getFix_model()+"','"+cnbean.getFix_num()+"','"+cnbean.getFix_date()+"','"+cnbean.getFix_fac()+"','"+cnbean.getFix_cost()+"','"+cnbean.getFix_lia()+"'";
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
		public void Update(EquipFixBean cnbean){
			String sql="update Equipfix set ";
			sql+="Equipment_LabID='"+cnbean.getEquipment_LabID()+"',";
			sql+="fix_name='"+cnbean.getFix_name()+"',";
			sql+="fix_type='"+cnbean.getFix_type()+"',";
			sql+="fix_model='"+cnbean.getFix_model()+"',";
			sql+="fix_num='"+cnbean.getFix_num()+"',";
			sql+="fix_date='"+cnbean.getFix_date()+"',";
			sql+="fix_fac='"+cnbean.getFix_fac()+"',";
			sql+="fix_cost='"+cnbean.getFix_type()+"',";
			sql+="fix_lia='"+cnbean.getFix_lia()+"'";

			sql+=" where fix_id='"+cnbean.getFix_id()+"'";
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
			String sql="delete from Equipfix where ";
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



