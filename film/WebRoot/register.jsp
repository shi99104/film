<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		#zong{width:100%; margin:0 auto; }
		#up{ height:150px;}
		#left{text-align: left;margin-left: 150px;}
		#center{text-align: left;margin-left: 450px; height: 530px;}
		.cs{width:300px;height:30px;}
	</style>
<title>用户注册|电影购票系统</title>
	<meta name="keywords" content="电影，电影票，电影购票，购买电影票，电影票选购，看电影">
	<script type="text/javascript" src="js/RegisterLayout.js"></script>	
</head>
<body>
	<div id="zong">
	<div id="up" ><div id="left"><img  src="图片/logo.jpg" width="300px" height="80px"></div>
		<hr color="#3C8CEF">
		</div>
		<div id="center">
		<form action="Adduser" method = "get">
			<table cellspacing="25px">
			<tr>
				<td>昵称：</td><td><input  type="text" id="text1" name="nickname" placeholder="请输入昵称"  class="cs" onblur="check()" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"><span id="div1" class="tian" >*<span></td> 
				</tr>
			<tr><td>用户名：</td><td><input type="text"  id="text2" name="user" placeholder="请输入用户名"size="50" class="cs" onblur="check()" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"><span id="div2" class="tian">*<span><span>${massage}</span></span></td></td>
				</tr>
			<tr>
				<td>密码：</td><td><input type="text" id="text3" name="cipher" size="50" class="cs" placeholder="请输入密码" onblur="check()" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"><span id="div3" class="tian" >*<span></td>
				</tr>
			<tr>
				<td>确定密码：</td><td><input type="text" id="text4"name="ciphers" size="50" class="cs"><span id="div4" class="tian" onblur="check()" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">*<span></td>
				</tr>
			<tr>
				<td>手机号：</td><td><input type="text" id="text5" name="mob" placeholder="请输入手机号" size="50" class="cs" maxlength="11" onblur="check()" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"><span id="div5" class="tian" onblur="check()">*<span></td>
				</tr>
				   <tr>
					   <td colspan="2"><input type="submit" value="注册" style="width:200px;height:30px;background:#2872BE;color: aliceblue;margin-right: 40px;">
					   <input type="reset" value="重置" style="width:200px;height:30px;background:#2872BE;color: aliceblue;">
					   </td>
					    
				</tr>
			</table>
			</form>
		</div>
		<div id="down">
		<p align="center">Copyringht&copy;科院（工程学院）</p></div>
	</div>
</html>