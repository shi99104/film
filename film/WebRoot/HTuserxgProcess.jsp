<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户信息修改|后台系统</title>
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
      <form action="HTuserxgProcess" method="get">
		<table align="center" cellspacing="20">
		<%
		String number=request.getParameter("number");
		String nickname=request.getParameter("nickname");
		String user=request.getParameter("user");
		String cipher=request.getParameter("cipher");
		String mob=request.getParameter("mob");
		String time=request.getParameter("time"); %>
		<tr><td>编号</td><td><input type="text" name="number" value="<%=number%>" class="xg" readonly></td></tr>
		<tr><td>昵称</td><td><input type="text" name="nickname" value="<%=nickname%>"></td><td></td></tr>
		<tr><td>用户名</td><td><input type="text" readonly name="user"value="<%=user%>"class="xg"></td></tr>
		<tr><td>密码</td><td><input type="text" name="cipher" value="<%=cipher%>" maxlength="15"></td></tr>
		<tr><td>手机号</td><td><input type="text" name="mob" value="<%=mob%>" maxlength="11"></td>${text}</tr>
		<tr><td>操作时间</td><td><input type="text" readonly name="time" value="<%=time%>"class="xg"></td></tr>
		<tr><td><input type="submit" value="修改"></td></tr>
		</table>
		</form>
       </div>
		</div>
      </div>
      <div id="footer">
<p>Copyringht&copy;科院（信息工程学院）</p>
</div>	
  </body>	
  </body>
</html>

