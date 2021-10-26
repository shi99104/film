<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="film.*,java.sql.*"%>
<html>
  <head>
  <title>订单信息|后台系统</title>
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
      <%
      String pageNo=request.getParameter("pageno");
     int pageSize=7;//每页显示的项数
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
		String sql="select* FROM 订单信息 order by number desc"; 
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
		<caption style="font-size:30px">订单信息</caption>
		<tr align="center" valign="middle"><td colspan="12">
		<form action="HTddcx.jsp">
      <input type="text" name="FilmTitle" style="width:500px;"placeholder="请输入电影名">
      <input type="submit" value="搜索" style="width:50px;">
      </form></td></tr>
		<tr>
		<th>编号</th>
		<th>订单号</th>
		<th>用户名</th>
		<th>电影名</th>
		<th>影院名</th>
		<th>单价</th>
		<th>票数</th>
		<th>总价格</th>	
		<th>预订时间</th>
		<th>观影时间</th>
		<th>是否付款</th>
		<th>操作</th>
		</tr>
		<% 
		rs.beforeFirst();
		rowCurrent=1;
		while(rs.next()){
		if(rowCurrent>(pageCurrent-1)*pageSize&&rowCurrent<=pageCurrent*pageSize){
				int number=rs.getInt("number");
				String ordernumber= rs.getString("ordernumber");
				String user= rs.getString("user");
				String FilmTitle= rs.getString("FilmTitle");
				String cinema= rs.getString("cinema");
				String monovalent= rs.getString("monovalent");
				int price= rs.getInt("price");
				int quantity=rs.getInt("quantity");
				String location= rs.getString("location");
				String time = rs.getString("time");
				String ViewingTime= rs.getString("ViewingTime");	
				String payment= rs.getString("payment");
				%>
	   <tr align="center" valign="middle"><td><%=number%></td><td><%=ordernumber%></td><td><%=user%></td><td><%=FilmTitle%></td><td><%=cinema%></td><td>￥<%=monovalent%>元</td>
	   <td><%=quantity%></td><td>￥<%=price%>元</td><td><%=time%></td><td><%=ViewingTime%></td><td><%=payment%></td>
	   <td><a href="HTOrdernumberDelete.jsp?ordernumber=<%=ordernumber%>">删除</a></td></tr>
	        <%
	        }
	        rowCurrent++;
	        }
	         %>
	         <tr align="center" valign="middle"><td colspan="12"><p align="center" class="p">
	        <form method="post" action="HTddxx.jsp">
	        第<%=pageCurrent%>页 共<%=pageCount%>页&nbsp;
	        <%if(pageCurrent>1) {%>
	        <a href="HTddxx.jsp?pageno1">首页</a>
	        <a href="HTddxx.jsp?pageno=<%=pageCurrent-1%>">上一页</a>
	        <%} %>&nbsp;
	        <%if(pageCurrent<pageCount){ %>
	        <a href="HTddxx.jsp?pageno=<%=pageCurrent+1%>">下一页</a>
	        <a href="HTddxx.jsp?pageno=<%=pageCount%>">尾页</a>
	        <%} %>&nbsp;跳转到第<input type="text" name="pageno" size="2" maxlength="5">页
	        <input name=submit" type="submit" value="GO">
 	        </form>
	        </p></td></tr>
	        </table> 
	       </div>
	      <%
	       rs.close();
	       Stmt.close();
	       }	       
	       catch(Exception e){
	       out.print(e.toString());
	       }
	        %>
      </div>
		</div></div>
<div id="footer">
<p>Copyringht&copy;科院（信息工程学院）</p>
</div>		
  </body>
</html>