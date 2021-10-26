<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>预订时间(下二天)|网上电影票预订系统</title>
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
		 #main{width:100%;margin: auto;position:relative;border-bottom-style:ridge;border-bottom-width:1px;height:520px;}
		 #div1{width:100%;height:30px;}
		#div2{width:100%;margin:0 auto;margin-bottom:10px;height: 430px;}
		.s1{display: inline-block;vertical-align:middle;height: 500px;}
		#div2-1{width:20%;}
		#div2-2{width:50%;margin-left:-80px;}
		#div2-3{width:20%;}
		.a2{display: inline-block;}
		.b1{display:inline-block;vertical-align:middle;}
		 .p1{font-size:20px;}
		 .p2{font-size:1px;font-weight:10;}
		 .d1{width:270px;}
		 .d2{width:200px;}
		#footer{width: 100%; height: 300px;}
		#time{margin-bottom:20px;margin-top:2px;}
		 #time ul li{margin-left:20px;display: inline-block;}
		#left{width:60%;}
		#rigth{width:30%;}
		#class_zong{width: 100%;height:80px;margin-top:10px;}
		.increment,.decrement{border: 1px solid #cacbcb; height: 20px;width: 20px;text-align: center; color: #666;margin: 0;}
			.increment{float: right;border: 1px solid #cacbcb; color: #666;}
			.decrement { float: left;}
			.decrement.disabled, .increment.disabled {cursor: default;color: #e9e9e9;}
			.itxt {border: 1px solid #cacbcb; width: 138px; height: 20px;text-align: center;font-size: 12px; font-family: verdana;color: #333;}
	</style>
<script src="js/jquery-1.11.0.min.js"></script>
		<script src="js/jiajian.js"></script>
	</style>

  </head>
  
  <body>
     <div id="header">
		<div id="ups1" class="b1">
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
			</div></div>		
	<div id="footer">
		<div id="time">	
			<ul>
			<%
			 Date t=new Date();  
			      int  m=t.getMonth()+1;
			      int  m2=t.getMonth()+1;
			      int  m3=t.getMonth()+1;
			       int d1=t.getDate()+1;
			       int d2=t.getDate()+2;
			       int d3=t.getDate()+3;
			    if(m==1||m==3||m==5||m==7||m==8||m==10||m==12){
			      if(d1>31||d2>31||d3>31){
			      m=m+d1/31;
			      m2=m2+d2/31;
			      m3=m3+d3/31;
			      d1=d1%31;
			      d2=d2%31;
			      d3=d3%31;
			      }
			    }if(m==2||m==4||m==6||m==9||m==11){
			    if(d1>30||d2>30||d3>30){
			    m=m+d1/30;
			    m2=m2+d2/30;
			    m3=m3+d3/30;
			    d1=d1%30; 
			    d2=d2%30;
			    d3=d3%30;
			    }
			    }
			  %>
				<span>观影时间:</span>
		      <li><a href="ReserveTime.jsp"><%=m%>月<%=d1%>日</a></li>
			<li><a href="ReserveTime2.jsp" style="border-bottom-style:ridge;">5月31日</a></li>
			<li><a href="ReserveTime3.jsp"><%=m3%>月<%=d3%>日</a></li>
			</ul>
		</div>
		<div id="class_zong" >
			<form action="ReserveTime">
		<table width="80%" align="center" height="60px">
			<tr><th class="d1">预订时间</th>
				<th  class="d2">语言</th>
				<th  class="d2">单价(元)</th>
				<th class="d2">数量</th>
				<th class="d2">购票</th>
				</tr>
			<tr align="center">
			<td><p class="p1">08:30</p><p class="p2">11:20散场</p></td>
			<td>${laguae}</td>
				<td>￥${monovalent}</td>
				<td>
				<input type="hidden" name="FilmTitle" value="${FilmTitle}">
				<input type="hidden" name="user" value="${user}">
				<input type="hidden" name="cinema" value="${cinema}">
				<input type="hidden" name="monovalent" value="${monovalent}">
				<input type="hidden" name="date" value="5月31日08:30">
					
					<a href="javascript:void(0)" class="decrement">-</a>
					<input type="text" name="quantity" value="1" title="请输入数量" maxlength="2"  class="itxt">
					<a href="javascript:void(0)" class="increment">+</a>
					</td>
				<td><input type="submit" value="购票"></td>
			</tr>
			</table>
			</form>
			<form action="ReserveTime">
		    <table width="80%" align="center" height="60px">
			<tr align="center">
			<td class="d1"><p class="p1">11:30</p><p class="p2">14:00散场</p></td>
			<td  class="d2">${laguae}</td>
				<td  class="d2">￥${monovalent}</td>
				<td class="d2">
				<input type="hidden" name="FilmTitle" value="${FilmTitle}">
				<input type="hidden" name="user" value="${user}">
				<input type="hidden" name="cinema" value="${cinema}">
				<input type="hidden" name="monovalent" value="${monovalent}">
				<input type="hidden" name="date" value="5月31日11:30">
					
					<a href="javascript:void(0)" class="decrement">-</a>
					<input type="text" name="quantity" value="1" title="请输入数量" maxlength="2"  class="itxt">
					<a href="javascript:void(0)" class="increment">+</a>
					</td>
				<td class="d2"><input type="submit" value="购票"></td>
			</tr>
			</table>
			</form>
			<form action="ReserveTime">
		<table width="80%" align="center" height="60px">
			<tr align="center">
			<td class="d1"><p class="p1">14:20</p><p class="p2">16:00散场</p></td>
			<td class="d2">${laguae}</td>
				<td class="d2">￥${monovalent}</td>
				<td class="d2">
				<input type="hidden" name="FilmTitle" value="${FilmTitle}">
				<input type="hidden" name="user" value="${user}">
				<input type="hidden" name="cinema" value="${cinema}">
				<input type="hidden" name="monovalent" value="${monovalent}">
				<input type="hidden" name="date" value="5月31日12:20">
					
					<a href="javascript:void(0)" class="decrement">-</a>
					<input type="text" name="quantity" value="1" title="请输入数量" maxlength="2"  class="itxt">
					<a href="javascript:void(0)" class="increment">+</a>
					</td>
				<td class="d2"><input type="submit" value="购票"></td>
			</tr>
			</table>
			</form>
			<form action="ReserveTime">
		<table width="80%" align="center" height="60px">
			<tr align="center">
			<td class="d1"><p class="p1">16:30</p><p class="p2">19:00散场</p></td>
			<td class="d2">${laguae}</td>
				<td class="d2">￥${monovalent}</td>
				<td class="d2">
				<input type="hidden" name="FilmTitle" value="${FilmTitle}">
				<input type="hidden" name="user" value="${user}">
				<input type="hidden" name="cinema" value="${cinema}">
				<input type="hidden" name="monovalent" value="${monovalent}">
				<input type="hidden" name="date" value="5月31日16:30">
					
					<a href="javascript:void(0)" class="decrement">-</a>
					<input type="text" name="quantity" value="1" title="请输入数量" maxlength="2"  class="itxt">
					<a href="javascript:void(0)" class="increment">+</a>
					</td>
				<td class="d2"><input type="submit" value="购票"></td>
			</tr>
			</table>
				</form>
		</div>
		</div>
  </body>
</html>