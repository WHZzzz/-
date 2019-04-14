package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class LabAddSave extends ActionSupport {
	
	//下面是Action内用于封装用户请求参数的属性
	private String Lab_Name ;
    private String Lab_Introduction ;

	public String getLab_Name() {
		return Lab_Name;
	}

	public void setLab_Name(String LabName) {
		Lab_Name = LabName;
	}

	public String getLab_Introduction() {
		return Lab_Introduction;
	}

	public void setLab_Introduction(String LabIntroduction) {
		Lab_Introduction = LabIntroduction;
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
		
		//查询名称是否存在
		List<LabBean> list=new LabDao().GetList("Lab_Name='"+Lab_Name+"'", "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('名称已经存在！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//添加
		LabBean cnbean=new LabBean();
		cnbean.setLab_Name(Lab_Name);
		cnbean.setLab_Introduction(Lab_Introduction);
		new LabDao().Add(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('添加成功！');window.location='LabManager.action';</script>");
		out.flush();out.close();return null;
		
	}
	
	//判断是否空值ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println();
	}
	
}
