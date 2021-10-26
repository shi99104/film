<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="film.*,java.sql.*"%>
<html>
  <head>
    
    <title>收藏喜欢|网上电影票预订系统</title>
    <style type="text/css">
		*{padding: 0px;margin: 0px;}
		body{text-align: center;}
		a{text-decoration: none;}
		ul{list-style-type:none}
        li{display:inline-block;}
		.ys1{border-bottom-style:ridge;}
		#left1{background:#F5F5F5;height: 30px;border-bottom-style:ridge;border-bottom-width:1px;width: 100%;}
		#left1 img{width:15px;}
		#e1{width:70%;text-align:left;}
		#e1 ul li{width:15%;margin-right:10px;display: inline-block;vertical-align: middle;margin-top: 4px;position:relative;}
		#e1 ul li ul{display:none;}
		#e1 ul li ul li{width: 100%;line-height:20px;}
        #e1  ul li a:haver{background: #666;border-bottom: 1px dashed #ff0000;}
		#e1 ul li:hover ul{display:block;position:absolute;line-height: 20px;}
		#e2{padding:0px;width:29%;text-align:right;}
		.e1{height:30px;display: inline-block;}		
		.a1{display:inline-block;vertical-align:middle;}
		.a2{text-align: left;border-bottom-color: aqua;}
		.b1{display:inline-block;vertical-align:middle;}
		#left{width:10%;}
		#right{width:88%;}
		#main{width:60%;margin: auto;margin-top:30px;height:600px;border-style: ridge;border-width: 1px;}
		#ls{text-align:left;border-bottom-style: ridge;border-bottom-width:1px;}
		.ls{height:20px;margin-top:10px;text-align: left;}
		.time{display: inline-block;width:20%;margin-left: 20px;}
		.record{display: inline-block;width:50%;}
		.delete{display: inline-block;width:20%;}
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
		<li><a href="Chronicle.jsp"><img src="图片\9f54a1c9e84645f6d722bbc11fd7a5fd.png">历史记录</a></li>
		<li><a href="Suggestion.jsp"><img src="图片\59756b8962a7b8acafc9f4c5a757df90.png">投诉建议</a></li>
		<li><a href=""><img src="图片/9d3559a130737eb266be040fbb4d674e.png">联系客服</a></li>
		</ul>
		</div>
		</div>			
		</div>
		<div class="a1" id="left"><img src="图片/logo.jpg" width="200px"></div>
		<div class="a1" id="right">
			<form action="SearchFor"><input name="FilmTitle" type="text" placeholder="请输入你要观看的电影" style="width:500px;height: 30px;" size="60">
				  <input name="submit" type="submit" style="width: 80px;height: 33px;" value="搜索"></form>
		</div>
	<div id="main">
	 <div id="ls"><h3 style="margin-left: 20px;">我的收藏</h3></div>
	  <% 
		try{
		Connection conn = ConnectionFactory.createConnection();	
		String sql="SELECT * FROM 关注信息  WHERE user='"+user+"'"; 
		Statement Stmt=conn.createStatement();
		ResultSet rs = Stmt.executeQuery(sql);
	 while(rs.next()){
				String number= rs.getString("number");
				String FilmTitle=rs.getString("FilmTitle");
				%> 
	 
	      <div class="ls">
		     <div class="record"><a href="FilmMinute?FilmTitle=<%=FilmTitle%>"><%=FilmTitle%></a></div>
	         <div class="delete"><a href="DeleteCollect?user=<%=user%>&FilmTitle=<%=FilmTitle%>">取消喜欢</a></div>
		</div>
		      <%	       
	        }
	         %>
	       <%}
	       catch(Exception e){
	       out.print(e.toString());
	       }
	        %>
	</div>
	<div id="footer">
<p align="center">Copyringht©科院（信息工程学院）</p>
</div>
  </body>
</html>
