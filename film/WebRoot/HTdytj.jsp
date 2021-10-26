<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  <title>添加电影|后台系统</title>
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
      <form method="post" action="UploadPicture" enctype="multipart/form-data"> 
	<table align="center" cellspacing="20">
		<caption>电影信息添加</caption>
		<tr>
		<td>海报：</td><td><input type="file" name="file1" class="cs"><p style="font-size:1px;">仅支持jpg,png为后缀名文件</p></td>
		<td><input type="submit" value="上传" style="height:30px; cursor:pointer;">${massage}</td>
		</tr>
		</table>
		</form>
		 <form action="filmTJprocess" method="get">
		<table align="center" cellspacing="20">
		<tr>
		<td><input type="hidden" name=bill value=${file1} class="cs"></td>
		</tr>
		<tr>
		<td>电影名：</td><td><input type="text" name="FilmTitle" class="cs"></td>
		</tr>
		<tr>
		<td>电影介绍：</td><td><textarea rows="5" cols="45" name="intrommend"></textarea></td>
		</tr>
		<tr>
		<td>导演：</td><td><input type="text" name="director" class="cs"></td>
		</tr>
		<tr>
		<td>主演：</td><td><input type="text" name="actor" class="cs"></td>
		</tr>
		
		<tr>
		<td>制作地区：</td><td><input type="text" name="region" class="cs"></td>
		</tr>
		<tr>
		<td>语言：</td><td><input type="text" name="laguae" class="cs"></td>
		</tr>
		<tr>
		<td>类型：</td><td><input type="text" name="type" class="cs"></td>
		</tr>
		<tr>
		<td>上映时间：</td><td><input type="text" name="releasedate" class="cs"></td>
		</tr>
		<tr>
		<td>电影时长：</td><td><input type="text" name="movietime" class="cs"></td>
		</tr>
		<tr>
		<td>价格：</td><td><input type="text" name="price" class="cs"></td>
		</tr>
		<tr><td colspan="2"><input type="submit" value="添加" style="width:100px">${tj}</td></tr>
		</table>
	</form>
      </div>
		</div>
<div id="footer">
<p>Copyringht&copy;科院（信息工程学院）</p>
</div>		
	</div>
  </body>
</html>
