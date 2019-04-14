<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link href="Style/Style.css" rel="stylesheet" type="text/css" />
<table width="155" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="31" align="center" ><strong>系统选项</strong></td>
            </tr>
            <tr>
              <td height="50" align="center" valign="top"><table width="150" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center"  style="text-align:left; padding-left:40px;"><a href="Index.jsp">后台首页</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <%if(session.getAttribute("type").toString().equals("1")){%>
                <tr>
                  <td height="30" align="center"  style="text-align:left; padding-left:40px;"><a href="ApplyManager.action">申请表管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
               
                <tr>
                  <td height="30" align="center"  style="text-align:left; padding-left:40px;"><a href="LabManager.action">实验室管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center"  style="text-align:left; padding-left:40px;"><a href="EquipmentManager.action">正常设备管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center"  style="text-align:left; padding-left:40px;"><a href="EquipFixManager.action">维修设备管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                
                
                
                
                
                <%}%>
                <%if(session.getAttribute("type").toString().equals("2")){%>
                <tr>
                  <td height="30" align="center"  style="text-align:left; padding-left:40px;"><a href="ApplyManager.action">申请表管理</a></td>
                </tr>
                <tr>
                <%}%>

                <tr>
                  <td height="30" align="center"  style="text-align:left; padding-left:40px;"><a href="PasswordUpdate.jsp">修改密码</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center"  style="text-align:left; padding-left:40px;"><a href="Quit.action" onclick="return confirm('确定要退出系统吗？')">退出系统</a></td>
                </tr>
              </table>
              </td>
            </tr>
          </table>