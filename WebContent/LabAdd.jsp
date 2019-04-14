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
<script language="JavaScript">


function mycheck(){
   if(isNull(form1.Lab_Name.value)){  
   alert("请输入名称！"); 
   return false;
   }
}

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}
   
   
</script>
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
              <td height="30"  style="padding-left:25px;">添加实验室</td>
            </tr>
            <tr>
             <td height="470" align="justify" valign="top"  background="Images/p3.jpg"><form name="form1" method="post" action="LabAddSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>名称：</td>
                    <td><input name="Lab_Name" type="text" class="text2" id="Lab_Name"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right">简介：</td>
                    <td><textarea name="Lab_Introduction" id="Lab_Introduction" cols="45" rows="5"></textarea></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="添加实验室">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);"></td>
                  </tr>
                </table>
              </form></td>
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
