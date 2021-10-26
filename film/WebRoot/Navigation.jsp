<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    
    <title>导航|网上电影票预订系统</title>
  <style type="text/css">
	*{padding: 0px;margin: 0px;}
		body{text-align: center;}
		a{text-decoration: none;}
		ul{list-style-type:none}
        li{display:inline-block;}
        #h1{margin-bottom: 30px;}
		#l1{background:#F5F5F5;height:30px;border-bottom-style:ridge;border-bottom-width:1px;width: 100%;}
		#l1 img{width:15px;}
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
		#y1{width:10%;}
		#y2{width:88%;}
		#e1 ul li ul li{width: 100%;line-height:20px;}
        #e1  ul li a:haver{background: #666;border-bottom: 1px dashed #ff0000;}
		#e1 ul li:hover ul{display:block;position:absolute;line-height: 20px;}
	</style>
    </head>
  
  <body>
  <div id="h1">
		<div id="l1" class="b1">
		<div id="e1" class="e1">
			<ul>
		<li><h4>欢迎光临本站</h4>
		<li><a href="UserLanding.jsp"><img src="图片/676062a938fb8ffffa2f8b9f7e938f57.png">${nc}</a>
	       <ul>
					<li><a href="ExaminePersonalInformation?nickname=${nc}">我的信息</a></li>
			        <li><a href="OrderForm?user=${yh}">我的订单</a></li>
					<li><a href="BowOut">退出登陆</a></li>
			</ul>
				</li>
		<li><a href=""><img src="图片/6b8718c62f648baf7b4661712c4c7dbd.png">信息</a></li>
		<li><a href=""><img src="图片/642afcc008d1ed3f29afb36f7a41e1ef.png">首页导航</a></li>
				</ul>
					</div>
		<div id="e2" class="e1"><a href="">
<ul>
		<li><a href="Chronicle.jsp"><img src="图片\9f54a1c9e84645f6d722bbc11fd7a5fd.png">历史记录</a></li>
		<li><a href="Suggestion.jsp"><img src="图片\59756b8962a7b8acafc9f4c5a757df90.png">投诉建议</a></li>
		<li><a href=""><img src="图片/9d3559a130737eb266be040fbb4d674e.png">联系客服</a></li>
		</ul></div>
		</div>			
		</div>
		<div id="y1" class="a1"><img src="图片/logo.jpg" width="200px" aligt></div>
		<div id="y2" class="a1">
			<form action="SearchFor"><input type="text" name="FilmTitle" size="60" placeholder="请输入你要观看的电影" style="width:500px;height: 30px;">
				  <input type="submit" name="submit" value="搜索" style="width:80px;height:33px;"></form>
		</div>
		<div id="down"></div>
		</div>
  </body>
</html>
