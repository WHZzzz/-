<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>"> 
  <title>实验室设备信息管理系统</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<script language="JavaScript">

function mycheck(){
   if(isNull(form1.Type.value)){  
   alert("请选择身份！"); 
   return false;
   }
   if(isNull(form1.Username.value)){  
   alert("请输入用户名！"); 
   return false;
   }
   if(isNull(form1.Password.value)){
   alert("请输入密码！");
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
      <td height="680" align="center" valign="top" background="Images/p2.jpg"  >
      <table width="350" height="201" border="0" cellpadding="0" cellspacing="0">
        <tr>
        
          <td height="50" align="center" valign="top" ><br/><br/><br/><br/><br/><br/><h1 >实验室设备信息管理系统</h1><br/><br/><br/></td>
        </tr>
        <tr>
          <td align="center" valign="top">
             <form name="form1" action="GoLogin.action" method="post" onSubmit="return mycheck()">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                <td height="30" colspan="2" align="center" class="STYLE3"><span style="color:red;">
                    <%if(request.getAttribute("Msg")!=null){%>
                    <%=request.getAttribute("Msg")%>
                    <%}%>
                  </span></td>
                  </tr>
                <tr>
                  <td height="30" align="right" class="STYLE3">身份：</td>
                  <td align="left"><select name="Type" id="Type">
                    <option value="" >请选择</option>
                    <option value="系统管理员">系统管理员</option>
                    <option value="实验室管理员">领导</option>
                  </select></td>
                  </tr>
                <tr>
                  <td width="37%" height="30" align="right" class="STYLE3">用户名：</td>
                  <td width="300" align="left"><input type="text" name="Username" id="Username" class="text1" /></td>
                  </tr>
                <tr>
                  <td height="30" align="right" class="STYLE3">密码：</td>
                  <td align="left"><input type="password" name="Password" id="Password" class="text1" /></td>
                  </tr>
                <tr>
                  <td height="30" colspan="2" align="center"><label>
                    <input type="submit" name="button" id="button" value="登录" class="STYLE4">
                  </label></td>
                  </tr>
              </table>
              </form>
          
          </td>
        </tr>
      </table></td>
    </tr>
  </table>


</center>
</body>
</html>
