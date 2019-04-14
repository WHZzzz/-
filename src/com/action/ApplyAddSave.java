package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class ApplyAddSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性

	private String app_reason ;
    private String seq_name ;
    private String seq_type ;
    private String seq_model ;
    private String  seq_num ;
    private String app_date ;
	private String det_inf;
	
	public String getApp_reason() {
		return app_reason;
	}

	public void setApp_reason(String app_reason) {
		this.app_reason = app_reason;
	}

	public String getSeq_name() {
		return seq_name;
	}

	public void setSeq_name(String seq_name) {
		this.seq_name = seq_name;
	}

	public String getSeq_type() {
		return seq_type;
	}

	public void setSeq_type(String seq_type) {
		this.seq_type = seq_type;
	}

	public String getSeq_model() {
		return seq_model;
	}

	public void setSeq_model(String seq_model) {
		this.seq_model = seq_model;
	}

	public String getSeq_num() {
		return seq_num;
	}

	public void setSeq_num(String seq_num) {
		this.seq_num = seq_num;
	}

	public String getApp_date() {
		return app_date;
	}

	public void setApp_date(String app_date) {
		this.app_date = app_date;
	}

	public String getDet_inf() {
		return det_inf;
	}

	public void setDet_inf(String det_inf) {
		this.det_inf = det_inf;
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
				List<ApplyBean> list=new ApplyDao().GetList("app_reason='"+app_reason+"'","");
				if(list.size()>0)
				{
					out.print("<script language='javascript'>alert('名称已经存在！');history.back(-1);</script>");
					out.flush();out.close();return null;
				}
				
		//添加
		ApplyBean cnbean=new ApplyBean();
		cnbean.setApp_reason(app_reason);
		cnbean.setSeq_name(seq_name);
		cnbean.setSeq_type(seq_type);
		cnbean.setSeq_model(seq_model);
		cnbean.setSeq_num(seq_num);
		cnbean.setApp_date(app_date);
		cnbean.setDet_inf(det_inf);
		new ApplyDao().Add(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('提交成功！');window.location='ApplyManager.action';</script>");
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
