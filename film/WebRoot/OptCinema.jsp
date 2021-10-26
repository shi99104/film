<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="film.*,java.sql.*"%>
<html>
  <head>
    
    <title>影院|订票|网上电影票预订系统</title>
    <style type="text/css">
		*{padding: 0px;margin: 0px;}
		a{text-decoration: none;}
		ul{list-style-type:none}
        li{display:inline-block;}
		.ys1{border-bottom-style:ridge;}
		#header{height:100px;margin-bottom: 20px;position:relative;}
		#ups1{background:#F5F5F5;height:30px;border-bottom-style:ridge;border-bottom-width:1px;width: 100%;vertical-align: middle;margin-bottom: 10px;}
		#ups1 img{width:15px;}
		#e1{width:70%;text-align:left;}
		#e1 ul li{width:15%;margin-right: 10px;display: inline-block;vertical-align: middle;margin-top: 4px;position:relative;}
		#e1 ul li ul{display:none;}
		#e1 ul li ul li{width: 100%;line-height:20px;}
        #e1  ul li a:haver{background: #666;border-bottom: 1px dashed #ff0000;}
		#e1 ul li:hover ul{display:block;position:absolute;line-height: 20px;}
		#e2{padding: 0px;width:29%;text-align: right;}
		.e1{height:30px;display: inline-block;}		
		.a1{display:inline-block;vertical-align:middle;height:50px;}
		.a2{text-align: left;border-bottom-color: aqua;}
		.b1{display:inline-block;vertical-align:middle;}
		 #ons1{width:100%;height:70px;}
		#lt1{width:10%;}
		#rt1{width:60%;text-align:right;}
		 #dn1{width: 20%;text-align:right;}
		 #main{width:98%;margin: auto;position:relative;}
		 #div1{width:100%;height:30px;}
		#div2{width:100%;margin:0 auto;margin-bottom:10px;height: 430px;}
		.s1{display: inline-block;vertical-align:middle;height: 500px;}
		#div2-1{width:20%;}
		#div2-2{width:50%;margin-left:-80px;}
		#div2-3{width:20%;}
		.a2{display: inline-block;}
		.b1{display:inline-block;vertical-align:middle;}
		#footer{width: 100%; height: 300px;}
		#left{width:60%;}
		#rigth{width:30%;}
		.class_zong{width: 100%;height:80px;margin-top:10px;border-bottom-style: dashed;border-bottom-width:1px;}
		.left{width: 50%;display: inline-block;height:100px;}
		.centre{width: 29%;align-content: center;display: inline-block;vertical-align: middle;height:100px;text-align: right;}
		.rigth{width:15%;text-align: right;display: inline-block;height:100px;vertical-align: middle;}
	</style>
  </head>
  
  <body>
    <div id="header">
		<div id="ups1" class="b1">
		<div id="e1" class="e1">
			<ul>
		<li><h4>欢迎光临本站</h4>
		<%String user=(String) session.getAttribute("yh");
		if(user!=null&user!=""){
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
			<div id="ons1">
		<div id="lt1" class="a1"><img src="图片/logo.jpg" width="200px" aligt></div>
		<div id="rt1" class="a1">
			<form><input type="text" name="text" size="60" style="width: 500px;height: 30px;">
				  <input type="submit" name="submit" value="搜索" style="width: 80px;height: 33px;"></form>
		</div>
		<div id="dn1" class="a1"></div>
		</div></div>
	<div id="main">
	<div id="div1"><h3>${FilmTitle}</h3></div>
		<div id="div2">
		<div id="div2-1" class="s1"><img src="${bill}" width="200"></div>
			<div id="div2-2" class="s1">
			<table cellpadding="5" >
				<tr><td width="100px"><h4>导演：</h4></td><td>${director}</td></tr>
				<tr><td><h4>主演：</h4></td><td>${actor}</td></tr>
				<tr><td><h4>类型：</h4></td><td>${type}</td></tr>
				<tr><td><h4>制作地区：</h4></td><td>${region}</td></tr>
				<tr><td><h4>语言：</h4></td><td>${laguae}</td></tr>
				<tr><td><h4>片长：</h4></td><td>${movietime}分钟</td></tr>
				<tr><td><h4>剧情介绍：</h4></td><td>${intrommend}</td></tr>
				</table>
				</div>
			<div id="div2-3" class="s1" align="right">
				<h4 align="left">上映时间:${releasedate}</h4>
				<h3 align="left">预告片</h3>
				</div>
			</div>	
	<div id="footer">
	<%	
		try{
		Connection conn = ConnectionFactory.createConnection();
		String sql="select* FROM 影院信息 order by number"; 
		Statement Stmt=conn.createStatement();
		ResultSet rs = Stmt.executeQuery(sql);
		%>
		<% while(rs.next()){
				String cinema= rs.getString("cinema");
				String address= rs.getString("address");
				int Atstarting=rs.getInt("Atstarting");
				%>
		<div class="class_zong">
		<div class="left">
	<a href=""><%=cinema%></a>
		<p>地址:<%=address%></p>
			<div class="class_1">
		<span class="">退 </span>	
		<span class="">改签</span>
		<span class="">折扣卡</span>
			</div>
		</div>
		<div class="centre">
		<span class="" >￥</span>
		<span><%=Atstarting%></span>
		<span>起</span>
			</div>
		<div class="rigth"><a href="CinemaSelectProcess?cinema=<%=cinema%>&user=${yh}&price=${price}&laguae=${laguae}&FilmTitle=${FilmTitle}">购票</a></div>
		</div>
				
				 <%
	        }
	         %>
	        </table> 
	       <%}
	       catch(Exception e){
	       out.print(e.toString());
	       }
	        %>
		</div>
		</div>
  </body>
</html>
