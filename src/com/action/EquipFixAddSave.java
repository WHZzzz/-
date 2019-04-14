package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.EquipFixBean;
import com.dao.EquipFixDao;
import com.opensymphony.xwork2.ActionSupport;

public class EquipFixAddSave  extends ActionSupport{
	//下面是Action内用于封装用户请求参数的属性
		private String Equipment_LabID ;
		 private String fix_name ;
		 private String fix_type ;
		 private String fix_model ;
		 private String fix_num ;
		 private String fix_date ;
		 private String fix_fac ;
		 private String fix_cost ;
		 private String fix_lia ;


		public String getFix_name() {
			return fix_name;
		}
		public void setFix_name(String fix_name) {
			this.fix_name = fix_name;
		}
		public String getFix_type() {
			return fix_type;
		}
		public void setFix_type(String fix_type) {
			this.fix_type = fix_type;
		}
		public String getFix_model() {
			return fix_model;
		}
		public void setFix_model(String fix_model) {
			this.fix_model = fix_model;
		}
		public String getFix_num() {
			return fix_num;
		}
		public void setFix_num(String fix_num) {
			this.fix_num = fix_num;
		}
		public String getFix_date() {
			return fix_date;
		}
		public void setFix_date(String fix_date) {
			this.fix_date = fix_date;
		}
		public String getFix_fac() {
			return fix_fac;
		}
		public void setFix_fac(String fix_fac) {
			this.fix_fac = fix_fac;
		}
		public String getFix_cost() {
			return fix_cost;
		}
		public void setFix_cost(String fix_cost) {
			this.fix_cost = fix_cost;
		}
		public String getFix_lia() {
			return fix_lia;
		}
		public void setFix_lia(String fix_lia) {
			this.fix_lia = fix_lia;
		}
		public String getEquipment_LabID() {
			return Equipment_LabID;
		}
		public void setEquipment_LabID(String EquipmentLabID) {
			Equipment_LabID = EquipmentLabID;
		}


		//处理用户请求的execute方法
		public String execute() throws Exception {
			
			//解决乱码，用于页面输出
			HttpServletResponse response=null;
			response=ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			
			//创建session对象
			HttpSession session = ServletActionContext.getRequest().getSession();
			//验证是否正常登录
			if(session.getAttribute("id")==null){
				out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
				out.flush();out.close();return null;
			}
			
			
			//添加
			EquipFixBean cnbean=new EquipFixBean();
			cnbean.setEquipment_LabID(Integer.parseInt(Equipment_LabID));
			cnbean.setFix_name(fix_name);
			cnbean.setFix_type(fix_type);
			cnbean.setFix_model(fix_model);
			cnbean.setFix_num(fix_num);
			cnbean.setFix_date(fix_date);
			cnbean.setFix_fac(fix_fac);
			cnbean.setFix_cost(fix_cost);
			cnbean.setFix_lia(fix_lia);
			new EquipFixDao().Add(cnbean);
			    
			//跳转
			out.print("<script language='javascript'>alert('添加成功！');window.location='EquipFixManager.action';</script>");
			out.flush();out.close();return null;
			
		}
		
		//判断是否空值
		private boolean isInvalid(String value) {
			return (value == null || value.length() == 0);
		}
		
		//测试
		public static void main(String[] args) {
			System.out.println();
		}
		
}
