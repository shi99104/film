<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<style type="text/css">
		body{text-align: center;}
		a{text-decoration: none;}
		#zong{width:1300px; margin:0 auto; height: 750px; }
		#up{ height:150px;text-align: left; margin:20px 80px;}
		#center{width:1300px; height:400px;margin-top: 10px;}
		.a1{width:600px; height: 300px; display:inline-block; margin: 60px 23px;vertical-align:middle;}
		#down{margin-top: 100px;}
		.c1{width: 300px;height:38px;background-size: 25px 25px;background-position: 5px 4px;background-repeat: no-repeat;padding: 8px 10px 8px 40px;border:1px solid #ddd;}
		#d1{background-image:url("图片/e12e2a9eb9799c2076e69e7aeebd3294.png")}
		#d2{background-image:url("图片/9f355498ef5ed60b5a0548ebcd82fb1b.png")}
		#d3{background-image:url("图片/89626d780fdcaf7f424e995095521425.png")}
	</style>
<title>用户登陆|网上电影票预订系统</title>
		<meta name="keywords" content="电影，电影票，电影购票，购买电影票，电影票选购，看电影">
  </head>
  
  <body>
   <div id="zong">
			<div id="up" ><img src="图片/logo.jpg" width="300px" height="80px"/></div>
			  <div id="center">
						 <div id="a1" class="a1" align="center"><img src="图片/853134c2d30235d56bbea11f3e07bbf1.png"  width="400px" height="200px" alt="错误"/></div>
						  <div class="a1" id="a2" align="left"><h4>账号登陆</h4>
			<form action="Login" method ="post">
			<table cellpadding="5">
				<tr>
					 <td><input type="text" name="user" size="10" placeholder="账号" class="c1" id="d1" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"></td></tr>
				<tr>
					 <td><input type="password" name="cipher" size="15" placeholder="密码" class="c1" id="d2" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"></td></tr>
				 <tr>
					 <td><input type="text" name="codes" class="c1" placeholder="请输入验证码" id="d3" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"></td>
			<td><span style="border:1px solid;" onclick="location.href='Login'">
           <%=session.getAttribute("Vcode") %></span>${message}</td>
			</tr>
				<tr align="right" valign="bottom" >
					 <td><a href="Amenduser.jsp" >忘记密码</a></td></tr>
				<tr align="left" valign="middle">
					<td><input type="submit" name="submit"  value="登陆" style="width: 70px;height: 25px"></td>
				<td><input type="reset" nmae="reset" value="重置" style="width: 70px;height: 25px"></td></tr>
				<tr>
			<td colspan="2">没有账号？ <a href="register.jsp">免费注册</a></td></tr>
				
				</table>
					</form>
					</div>
			 </div>
				
					<div id="down">
		<p align="center">Copyringht&copy;科院（信息工程学院）</p></div></div>
  </body>
</html>


