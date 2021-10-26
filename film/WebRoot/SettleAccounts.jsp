<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="film.*,java.sql.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>结算|网上电影票预订系统</title>
 <style type="text/css">
	*{padding: 0px;margin: 0px;}
		a{text-decoration: none;}
		ul{list-style-type:none}
        li{display:inline-block;}
	    #header{margin-bottom: 20px;border-bottom: 1px ridge ;}
		#up{background:#F5F5F5;height: 30px;border-bottom-style:ridge;border-bottom-width:1px;width: 100%;}
		#up img{width:15px;}
		#e1{padding: 0px;width:70%;margin: 0px;}
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
		#under{width:10%;text-align: left;margin-left: 100px;margin-top: 20px;}
	    #main{width:80%;margin: auto;border: 1px ridge;height:500px;}
	    #on{margin: auto;width:90%;height:30px;border: 1px ridge;margin-top:20px;margin-bottom: 20px;}
	   #on_1{width:60%;text-align: left;}
	   #on_2{width:30%;text-align:right;color:#FF4500;}
	  .n{display:inline-block;}
	  #down{margin: auto;width:90%;}
	  #down_1{width:90%;margin: auto;margin-top: 100px;margin-bottom: 50px;}
	  #down_2{height:150px;margin: auto;text-align: right}
	  .down_2{display: inline-block;}
	  #down_2_1{width:70%;height:150px;text-align:left;}
	  #down_2_2{width:25%;text-align: right;margin-top:70px;}
	  #footer{margin-top:50px;}
	</style>

  </head>
  
  <body>
  <div id="header">
		<div id="up" class="b1">
		<div id="e1" class="e1">
			<ul>
		<li><h4>欢迎光临本站</h4>
		<li><a href="UserLanding.jsp"><img src="图片/676062a938fb8ffffa2f8b9f7e938f57.png">${nc}</a>
	       <ul>
					<li><a href="ExaminePersonalInformation?user=${yh}">我的信息</a></li>
			        <li><a href="OrderForm?user=${yh}">我的订单</a></li>
				   <li><a href="BowOut">退出登陆</a></li>
			</ul>
				</li>
		<li><a href=""><img src="图片/6b8718c62f648baf7b4661712c4c7dbd.png">信息</a></li>
		<li><a href="index.jsp"><img src="图片/642afcc008d1ed3f29afb36f7a41e1ef.png">首页导航</a></li>
				</ul>
					</div>
		<div id="e2" class="e1"><a href=""><ul>
		<li><a href="CollectLove.jsp"><img src="图片/6235b95912116d6c15e9a3e1e3c25e40.png">我的喜欢</a></li>
		<li><a href="Chronicle.jsp"><img src="图片\9f54a1c9e84645f6d722bbc11fd7a5fd.png">历史记录</a></li>
		<li><a href="Suggestion.jsp"><img src="图片\59756b8962a7b8acafc9f4c5a757df90.png">投诉建议</a></li>
		<li><a href=""><img src="图片/9d3559a130737eb266be040fbb4d674e.png">联系客服</a></li>
		</ul></div>
		</div>			
		<div id="under" class="a1"><img src="图片/logo.jpg"  width="300px" height="80px"></div>
		</div>
	<div id="main">
	
	    <div id="on">
		    <div id="on_1" class="n"><h4>项目：网上电影票预订系统—订单编号：${ordernumber}</h4></div>
			<div id="on_2" class="n">应付金额￥${price}</div>
		</div>
		<div id="down">
			<div id="down_1">
		<table cellpadding="20" width="1000px" align="center" height="100px" rules="none" frame="border" >
			<tr style="background:#F5F5F5;"><th>影片</th><th>影院</th><th>数量</th><th>预订时间</th>
			</tr>
			<tr align="center"><td>${FilmTitle}</td><td>${cinema}</td><td>${quantity}张</td><td>${ViewingTime}</td></tr>
			</table></div>
			<div id="down_2">
				<div id="down_2_1" class="down_2">
				<% 
				String cinema1= request.getSession().getAttribute("cinema").toString();
		try{
		Connection conn = ConnectionFactory.createConnection();	
		String sql="SELECT * FROM 影院信息  WHERE cinema='"+cinema1+"'"; 
		Statement Stmt=conn.createStatement();
		ResultSet rs = Stmt.executeQuery(sql);
	 while(rs.next()){
				String cinema= rs.getString("cinema");
				String address=rs.getString("address");
				String mob= rs.getString("mob");
				%>    
					<p><h4>影院:<%=cinema%></h4></p>
					<p>地址:<%=address%></p>
					<p>电话:<%=mob%></p>
					  <%	       
	        }
	        
	         %>
	       <%}
	       catch(Exception e){
	       out.print(e.toString());
	       }
	        %>
				</div>
				<div id="down_2_2" class="down_2">
					<p style="color:#FF4500 ">总价￥${price}</p><br>
				<form action="SettleAccounts">
				<input type="hidden" name="ordernumber" value="${ordernumber}">
				<input type="hidden" name="price" value="${price}">
				<input type="hidden" name="monovalent" value="${monovalent}">
				<input type="hidden" name="quantity" value="${quantity}">
				<input type="hidden" name="cinema" value="${cinema}">
				<input type="hidden" name="time" value="${time}">
				<input type="hidden" name="FilmTitle" value="${FilmTitle}">
					<input type="submit" value="立即支付" style="background: #5889B8;">
					</form>
				</div>
			</div>
		</div>
	</div>
	<div id="footer">
		<p align="center">Copyringht&copy;科院（信息工程学院）</p></div>	
		</div>
    
  </body>
</html>
