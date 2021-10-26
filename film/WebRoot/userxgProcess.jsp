<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户信息修改|后台系统</title>
	<style type="text/css">
	 a{text-decoration: none;}
	ul{list-style:none;}
		#header{width:100%;height:30px;background:#0F121E;color:aliceblue;}
		#zuo{width:50%;height: 100%;}
		#zhong{width:30%;heigth:100%}
		#you{width:10%;heigth:100%;}
		#main{width:100%;height:700px;background: #BE93D2;}
		.a1{display: inline-block;vertical-align:middle;}
		.xg{width:200px;heigth:50px;}
		#left{width:20%;height: 100%;background: #36B8AC;}
		#left ul{margin:0;padding:0} 
		#left ul li{text-align:center;vertical-align:middle;margin: 2px;}
		#left ul li a{margin: 0px;padding: 0px 0px 0px; 8px;display: block;background-image:url("图片/背景色.jpg");
	line-height: 40px;border-right: 1px solid #ccc;barder-bottom:1px solid #ccc;}
		#left ul li ul li{height: 40px;}
		#left ul li ul li a{background:#43C7D8;background-image: url("图片/背景色（改）.jpg");}
		#left ul li a:haver{background:#C91215;border-bottom: 1px dashed #ff0000;}
        #left ul li ul{ display: none;}
        #left ul li:hover ul{display:block;position:relative;}
        #left ul li ul li a:hover{background: #333;}
		#right{width:78%;height:100%;background: #51D67B;}
	</style>
	<script type="text/javascript">
	/*---------- 动态获取系统当前日期方法start ------*/
		setInterval(
				"document.getElementById('sysDate').value=new Date().toLocaleString()+'  星期'+'日一二三四五六'.charAt(new Date().getDay());",
				1000);
		setInterval(
				"document.getElementById('sysSysDate').value=new Date().toLocaleString();",
				1000);
 
		/*---------- 动态获取系统当前日期方法end ------*//**
 * 
 */
	</script>
  </head>
  
  <body>
   <div id="zong">
		<div id="header">
		<div id="zuo" class="a1">欢迎使用本系统,<%=session.getAttribute("yh")%></div>
			<div id="zhong" class="a1"><input id="sysDate" style="width: 200px;text-align: center;" readonly="readonly" /></div>
			<div id="you" class="a1"><a href="AdministratorLanding.jsp" >退出系统</a></div>
		</div>
	<div id="main">
	  <div id="left" class="a1">
		<ul>
		<li><a href="HTGuserxx.jsp">管理员信息</a>
			<ul>
			<li><a href="HTGusertj.jsp">新增管理员信息</a></li>
			<li><a href="HTGuserxx.jsp">管理员信息列表</a></li>
			<li><a href="HTGusercx.jsp">管理员信息查询</a></li>
			</ul>
			</li>
	    <li><a href="HTuserxx.jsp">网站用户信息</a>
			<ul>
			<li><a href="HTuserxx.jsp">用户信息列表</a></li>
			<li><a href="HTusercx.jsp">用户信息查询</a></li>
			</ul>
			<li>
		<li><a href="HTggxx.jsp">公告信息</a>
			<ul>
			<li><a href="HTggtj.jsp">新增公告信息</a></li>
			<li><a href="HTggxx.jsp">公告信息查看</a></li>
			</ul>
			</li>		
		<li><a href="HTdylxxx.jsp">电影类型信息</a>
			<ul>
			<li><a href="HTdylxtj.jsp">新增电影类型</a></li>
			<li><a href="HTdylxxx.jsp">电影类型列表</a></li>
			</ul>
			</li>
		<li><a href="HTyyxx.jsp">影院信息</a>
			<ul>
			<li><a href="HTyytj.jsp">新增影院信息</a></li>
			<li><a href="HTyyxx.jsp">影院信息列表</a></li>
			<li><a href="HTyycx.jsp">影院信息查询</a></li>
			</ul>
			</li>
	    <li><a href="HTdyxx.jsp">电影信息</a>
			<ul>
			<li><a href="HTdytj.jsp">新增电影信息</a></li>
			<li><a href="HTdyxx.jsp">电影信息列表</a></li>
			<li><a href="HTdycx.jsp">电影信息查询</a></li>
			</ul>
			</li>
			<li><a href="HTddxx.jsp">订单信息</a>
			<ul>
			<li><a href="HTddxx.jsp">订单列表</a></li>
			<li><a href="HTddcx.jsp">订单查询</a></li>
			</ul>
			</li>
		</ul>
		</div>
      <div id="right" class="a1">
		<table align="center" cellspacing="20">
		<%
		String number=request.getParameter("number");
		String nickname=request.getParameter("nickname");
		String user=request.getParameter("user");
		String cipher=request.getParameter("cipher");
		String mob=request.getParameter("mob");
		String time=request.getParameter("time"); %>
		<form action="HTuserxgProcess" method="get">
		<tr><td>编号</td><td><input type="text" name="number" value="<%=number%>" class="xg" readonly="readonly" ></td><td>不可修改</td></tr>
		<tr><td>昵称</td><td><input type="text" name="nickname" value="<%=nickname%>" class="xg"></td><td></td></tr>
		<tr><td>用户名</td><td><input type="text" readonly="readonly" name="user"value="<%=user%>"class="xg" ></td><td>不可修改</td></tr>
		<tr><td>密码</td><td><input type="text" name="cipher" value="<%=cipher%>" maxlength="15" class="xg"></td></tr>
		<tr><td>手机号</td><td><input type="text" name="mob" value="<%=mob%>" maxlength="11" class="xg"></td>${text}</tr>
		<tr><td>注册时间</td><td><input type="text" readonly="readonly"  name="time" value="<%=time%>"class="xg"></td><td>不可修改</td></tr>
		<tr><td><input type="submit" value="修改"></td></tr>
		</form>
      </div>
		</div>
<div id="footer">

</div>		
	</div>
  </body>
</html>
