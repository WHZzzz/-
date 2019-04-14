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
              <td height="30"  style="padding-left:25px;">维修设备管理</td>
            </tr>
            <tr>
             <td height="470" align="justify" valign="top"  background="Images/p3.jpg"><form name="form1" method="post" action="EquipFixManager.action">
                <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="22%" height="30" style="padding-left:20px;"> 功能导航： <a href="EquipFixAdd.action">添加设备</a></td>
                    <td width="78%">查询：
                      <select name="SearchRow" id="SearchRow">
                        <option value="fix_id">修理编号</option>
                        <option value="fix_name">设备名</option>
                        <option value="fix_num">修理数量</option>
                        <option value="fix_fac">修理厂家</option>
                        <option value="fix_cost">修理单价</option>
                        <option value="fix_lia">负责人</option>
                        <option value="Lab_Name">所属实验室</option>

                      </select>
                      <input name="SearchKey" type="text" class="text1" id="SearchKey">
                      <input type="submit" name="button" id="button" value="点击查询"></td>
                  </tr>
                  
                </table>
              </form>
              
                <table width="80%" border="0" cellspacing="0" cellpadding="0"><tr><br></tr>
                  <tr align="center"  class="t1">
                    <td ><strong>修理编号</strong></td>
                    <td ><strong>设备名</strong></td>
                    <td ><strong>数量</strong></td>
                    <td ><strong>修理日期</strong></td>
                    <td ><strong>修理厂家</strong></td>
                    <td ><strong>修理单价</strong></td>
                    <td ><strong>负责人</strong></td>
                    <td height="25" ><strong>所属实验室</strong></td>
 
                    <td ><strong>操作</strong></td>
                  </tr>
                  <s:iterator id="aa" value="list">
                    <tr align="center">
                      <td>${fix_id}</td>
                      <td>${fix_name}</td>
                      <td align="center">${fix_num}</td>
                                            <td align="center">${fix_date}</td>
                                                                  <td align="center">${fix_fac}</td>
                                                                                        <td align="center">${fix_cost}</td>
                      <td>${fix_lia}</td>
                                                                                     
                      <td height="25" align="center">${Lab_Name}</td>
                      <td align="center"><a href="EquipFixUpdate.action?fix_id=${fix_id}">修改</a> 
                      <a href="EquipFixDel.action?fix_id=${fix_id}" onClick="return confirm('确定要删除该设备吗？')">删除</a></td>
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
