<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>欢迎登录高校教务管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<LINK rel=stylesheet type=text/css href="<%=path %>/css/login.css">
	<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
    
    <script language="javascript">
		function check1()
		{                                                                                         
		     if(document.loginForm.userName.value=="")
			 {
			 	alert("请输入账号");
				document.loginForm.userName.focus();
				return false;
			 }
			 if(document.loginForm.userPw.value=="")
			 {
			 	alert("请输入密码");
				document.loginForm.userPw.focus();
				return false;
			 }
			 document.getElementById("indicator").style.display="block";
			 loginService.login(document.loginForm.userName.value,document.loginForm.userPw.value,document.loginForm.userType.value,callback);
		}
		
		function callback(data)
		{
		    document.getElementById("indicator").style.display="none";
		    if(data=="no")
		    {
		        alert("用户名或密码错误");
		    }
		    if(data=="yes")
		    {
		        alert("通过验证,系统登录成功");
		        window.location.href="<%=path %>/loginSuccess.jsp";
		    }
		    
		}
	    </script>
    
  </head>
  <body>
    <DIV class=lo-top></DIV>
    <DIV class=lo-box>
        <DIV class=lo-main style="margin-top: 80px;">
           <UL id=lo-ul>
			  <LI><IMG src="<%=path %>/images/lo_left.gif"></LI>
			  <LI>
			     <P class=warning><LABEL id=Label1>&nbsp;</LABEL></P>
			     <FORM method="post" action="111" name="loginForm" style="margin-left: 50px;margin-top: 1px;">
			               <table border="0" cellpadding="1" cellspacing="1">
								<tr height="60">
									<td colspan="2" style="font-family: 微软雅黑;font-size: 20px;" align="center">
										<div style="margin-left: 30px;">高校教务管理系统</div>
									</td>
								</tr>
								<tr height="35">
									<td style="width: 40px;font-family: 微软雅黑" align="right">
										账号：										    
									</td>
									<td align="left">
										<input name="userName" type="text" style="width: 280px;"/>
									</td>
								</tr>
								<tr height="35">
									<td style="width: 40px;font-family: 微软雅黑" align="right">
										密码：										    
									</td>
									<td align="left">
										<input name="userPw" type="password" style="width: 280px;"/>
									</td>
								</tr>
								<tr height="35">
									<td style="width: 40px;font-family: 微软雅黑" align="right">
										类型：										    
									</td>
									<td align="left">
										<select name="userType" style="width: 285px;">
										    <option value="0">管理员</option>
								            <option value="1">学生</option>
								            <option value="2">老师</option>
										</select>
									</td>
								</tr>
								<tr height="35">
								   <td style="width: 40px;" align="left"></td>
								   <td align="left">
								      <input type="button" value="登录" style="width: 100px;" onClick="check1()"/>&nbsp; 
								      <input type="reset" value="重置" style="width: 100px;"/>&nbsp;
								      <img id="indicator" src="<%=path %>/img/loading.gif" style="display:none"/>	
								   </td>
								</tr>
							</table>
			                                    
			         
			     </FORM>
			  </LI>
           </UL>
        </DIV>
    </DIV>
  </BODY>
</html>
