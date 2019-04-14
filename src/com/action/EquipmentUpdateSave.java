package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class EquipmentUpdateSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String Equipment_ID ;
	private String Equipment_LabID ;
    private String Equipment_Name ;
    private String Equipment_Type ;
    private String Equipment_Number ;
    private String Equipment_Model ;
    private String Equipment_Fac ;
    private String Equipment_Price ;
    private String Equipment_Bdate ;
    private String Equipment_Operator ;



	public String getEquipment_ID() {
		return Equipment_ID;
	}

	public void setEquipment_ID(String equipment_ID) {
		Equipment_ID = equipment_ID;
	}

	public String getEquipment_LabID() {
		return Equipment_LabID;
	}

	public void setEquipment_LabID(String EquipmentLabID) {
		Equipment_LabID = EquipmentLabID;
	}

	public String getEquipment_Name() {
		return Equipment_Name;
	}

	public void setEquipment_Name(String EquipmentName) {
		Equipment_Name = EquipmentName;
	}

	public String getEquipment_Type() {
		return Equipment_Type;
	}

	public void setEquipment_Type(String EquipmentType) {
		Equipment_Type = EquipmentType;
	}

	public String getEquipment_Number() {
		return Equipment_Number;
	}

	public void setEquipment_Number(String EquipmentNumber) {
		Equipment_Number = EquipmentNumber;
	}

	public String getEquipment_Model() {
		return Equipment_Model;
	}

	public void setEquipment_Model(String equipment_Model) {
		Equipment_Model = equipment_Model;
	}

	public String getEquipment_Fac() {
		return Equipment_Fac;
	}

	public void setEquipment_Fac(String equipment_Fac) {
		Equipment_Fac = equipment_Fac;
	}

	public String getEquipment_Price() {
		return Equipment_Price;
	}

	public void setEquipment_Price(String equipment_Price) {
		Equipment_Price = equipment_Price;
	}

	public String getEquipment_Bdate() {
		return Equipment_Bdate;
	}

	public void setEquipment_Bdate(String equipment_Bdate) {
		Equipment_Bdate = equipment_Bdate;
	}

	public String getEquipment_Operator() {
		return Equipment_Operator;
	}

	public void setEquipment_Operator(String equipment_Operator) {
		Equipment_Operator = equipment_Operator;
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
		
		//查询用户名是否存在
		List<EquipmentBean> list=new EquipmentDao().GetList("Equipment_Name='"+Equipment_Name+"' and Equipment_LabID="+Equipment_LabID+" and Equipment_ID!="+Equipment_ID, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('名称已经存在！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//修改
		
		EquipmentBean cnbean=new EquipmentBean();
		cnbean=new EquipmentDao().GetBean(Integer.parseInt(Equipment_ID));
		cnbean.setEquipment_LabID(Integer.parseInt(Equipment_LabID));
		cnbean.setEquipment_Name(Equipment_Name);
		cnbean.setEquipment_Type(Equipment_Type);
		cnbean.setEquipment_Number(Equipment_Number);
		cnbean.setEquipment_Model(Equipment_Model);
		cnbean.setEquipment_Fac(Equipment_Fac);
		cnbean.setEquipment_Price(Equipment_Price);
		cnbean.setEquipment_Bdate(Equipment_Bdate);
		cnbean.setEquipment_Operator(Equipment_Operator);

		new EquipmentDao().Update(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('修改成功！');window.location='EquipmentManager.action';</script>");
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
