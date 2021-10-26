<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    
    <title>个人信息|网上电影票预订系统</title>
    <style type="text/css">
	 *{padding: 0px;margin: 0px;}
		body{text-align: center;}
		a{text-decoration: none;}
		ul{list-style-type:none}
        li{display:inline-block;}
		#up{background:#F5F5F5;margin-bottom:30px;height: 20px;border-bottom-style:ridge;border-bottom-width:1px;}
		#up ul li ul{display: none;}
		#up ul li{position:relative;margin-right: 2px;}
		#up ul li:hover ul{display:block;position: relative;}
		#main{width:70%;margin:0 auto;border-style:ridge;border-width: 1px;;height: 800px;margin-bottom: 40px;}
		#left{width:15%;height: 800px;text-align: left;float:left;text-align: center;background: #F0F8FF;}
		#rigth{width:80%;float:right;}
		#a1{text-align:left;margin-top:20px;border-bottom-style:ridge;border-bottom-width: 1px;margin-bottom: 20px;}
		#a2{text-align: center;width:70%;margin-left: 100px;}
		.d1{display:inline-block;height: 500px;margin:0px;width:15%;}
		.d2{width: 200px;height: 25px;}
		#top{margin-top: 20px;height:10%;}
		#on ul li{text-align:center;margin-bottom:20px;color:#0E0606;display: block;}
		#on ul li a:hover{background: #9F0C0E;color: aliceblue;}
	</style>
   </head>
  
  <body>
    <div id="zong">
		<%@ include file="Navigation1.jsp" %>
		<div id="main">
		<div id="left" class="d1" >
			<div id="top"><h3>个人信息</h3></div>
			<div id="on">
				<ul>
					<li><a href="OrderForm?user=${yh}">我的订单</a></li>
			<li><a href="ExaminePersonalInformation?user=${yh}">我的信息</a></li>
			</ul>
				</div>
			</div>
	    <div id="rigth" class="d1">
			<div id="a1"><h3>基本信息</h3></div>
			
			<div id="a2">
			<form action="PersonalInformation" method="get">
				<table align="center" cellspacing="30">
				<tr><td>用户名：</td><td><input type="text" name="user" value="${yh}" readonly="readonly" style="border-style: none;" class="d2"></td></tr>
				<tr><td>昵称：</td><td><input type="text" name="nickname" value="${nc}" maxlength="10" class="d2" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"></td></tr>
				<tr><td>手机号：</td><td><input type="text" name="mob" value="${mob}" maxlength="11" class="d2" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"></td></tr>
					<tr><td colspan="2" align="left"><input type="submit" value="保存" style="width: 80px;">${message}</td></tr>
				</table>
				</form></div>
			</div>
		</div>
		<div id="footer">
		<p align="center">Copyringht&copy;科院（工程学院）</p></div>
		</div>
	</div>
  </body>
</html>
