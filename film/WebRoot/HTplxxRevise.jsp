<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="film.*,java.sql.*"%>
<html>
  <head>
  <title>影评信息修改|后台系统</title>
	<link type="text/css" rel="stylesheet" href="Css/HTtype.css">
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
		<div id="zuo" class="a1">欢迎使用本系统,<%=session.getAttribute("gly")%></div>
			<div id="zhong" class="a1"><input id="sysDate" style="width: 200px;text-align: center;" readonly="readonly" /></div>
			<div id="you" class="a1"><a href="AdministratorLanding.jsp" >退出系统</a></div>
		</div>
		<div id="main">
	   <div id="left" class="a1">
		<ul>
		<li><a href="HTGuserxx.jsp">管理员信息</a>
			<ul>
			<li><a href="HTGusertj.jsp">新增管理员信息</a></li>
			</ul>
			</li>
	    <li><a href="HTuserxx.jsp">网站用户信息</a> 
	    <ul>
			<li><a href="HTusertj.jsp">新增用户信息</a></li>
			</ul>
			</li>
		<li><a href="HTggxx.jsp">公告信息</a>
			<ul>
			<li><a href="HTggtj.jsp">新增公告信息</a></li>
			</ul>
			</li>		
		<li><a href="HTyyxx.jsp">影院信息</a>
			<ul>
			<li><a href="HTyytj.jsp">新增影院信息</a></li>
			</ul>
			</li>
	    <li><a href="HTdyxx.jsp">电影信息</a>
			<ul>
			<li><a href="HTdytj.jsp">新增电影信息</a></li>
			</ul>
			</li>
			<li><a href="HTddxx.jsp">订单信息</a>
			</li>
			<li><a href="HTplxx.jsp">影评信息</a>
			<ul>
			<li><a href="HTpltj.jsp">新增影评信息</a></li>
			</ul>
			</li>
			<li><a href="HTuserBrowsingHistoryxx.jsp">用户历史浏览信息</a>
			</li>
			<li><a href="HTyhgzxx.jsp">用户关注信息</a>
			</li>
			<li><a href="HTtsjyxx.jsp">用户投诉建议信息</a>
			</li>
		</ul>
		</div>
      <div id="right" class="a1">
      <form action="HTplxxRevise" method="get">
		<table align="center" cellspacing="20">
		<%
		        String number=request.getParameter("number");//编号
				String FilmTitle= request.getParameter("FilmTitle");//电影名
				String discuss = request.getParameter("discuss");//影评
				String nickname = request.getParameter("nickname");//昵称
				String time=request.getParameter("time");%>	 
		<tr><td>编号</td><td><input type="text" name="number" value="<%=number%>" class="xg" readonly></td></tr>
		<tr><td>电影名称</td><td><input type="text" size="30"  name="FilmTitle"value="<%=FilmTitle%>" class="xg" readonly></td></tr>
		<tr><td>用户昵称</td><td><input type="text" name="nickname" value="<%=nickname%>" class="xg" readonly></td></tr>
		<tr><td>影评</td><td><textarea rows="6" cols="60" name="discuss"><%=discuss%></textarea></td></tr>
		<tr><td>操作时间</td><td><input type="text" name="time" value="<%=time%>" class="xg"></td></tr>
		<tr><td><input type="submit" value="修改">${yy}</td></tr>
		 </table></form></div></div>
  <div id="footer">
<p>Copyringht&copy;科院（信息工程学院）</p>
  </div>		
	</div>
  </body>
</html>

