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
   if(isNull(form1.Equipment_LabID.value)){  
   alert("请选择实验室！"); 
   return false;
   }
   if(isNull(form1.fix_name.value)){
	   alert("请输入设备名！");
	   return false;
	   }
   if(isNull(form1.fix_type.value)){
   alert("请输入设备类型！");
   return false;
   }
   if(isNull(form1.fix_model.value)){
   alert("请输入设备规格！");
   return false;
   }
   if(isNull(form1.fix_num.value)){
	   alert("请输入设备数量！");
	   return false;
	   }
   if(isNull(form1.fix_date.value)){
	   alert("请输入修理日期！");
	   return false;
	   }
   if(isNull(form1.fix_fac.value)){
		   alert("请输入修理厂家！");
		   return false;
		   }
   if(isNull(form1.fix_cost.value)){
	   alert("请输入修理单价！");
	   return false;
	   }
   if(isNull(form1.fix_lia.value)){
	   alert("请输入负责人！");
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
              <td height="30"  style="padding-left:25px;">添加设备</td>
            </tr>
            <tr>
            <td height="470" align="justify" valign="top"  background="Images/p3.jpg"><form name="form1" method="post" action="EquipFixAddSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%">&nbsp;</td>
                  </tr>
                 <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>实验室：</td>
                    <td><select name="Equipment_LabID" id="Equipment_LabID">
                      <option value="">请选择</option>
                      <s:iterator id="aa" value="list">
                        <option value="${Lab_ID}" <s:if test="cnbean.Equipment_LabID==Lab_ID">selected</s:if>>${Lab_Name}</option>
                      </s:iterator>
                    </select></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>设备名：</td>
                    <td><input name="fix_name" type="text" class="text2" id="fix_name" value="<s:property value='cnbean.fix_name'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>设备类型：</td>
                    <td><input name="fix_type" type="text" class="text2" id="fix_type" value="<s:property value='cnbean.Equipment_Type'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>设备规格：</td>
                    <td><input name="fix_model" type="text" class="text2" id="fix_model" value="<s:property value='cnbean.Equipment_Model'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>设备数量：</td>
                    <td><input name="fix_num" type="text" class="text2" id="fix_num" value="<s:property value='cnbean.Equipment_Number'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>修理日期：</td>
                    <td><input name="fix_date" type="text" class="text2" id="fix_date"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>修理厂家：</td>
                    <td><input name="fix_fac" type="text" class="text2" id="fix_fac"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>修理单价：</td>
                    <td><input name="fix_cost" type="text" class="text2" id="fix_cost"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>负责人：</td>
                    <td><input name="fix_lia" type="text" class="text2" id="fix_lia"></td>
                  </tr>
                  
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="添加设备">
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
