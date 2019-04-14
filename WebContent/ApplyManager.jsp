<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>实验室设备信息管理系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<center>
  <table width="1350" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td  height="80" align="center" background="Images/Login.jpg&#9;" style="color:black; font-size:28px; font-weight:bolder; padding-left:50px;">实验室设备信息管理系统</td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top"><table width="1350" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="200" height="500" align="left" valign="top" background="Images/p2.jpg">
          <%@ include file="Left.jsp"%>
          </td>
          <td width="1142.3" align="justify" valign="top" ><table width="1142.3" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30"  style="padding-left:25px;">申请表管理</td>
            </tr>
            <tr>
             <td height="470" align="justify" valign="top"  background="Images/p3.jpg" background="Images/p3.jpg"><form name="form1" method="post" action="ApplyManager.action">
                <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="22%" height="30" style="padding-left:20px;"> 功能导航： <a href="ApplyAdd.jsp">添加申请表</a></td>
                    <td width="78%">查询：
                      <select name="SearchRow" id="SearchRow">
                        <option value="app_id">申请表编号</option>
                        <option value="seq_name">设备名</option>
                        <option value="seq_fac">生产厂家</option>
                        <option value="app_date">申请日期</option>
                      </select>
                      <input name="SearchKey" type="text" class="text1" id="SearchKey">
                      <input type="submit" name="button" id="button" value="点击查询"></td>
                  </tr>
                </table>
              </form>
                <table width="80%" border="0" cellspacing="0" cellpadding="0" ><tr><br></tr>
                  <tr align="center"  class="t1">
                    <td ><strong>申请编号</strong></td>	
                    <td ><strong>申请原因</strong></td>
                    <td ><strong>设备名</strong></td>
                    <td ><strong>类别</strong></td>
                    <td ><strong>设规格</strong></td>
                    <td ><strong>数量</strong></td>
                    <td ><strong>申请时间</strong></td>
                    <td ><strong>详细说明</strong></td>
                    <td height="25"  ><strong>操作</strong></td>
                      <td ><strong>是否同意</strong></td>
                  </tr>
                  <s:iterator id="aa" value="list">
                    <tr align="center">
                      <td>${app_id}</td>
                      <td>${app_reason}</td>
                      <td>${seq_name}</td>
                      <td height="25"  align="center">${seq_type}</td>
                      <td align="center">${seq_model}</td>
                                  <td align="center">${seq_num}</td>
                                  <td align="center">${app_date}</td>
                                      <td align="center">${det_inf}</td>
                     
                    <td align="center"><a href="ApplyDel.action?app_id=${app_id}" onClick="return  confirm('确定要删除该申请表吗？')">删除</a></td>
                    </tr>
                  </s:iterator>
                </table></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>

</center>
</body>
</html>
