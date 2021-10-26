<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="film.*,java.sql.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>电影搜索结果|网上电影票预订系统</title>
      <style type="text/css">
		*{padding: 0px;margin: 0px;}
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
		#e2{width:29%;text-align: right;}
		.e1{display: inline-block;height:40px;vertical-align: middle;}		
		.a1{display:inline-block;vertical-align:middle;}
		.a2{text-align: left;border-bottom-color: aqua;}
		.b1{display:inline-block;vertical-align:middle;}
		#left{width:10%;}
		#right{width:88%;}
		#main{width:80%;margin:auto;text-align:left;border-style:ridge;border-width:1px;height:800px;}
		.as2{width:180px;margin-left:50px;margin-top:10px;display: inline-block;text-align:left;height:230px;}
		.as2 img{width:100%;height:200px;}
		.as2 .p{text-align: center;margin-top: 2px}
		 #footer{margin-top:900px;}
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
		<div id="left" class="a1"><img src="图片/logo.jpg" width="200px"></div>
		<div id="right" class="a1">
			<form action="SearchFor"><input type="text" name="FilmTitle" size="60" placeholder="请输入你要观看的电影" style="width:500px;height: 30px;">
				  <input type="submit" name="submit" value="搜索" style="width: 80px;height: 33px;"></form>
		</div>
		<div id="down"></div>
		</div>
	<div id="main">
	<% 
		String FilmTitle= request.getSession().getAttribute("FilmTitle").toString();%>
		<div id="c12"><h2>搜索 “<%=FilmTitle%>”</h2></div>
		<%
		String sql = "SELECT * FROM 电影信息  WHERE FilmTitle LIKE '"+"%"+FilmTitle+"%"+"'";
			Connection conn = ConnectionFactory.createConnection();
			PreparedStatement pst = null;
			List<Filminfo> list = new ArrayList<Filminfo>();
			try {
				pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()){
				String FilmTitle1= rs.getString("FilmTitle");
					String bill= rs.getString("bill");
				%>
				  
	<div class="as2">
	<a href="FilmMinute?FilmTitle=<%=FilmTitle1%>"><img src="<%=bill%>" alt="<%=FilmTitle1%>"></a>
		<a href="FilmMinute?FilmTitle=<%=FilmTitle1%>"><p class="p"><%=FilmTitle1%></p></a>
		</div>
		    <%	       
	        }if(rs.first()==false){%> 
				<div style="width:80%" align="center"><h1>暂无此电影，请你重新搜索其他！</h1></div>
	       <%}}
	       catch(Exception e){
	       out.print(e.toString());
	       }
	        %>
	</div>
	<div id="footer">
<p align="center">Copyringht&copy;科院（信息工程学院）</p>
</div>	
  </body>
</html>
