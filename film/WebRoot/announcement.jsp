<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="film.*,java.sql.*,java.*"%>
<html>
  <head>
    
    <title>网页公告|网上电影票预订系统</title>
    <style type="text/css">
		*{padding: 0px;margin: 0px;}
		.ys1{border-bottom-style:ridge;}
		body{text-align: center;}
		a{text-decoration: none;}
		ul{list-style-type:none}
        li{display:inline-block;}
		#left1{background:#F5F5F5;height: 30px;border-bottom-style:ridge;border-bottom-width:1px;width: 100%;}
		#left1 img{width:15px;}
		#e1{width:70%;text-align:left;}
		#e1 ul li{width:15%;margin-right: 10px;display: inline-block;vertical-align: middle;margin-top: 4px;position:relative;}
		#e1 ul li ul{display:none;}
		#e1 ul li ul li{width: 100%;line-height:20px;}
        #e1  ul li a:haver{background: #666;border-bottom: 1px dashed #ff0000;}
		#e1 ul li:hover ul{display:block;position:absolute;line-height: 20px;}
		#e2{padding: 0px;width:29%;text-align: right;}
		.e1{height:30px;display: inline-block;}		
		.a1{display:inline-block;vertical-align:middle;}
		.a2{text-align: left;border-bottom-color: aqua;}
		.b1{display:inline-block;vertical-align:middle;}
		#left{width:10%;}
		#right{width:88%;}
		#up1{height: 30px;text-align: left;border-bottom-style:ridge;border-bottom-width:1px;}
		#up1 ul li{width: 100px;vertical-align: middle;margin-left:50px;}
		#down1{height:300px;}
		#main{display:inline;}
		#footer{width:70%;height:700px;margin: auto;border-style:ridge;border-width:1px;margin-top:20px;}
		.s1{width:80%;height:100px;margin: auto;border-style:ridge;border-width:1px;margin-bottom: 10px;}
		.u1{width:90%;height:20px;text-align:left;margin-left:10px;}
		.u2{width:100%;height:40px;text-align:center;}
		.u3{width:90%;height:20px;text-align:right;}
		.u4{width:90%;height:20px;text-align:right;}
		</style>
  </head>
  
  <body>
	    <div id="header">
		<div id="left1" class="b1">
		<div id="e1" class="e1">
			<ul>
		<li><h4>欢迎光临本站</h4>
		<%String user=(String) session.getAttribute("yh");
		if(user!=null&&user!=""){
		%>
		<li><a href="UserLanding.jsp"><img src="图片/676062a938fb8ffffa2f8b9f7e938f57.png">${nc}</a>
	       <ul>
	                <li><a href="ExaminePersonalInformation?user=${yh}">我的信息</a></li>
			        <li><a href="OrderForm?user=${yh}">我的订单</a></li>
					<li><a href="BowOut">退出登陆</a></li>
			</ul>
				</li>
				<%}else{ %>
				<li><a href="UserLanding.jsp"><img src="图片/676062a938fb8ffffa2f8b9f7e938f57.png"><p style="color:#CD0000;display:inline-block;">你好，请登录</p></a>
	       <ul>
					<li><a href="register.jsp">注册</a></li>
			</ul>
				</li>
				<%} %>
				<li><a href=""><img src="图片/6b8718c62f648baf7b4661712c4c7dbd.png">信息</a></li>
		<li><a href="index.jsp"><img src="图片/642afcc008d1ed3f29afb36f7a41e1ef.png">首页导航</a></li>
				</ul>
					</div>
		<div id="e2" class="e1">
		 <ul>
		 <li><a href="CollectLove.jsp"><img src="图片/6235b95912116d6c15e9a3e1e3c25e40.png">我的喜欢</a></li>
		<li><a href="Chronicle.jsp"><img src="图片\9f54a1c9e84645f6d722bbc11fd7a5fd.png">历史记录</a></li>
		<li><a href="Suggestion.jsp"><img src="图片\59756b8962a7b8acafc9f4c5a757df90.png">投诉建议</a></li>
		<li><a href=""><img src="图片/9d3559a130737eb266be040fbb4d674e.png">联系客服</a></li>
		</ul>
		</div>
		</div>			
		</div>
		<div id="left" class="a1"><img src="图片/logo.jpg" width="200px"></div>
		<div id="right" class="a1">
			<form action="SearchFor"><input type="text" name="FilmTitle" size="60" placeholder="请输入你要观看的电影" style="width:500px;height: 30px;">
				  <input type="submit" name="submit" value="搜索" style="width: 80px;height: 33px;"></form>
		</div>
		<div id="down"></div>
		<div id="main">
			<div id="up1">
				<ul>
					<li style="margin-left:150px;"><a href="index.jsp" >首页</a></li>
		<li><a href="announcement.jsp" class="ys1">网站公告</a></li>
			<li><a href="wholefilm.jsp">全部电影</a></li></ul>
			</div>			
			</div>
			<div id="footer">
				<br>
				<h3>网页公告</h3>
				<br>
				<% 	
		try{
		Connection conn = ConnectionFactory.createConnection();
		String sql="select* FROM 公告信息 order by number desc"; 
		Statement Stmt=conn.createStatement();
		ResultSet rs = Stmt.executeQuery(sql);
		%>
		<% while(rs.next()){
				String announcement=rs.getString("announcement");
				String user1= rs.getString("user");
				String time= rs.getString("time");
				%>
			<div class="s1">
				<div class="u1">亲爱的用户，${nc}</div>
				<div class="u2"><%=announcement%></div>
				<div class="u3">管理员：<%=user1%></div>
				<div class="u4"><%=time%></div>
				</div>
				<%
	        }}
	       catch(Exception e){
	       out.print(e.toString());
	       }
	        %>
	        </div>
  </body>
</html>
