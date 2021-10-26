<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="film.*,java.sql.*"%>

<html>
  <head>
    
    <title>电影查询结果|后台系统</title>
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
      <div id="up">
      <% String FilmTitle1=request.getParameter("FilmTitle");
      String pageNo=request.getParameter("pageno");
     int pageSize=2;//每页显示的项数
     int pageCount;//总页数
     int rowCount;//
     int pageCurrent;//当前页
     int rowCurrent;//返回页
     if(pageNo==null||pageNo.trim().length()==0){
       pageCurrent=1;
     }else{
     pageCurrent=Integer.parseInt(pageNo);
     }	
		try{
		Connection conn = ConnectionFactory.createConnection();
		String sql="select* FROM 电影信息  WHERE FilmTitle LIKE '"+"%"+FilmTitle1+"%"+"'"; 
		Statement Stmt=conn.createStatement();
		ResultSet rs = Stmt.executeQuery(sql);
		rs.last();
		rowCount=rs.getRow();
		pageCount=(rowCount+pageSize-1)/pageSize;
		if(pageCurrent>pageCount)
		pageCurrent=pageCount;
		if(pageCurrent<1)
		pageCurrent=1;
		%>
    <table align="center" frame="border" rules="all" width="1050px" height="500px">
		<caption style="font-size:30px">电影信息查询结果</caption>
		<tr align="center" valign="middle"><td colspan="15"><form action="HTdycx1.jsp">
          <input type="text" name="FilmTitle" style="width:500px;" placeholder="请输入电影名称">
           <input type="submit" value="搜索" style="width:50px;">
       </form></td></tr>
		<tr>
		<th>编号</th>
		<th>电影名称</th>
		<th>电影海报</th>
		<th>电影简介</th>
		<th>导演（编剧）</th>
		<th>主演</th>
		<th>制作地区</th>
		<th>语言</th>
		<th>类型</th>
		<th>上映时间</th>
		<th>电影时长</th>
		<th>价格</th>
		<th colspan="3">操作</th>
		</tr>
		<% rs.beforeFirst();
		rowCurrent=1;
		while(rs.next()){
		if(rowCurrent>(pageCurrent-1)*pageSize&&rowCurrent<=pageCurrent*pageSize){
				int number=rs.getInt("number");
				String FilmTitle= rs.getString("FilmTitle");
				String bill= rs.getString("bill");
				String intrommend = rs.getString("intrommend");
				String director = rs.getString("director");
				String actor= rs.getString("actor");
				String region = rs.getString("region");
				String laguae = rs.getString("laguae");
				String type = rs.getString("type");
				String releasedate= rs.getString("releasedate");
				String movietime= rs.getString("movietime");
				String price = rs.getString("price");
				%>
	   <tr><td><%=number%></td><td><%=FilmTitle%></td><td><img src=<%=bill%> style="width:100px;"></td><td><%=intrommend%></td><td><%=director%></td><td><%=actor%></td>
	   <td><%=region%></td><td><%=laguae%></td><td><%=type%></td><td><%=releasedate%></td>
	   <td><%=movietime%>分钟</td><td><%=price%></td>
	   <td><a href="FilmMinute?FilmTitle=<%=FilmTitle%>">详情</a></td>
	   <td><a href="HTdyxxRevise.jsp?number=<%=number%>&FilmTitle=<%=FilmTitle%>&intrommend=<%=intrommend%>&director=<%=director%>&actor=<%=actor%>&region=<%=region%>&type=<%=type%>&releasedate=<%=releasedate%>&movietime=<%=movietime%>&price=<%=price%>">修改</a></td>
	   <td><a href="HTdyxxscProcess.jsp?number=<%=number%>">删除</a></td></tr>
	        <%
	        }
	        rowCurrent++;
	        }
	         %>
	         <tr align="center" valign="middle"><td colspan="15"><p align="center" class="p">
	        <form method="post" action="HTdyxx.jsp">
	        第<%=pageCurrent%>页 共<%=pageCount%>页&nbsp;
	        <%if(pageCurrent>1) {%>
	        <a href="HTdyxx.jsp?pageno=1">首页</a>
	        <a href="HTdyxx.jsp?pageno=<%=pageCurrent-1%>">上一页</a>
	        <%} %>&nbsp;
	        <%if(pageCurrent<pageCount){ %>
	        <a href="HTdyxx.jsp?pageno=<%=pageCurrent+1%>">下一页</a>
	        <a href="HTdyxx.jsp?pageno=<%=pageCount%>">尾页</a>
	        <%} %>&nbsp;跳转到第<input type="text" name="pageno" size="2" maxlength="5">页
	        <input name=submit" type="submit" value="GO">
 	        </form>
	        </p></td></tr>
	        </table></div> 
	       <%
	       rs.close();
	       Stmt.close();
	       }	       
	       catch(Exception e){
	       out.print(e.toString());
	       }
	        %>
      </div>
		</div>
      </div>
<div id="footer">
<p>Copyringht&copy;科院（信息工程学院）</p>
</div>		
  </body>
</html>