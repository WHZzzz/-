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
              <td height="30" style="padding-left:25px;">设备管理</td>
            </tr>
            <tr>
             <td height="470" align="justify" valign="top" bgcolor="#F6F9FE" background="Images/p3.jpg"><form name="form1" method="post" action="EquipmentManager.action">
                <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="22%" height="30" style="padding-left:20px;"> 功能导航： <a href="EquipmentAdd.action">添加设备</a></td>
                    <td width="78%">查询：
                      <select name="SearchRow" id="SearchRow">
                        <option value="Equipment_ID">设备编号</option>
                        <option value="Equipment_Name">设备名</option>
                        <option value="Equipment_Type">设备类型</option>
                        <option value="Equipment_Number">设备数量</option>
                        <option value="Equipment_Model">设备规格</option>
                        <option value="Equipment_Fac">生产厂家</option>
                        <option value="Equipment_Price">设备单价</option>
                        <option value="Equipment_Bdate">生产日期</option>
                        <option value="Lab_Name">所属实验室</option>

                      </select>
                      <input name="SearchKey" type="text" class="text1" id="SearchKey">
                      <input type="submit" name="button" id="button" value="点击查询"></td>
                  </tr>
                </table>
              </form>
                <table width="80%" border="0" cellspacing="0" cellpadding="0"><tr><br></tr>
                  <tr align="center"  class="t1">
                    <td ><strong>设备编号</strong></td>
                    <td ><strong>设备名</strong></td>
                    <td ><strong>设备类型</strong></td>
                    <td ><strong>数量</strong></td>
                    <td ><strong>设备规格</strong></td>
                    <td ><strong>生产厂家</strong></td>
                    <td ><strong>设备单价</strong></td>
                    <td ><strong>生产日期</strong></td>
                    <td height="25" ><strong>所属实验室</strong></td>
 
                    <td ><strong>操作</strong></td>
                  </tr>
                  <s:iterator id="aa" value="list">
                    <tr align="center">
                      <td>${Equipment_ID}</td>
                      <td>${Equipment_Name}</td>
                      <td>${Equipment_Type}</td>
                      <td align="center">${Equipment_Number}</td>
                      <td align="center">${Equipment_Model}</td>
                                            <td align="center">${Equipment_Fac}</td>
                                                                  <td align="center">${Equipment_Price}</td>
                                                                                        <td align="center">${Equipment_Bdate}</td>
                      <td height="25" align="center">${Lab_Name}</td>
                      <td align="center"><a href="EquipmentUpdate.action?Equipment_ID=${Equipment_ID}">修改</a> <a href="EquipmentDel.action?Equipment_ID=${Equipment_ID}" onClick="return confirm('确定要删除该设备吗？')">删除</a> <a href="EquipFixAdd.action?Equipment_ID=${Equipment_ID}">维修</a> </td>
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
