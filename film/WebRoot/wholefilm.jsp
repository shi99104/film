<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="film.*,java.sql.*"%>
<html>
  <head>
    
    <title>全部电影|网上电影票预订系统</title>
        <style type="text/css">
		*{padding: 0px;margin: 0px;}
		.ys1{border-bottom-style:ridge;}
		body{text-align: center;}
		a{text-decoration: none;}
		ul{list-style-type:none}
        li{display:inline-block;}
		#left1{background:#F5F5F5;height:30px;border-bottom-style:ridge;border-bottom-width:1px;width: 100%;}
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
		ul{list-style: none;}
		a{text-decoration: none;}
		#shang{width:80%;margin:auto;border-style: ridge;border-width: 1px;margin-top:20px;}
		.as1 ul li{display: inline-block;width:90px;margin-bottom:7px;}
		.as1{width:98%;margin-bottom:10px;padding-bottom:5px; border-bottom-style: ridge;border-bottom-width:1px;text-align:left;margin-left:10px;margin-top:10px;}
		#zhong{width:80%;margin:0 auto;margin-bottom:200px;text-align:left;height:900px;}
		.as2{width:180px;margin-left:50px;margin-top:10px;display: inline-block;text-align:left;height:230px;}
		.as2 img{width:100%;height:200px;}
		.as2 .p{text-align:center;margin-top:2px;heigth:10px;}
		#as3{width:80%;margin:0 auto;}
		#xia{width:100%;margin:0 auto;text-align: center;padding: 0px;}
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
		<li><a href="announcement.jsp" >网站公告</a></li>
			<li><a href="wholefilm.jsp" class="ys1">全部电影</a></li></ul>
			</div>			
			</div>
	<div id="shang">
	<ul>	
		<li>
			<div class="as1">
		<ul>
			<li>类型：</li>
			<li><a href="wholefilm.jsp">全部</a></li>
				<li><a href="Screen?type=爱情">爱情</a></li>
			<li><a href="Screen?type=喜剧">喜剧</a></li>
			<li><a href="Screen?type=动画">动画</a></li>
			<li><a href="Screen?type=恐怖">恐怖</a></li>
			<li><a href="Screen?type=惊悚">惊悚</a></li>
			<li><a href="Screen?type=科幻">科幻</a></li>
			<li><a href="Screen?type=动作">动作</a></li>
			<li><a href="Screen?type=冒险">冒险</a></li>
			<li><a href="Screen?type=战争">战争</a></li>
			<li><a href="Screen?type=奇幻">奇幻</a></li>
			<li><a href="Screen?type=运动">运动</a></li>
			<li><a href="Screen?type=家庭">家庭</a></li>
			<li><a href="Screen?type=传记">传记</a></li>
			</ul></div>
		</li>
		<li>
		<div class="as1">
		<ul>
			<li>区域：</li>
			<li><a href="wholefilm.jsp">全部</a></li>
				<li><a href="Screen?area=大陆">大陆</a></li>
			<li><a href="Screen?area=美国">美国</a></li>
			<li><a href="Screen?area=韩国">韩国</a></li>
			<li><a href="Screen?area=日本">日本</a></li>
			<li><a href="Screen?area=英国">英国</a></li>
			<li><a href="Screen?area=泰国">泰国</a></li>
			<li><a href="Screen?area=法国">法国</a></li>
			<li><a href="Screen?area=俄罗斯">俄罗斯</a></li>
			<li><a href="Screen?area=意大利">意大利</a></li>
			<li><a href="Screen?area=德国">德国</a></li>
			<li><a href="Screen?area=波兰">波兰</a></li>
			</ul></div></li>
		<li>
		<div class="as1">
		<ul>
			<li>时间：</li>
			<li><a href="wholefilm.jsp">全部</a></li>
				<li><a href="Screen?age=2020">2021</a></li>
			<li><a href="Screen?age=2020">2020</a></li>
			<li><a href="Screen?age=2019">2019</a></li>
			<li><a href="Screen?age=2018">2018</a></li>
			<li><a href="Screen?age=2017">2017</a></li>
			<li><a href="Screen?age=2016">2016</a></li>
			<li><a href="Screen?age=2015">2015</a></li>
			<li><a href="Screen?age=2014">2014</a></li>
			<li><a href="Screen?age=2013">2013</a></li>
			<li><a href="Screen?age=2012">2012</a></li>
			<li><a href="Screen?age=2011">2011</a></li>
			<li><a href="Screen?age=2010">2010</a></li>
			<li><a href="Screen?age=2009">2009</a></li>
			<li><a href="Screen?age=2008">2008</a></li>
			<li><a href="Screen?age=2007">2007</a></li>
			<li><a href="Screen?age=2006">2006</a></li>
			<li><a href="Screen?age=2005">2005</a></li>
			<li><a href="Screen?age=2004">2004</a></li>
			<li><a href="Screen?age=2003">2003</a></li>
			<li><a href="Screen?age=2002">2002</a></li>
			<li><a href="Screen?age=2001">2001</a></li>
			<li><a href="Screen?age=2000">2000</a></li>
			</ul></div></li>
		</ul>	
	   </div>
	<div id="zhong">
	<%	 String pageNo=request.getParameter("pageno");
     int pageSize=20;//每页显示的项数
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
		String sql="select* FROM 电影信息 order by number DESC"; 
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
		<%
		rs.beforeFirst();
		rowCurrent=1; 
		while(rs.next()){
		if(rowCurrent>(pageCurrent-1)*pageSize&&rowCurrent<=pageCurrent*pageSize){
				int number=rs.getInt("number");
				String FilmTitle= rs.getString("FilmTitle");
				String bill=rs.getString("bill");
				String intrommend = rs.getString("intrommend");
				String director = rs.getString("director");
				String actor= rs.getString("actor");
				String region = rs.getString("region");
				String laguae = rs.getString("laguae");
				String type = rs.getString("type");
				String releasedate1= rs.getString("releasedate");
				String movietime= rs.getString("movietime");
				String price = rs.getString("price");
				%>
		
	<div class="as2">
		<a href="FilmMinute?FilmTitle=<%=FilmTitle%>"><img src="<%=bill%>" alt="<%=FilmTitle%>"></a>
		<a href="FilmMinute?FilmTitle=<%=FilmTitle%>"><p class="p"><%=FilmTitle%></p></a>
		</div>
		
	
	   <%
	        }
	        rowCurrent++;
	        }
	         %>
	           <div id="as3" align="center">
	           <table>
	           <tr align="center" valign="middle"><td colspan="7"><p align="center" class="p">
	        <form method="post" action="wholefilm.jsp">
	        第<%=pageCurrent%>页 共<%=pageCount%>页&nbsp;
	        <%if(pageCurrent>1) {%>
	        <a href="wholefilm.jsp?pageno=1">首页</a>
	        <a href="wholefilm.jsp?pageno=<%=pageCurrent-1%>">上一页</a>
	        <%} %>&nbsp;
	        <%if(pageCurrent<pageCount){ %>
	        <a href="wholefilm.jsp?pageno=<%=pageCurrent+1%>">下一页</a>
	        <a href="wholefilm.jsp?pageno=<%=pageCount%>">尾页</a>
	        <%} %>&nbsp;跳转到第<input type="text" name="pageno" size="2" maxlength="5">页
	        <input type="submit" value="GO">
 	        </form>
	        </td></tr>
	        </table>
	        </div> 
	       </div>
	      <%
	       rs.close();
	       Stmt.close();
	       }	       
	       catch(Exception e){
	       out.print(e.toString());
	       }
	        %>      
	<div id="xia">
			<p>Copyringht&copy;科院（信息工程学院）</p>
	</div>
  </body>
</html>
