<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>支付宝支付|网上电影票售票系统</title>
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
	  #down_1{width:90%;margin:auto;margin-bottom: 50px;height:20px;border-bottom-style:ridge;border-bottom-width: 1px;}
	  #down_1 span{margin-left:10px;padding:10px 10px 0px 10px;}
	  #down_2{width:100%;height:300px; text-align: center;}
	  #down_3{width:100%;text-align: right;}
	  #footer{margin-top:50px;}
	</style>

  </head>
  
  <body>
     <div id="header">
		 <div class="b1" id="up">
		<div class="e1" id="e1">
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
		<div class="a1" id="under"><img src="图片/logo.jpg" width="300px" height="80px"></div>
		</div>
	<div id="main">
	    <div id="on">
		    <div class="n" id="on_1"><h4>项目：网上电影票预订系统—订单编号：${ordernumber}</h4></div>
			<div class="n" id="on_2">应付金额￥${price}</div>
		</div>
		<div id="down">
			<div id="down_1">
				<span><a href="WXPayment.jsp">微信</a></span> <span style="border-style: ridge;border-width: 1px;border-bottom: none;"><a href="ZFBPayment.jsp">支付宝</a></span>
			</div>
			<div id="down_2">
				<img src="图片\zhifubao.jpg" Style="width:200px;height:200px;"></div>
			<div id="down_3">
			<form action="Paid">
			<input type="hidden" name=ordernumber value="${ordernumber}" >
				<input type="submit" value="已支付，返回订单">
				</form>
			</div>
			</div>
		</div>
	</div>
	<div id="footer">
		<p align="center">Copyringht©科院（信息工程学院）</p></div>	
  </body>
</html>