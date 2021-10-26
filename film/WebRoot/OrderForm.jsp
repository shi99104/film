<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="film.*,java.sql.*,java.*"%>
<html>
  <head>
    
    <title>订单信息|网上电影票预订系统</title>
    <style type="text/css">
	*{padding: 0px;margin: 0px;}
		body{text-align: center;}
		a{text-decoration: none;}
		ul{list-style-type:none}
        li{display:inline-block;}
		#up{background:#F5F5F5;margin-bottom:30px;height: 20px;border-bottom-style:ridge;border-bottom-width:1px;}
		#up ul li ul{display: none;}
		#up ul li{position:relative;margin-right: 2px;}
		#up ul li:hover ul{display:block;position: relative;}
		#main{width:70%;margin:0 auto;border-style:ridge;border-width: 1px;;height: 800px;margin-bottom: 40px;}
		#left{width:15%;height: 800px;text-align: left;float:left;text-align: center;background: #F0F8FF;}
		#rigth{width:80%;float:right;}
		#a1{text-align:left;margin-top:20px;border-bottom-style:ridge;border-bottom-width: 1px;margin-bottom: 10px;}
		#label{background:#F8F8FF;margin-bottom: 10px;height:30px;width:100%;border-style:ridge; border-width: 1px;}
		.label_1{display:inline-block;vertical-align: middle;}
		#label_1{width:35%;height: 100%;text-align: left;}
		#label_2{width:5%;height: 100%;}
		#label_3{width:5%;height: 100%;}
		#label_4{width:15%;height: 100%;}
		#label_5{width:10%;height: 100%;}
		#label_6{width:10%;height: 100%;text-align: right;}
		#label_7{width:10%;height: 100%;text-align: right;}
		.a2{width:100%;height:150px;display: block;border-style:ridge; border-width: 1px;margin-bottom: 10px;}
		.a2_1{height:30px;width: 100%;background:#F8F8FF;border-style:ridge; border-width: 1px;}
		.a2_1_1{width:35%;display:inline-block;text-align:left;vertical-align: middle;}
		.a2_1_2{width:40%;display:inline-block;text-align: left;vertical-align: middle;}		.a2_1_3{width:10%;display:inline-block;vertical-align: middle;}
		.a2_1_4{width:10%;display:inline-block;text-align:right;vertical-align: middle;margin-right:20px;}
		.a2_2{height:120px;width: 100%;}
		.a2_2_1{width:35%;height: 100%;display:inline-block;vertical-align: middle;vertical-align: middle;text-align: left;}
		.a2_2_1_1 img{width: 50px;}
		.a2_2_2{width:12%;height: 100%;display:inline-block;vertical-align: middle;}
		.a2_2_3{width:3%;height: 100%;display:inline-block;vertical-align: middle;}
		.a2_2_4{width:15%;height: 100%;display:inline-block;vertical-align: middle;border-left-style:ridge; border-width: 1px;}
		.a2_2_5{width:7%;height: 100%;display:inline-block;vertical-align: middle;border-left-style:ridge; border-width: 1px;}
		.a2_2_6{width:10%;height: 100%;display:inline-block;vertical-align: middle;border-left-style:ridge; border-width: 1px;}
		.a2_2_7{width:10%;height: 100%;display:inline-block;vertical-align: middle;border-left-style:ridge; border-width: 1px;}
		.d1{display:inline-block;height: 500px;margin:0px;width:15%;}
		.d2{width: 200px;height: 25px;}
		#top{margin-top: 20px;height:10%;}
		#on ul li{text-align:center;margin-bottom:20px;color:#0E0606;display: block;}
		#on ul li a:hover{background: #9F0C0E;color: aliceblue;}
	</style>

  </head>
  
  <body>
    <div id="zong">
     <%@ include file="Navigation1.jsp" %>
		<div id="main">
		<div id="left" class="d1" >
			<div id="top"><h3>个人信息</h3></div>
			<div id="on">
				<ul>
					<li><a href="OrderForm?user=${yh}">我的订单</a></li>
			<li><a href="ExaminePersonalInformation?user=${yh}">我的信息</a></li>
			</ul>
				</div>
			</div>
	    <div id="rigth" class="d1">
			<div id="a1"><h3>我的订单</h3></div>
			<div id="label">
				<div id="label_1" class="label_1">宝贝</div>
				<div id="label_2" class="label_1">影院</div>
				<div id="label_3" class="label_1">数量</div>
				<div id="label_4" class="label_1">观影时间</div>
				<div id="label_5" class="label_1">实付款</div>
				<div id="label_6" class="label_1">交易状态</div>	
				<div id="label_7" class="label_1">交易操作</div>
			</div>
			  <% 
			  String user= request.getParameter("user");
			  String pageNo=request.getParameter("pageno");
     int pageSize=4;//每页显示的项数
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
		String sql="SELECT * FROM 订单信息  WHERE user='"+user+"' ORDER BY time DESC"; 
		Statement Stmt=conn.createStatement();
		ResultSet rs = Stmt.executeQuery(sql);
		rs.last();
		rowCount=rs.getRow();
		pageCount=(rowCount+pageSize-1)/pageSize;
		if(pageCurrent>pageCount)
		pageCurrent=pageCount;
		if(pageCurrent<1)
		pageCurrent=1;
		rs.beforeFirst();
		rowCurrent=1;
	 while(rs.next()){
	 if(rowCurrent>(pageCurrent-1)*pageSize&&rowCurrent<=pageCurrent*pageSize){
	            String number=rs.getString("number");
				String FilmTitle= rs.getString("FilmTitle");
				String ordernumber=rs.getString("ordernumber");
				String quantity= rs.getString("quantity");
				String location= rs.getString("location");
				String time = rs.getString("time");
				String ViewingTime= rs.getString("ViewingTime");
				String price= rs.getString("price");
				String cinema=rs.getString("cinema");
				String payment=rs.getString("payment");
				%>
			<div class="a2">
			<div class="a2_1">
				<div class="a2_1_1"><%=time%></div><div class="a2_1_2">订单号:<%=ordernumber%></div>
				<div class="a2_1_3"><a href=""><img src="图片/21142dc564d2044094f82f82e543e0ff.png" style="width:15px;">和我联系</a></div>
				<div class="a2_1_4"><a href="DeleteOrdernumber?ordernumber=<%=ordernumber%>&user=${yh}"><img src="图片/b7a06059b3d470270193f7aa9a51352b.png" width="15px;"></a></div>
				</div>
			<div class="a2_2">
				 <div class="a2_2_1">
					<span class="a2_2_1_1"><a href="FilmMinute?FilmTitle=<%=FilmTitle%>"></a></span>
				  <span class="a2_2_1_1"><a href=""><%=FilmTitle%></a></span></div>
			          <div class="a2_2_2"><%=cinema%></div>
				       <div class="a2_2_3"><%=quantity%>张</div>				 
				<div class="a2_2_4"><%=ViewingTime%></div>
				<div class="a2_2_5">￥<%=price%></div>
				<div class="a2_2_6">			
				<a href="Zf?price=<%=price%>&ordernumber=<%=ordernumber%>&payment=<%=payment%>"><%=payment%></a>
				</div>
				<div class="a2_2_7"><a href="">评论</a></div>
				</div>
			</div>
			  <%
	        }
	        rowCurrent++;
	        }
	         %>
	         <form method="post" action="OrderForm?user=${yh}">
	        第<%=pageCurrent%>页 共<%=pageCount%>页&nbsp;
	        <%if(pageCurrent>1) {%>
	        <a href="OrderForm?user=${yh}?pageno=1">首页</a>
	        <a href="OrderForm?user=${yh}?pageno=<%=pageCurrent-1%>">上一页</a>
	        <%} %>&nbsp;
	        <%if(pageCurrent<pageCount){ %>
	        <a href="OrderForm?user=${yh}?pageno=<%=pageCurrent+1%>">下一页</a>
	        <a href="OrderForm?user=${yh}?pageno=<%=pageCount%>">尾页</a>
	        <%} %>&nbsp;跳转到第<input type="text" name="pageno" size="2" maxlength="5">页
	        <input name=submit" type="submit" value="GO">
 	        </form>
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
		<div id="footer">
		<p align="center">Copyringht&copy;科院（工程学院）</p></div>
		</div>
  </body>
</html>
