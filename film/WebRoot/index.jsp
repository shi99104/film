<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
    
    <title>首页|网上电影票预订系统</title>
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
		#up1{height: 30px;text-align: left;border-bottom-style:ridge;border-bottom-width:1px;}
		#up1 ul li{width: 100px;vertical-align: middle;margin-left:50px;}
		#down1{height:300px;}
		#main{display:inline;}
		#footer{margin:auto;margin-top:-100px;width:80%;}
		#footer ul li{width: 100%;margin-top:10px;padding-bottom:5px;}
		#footer ul li ul li{width:15%;margin-left: 30px;vertical-align:middle}
		#footer ul li h3{background:#E4E4E4;}
		#footer img{width:100px;height:150px; }
#flash{width:1000px;height: 500px;margin: 10px auto;position: relative;}
#flash img{width: 1000px; height:400px;}
#flash #play{width:1000px;height:400px;list-style: none;position:absolute;top:0px;left:0px;}
#flash #play li{display: none;position:absolute;top:0px;left:0px;}
#flash #play li img{float: left;}
#button{position: absolute;bottom: 120px; left:400px;list-style:none;}
#button li{margin-left: 20px;float: left;}
#button li div{width:12px;height: 12px;background:#DDDDDD;border-radius: 6px;cursor: pointer;}
#prev{width:40px;height:63px;background:url(images/beijing.png) 0px 0px;position: absolute;top:150px;left:10px;z-index: 1000;}
#next{width:40px;height:63px;background:url(images/beijing.png) -40px 0px;position: absolute;top:150px;right:10px;z-index: 1000;}
#prev:hover{background:url(images/beijing.png) 0px -62px;}
#next:hover{background:url(images/beijing.png) -40px -62px;}
#xia{width:100%;margin:auto;text-align: center;padding: 0px;margin-top:30px;}
</style>
<script type="text/javascript" src="js/script.js"></script>
  </head>
  
  <div id="zong" >
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
		<li><a href="Chronicle.jsp"><img src="图片/9f54a1c9e84645f6d722bbc11fd7a5fd.png">历史记录</a></li>
		<li><a href="Suggestion.jsp"><img src="图片/59756b8962a7b8acafc9f4c5a757df90.png">投诉建议</a></li>
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
			<div id="up1">
				<ul>
					<li style="margin-left:150px;"><a href="index.html" class="ys1">首页</a></li>
		<li><a href="announcement.jsp">网站公告</a></li>
			<li><a href="wholefilm.jsp">全部电影</a></li></ul>
			</div>
		  <div id="flash">
     <div id="prev"></div>
     <div id="next"></div>
	 <ul id="play">
	 	<li style="display: block;"><a href="FilmMinute?FilmTitle=让子弹飞"><img src="图片/让子弹飞海报.jpg" alt=""/></a></li>
	 	<li><a href="FilmMinute?FilmTitle=刀剑神域：序列之争"><img src="图片/序列之争海报.jpg" alt=""  /></a></li>
	 	<li><a href="FilmMinute?FilmTitle=你的名字"><img src="图片/你的名字1.jpg" alt="" /></a></li>
	 	<li><img src="图片/西虹市首富1.jpg" alt="" /></li>
	 	<li><a href="FilmMinute?FilmTitle=调音师"><img src="图片/调音师1.jpg" alt="" /></a></li>
	 	<li><a href="FilmMinute?FilmTitle=命运之夜——天之杯3"><img src="图片/天之杯3海报.jpg" alt=""  /></a></li>
	 	<li><img src="图片/小妇人海报.jpg" alt=""/></li>
	 	<li><img src="图片/绿皮书海报.jpg" alt="" /></li>
	 </ul>
	 <ul id="button">
	 	<li><div style="background: #A10000;"></div></li>
	 	<li><div></div></li>
	 	<li><div></div></li>
	 	<li><div></div></li>
	 	<li><div></div></li>
	 	<li><div></div></li>
	 	<li><div></div></li>
	 	<li><div></div></li>
	 </ul>
 </div>
		</div>
			<div id="footer">
				<ul>
		<li><a href="Screen?type=动画" class="a2"><h3>动画</h3></a></li>
		<li><ul>
				<li><a href="FilmMinute?FilmTitle=刀剑神域：序列之争"><img src="图片/刀剑神域.jpg"  alt="刀剑神域：序列之争" title="刀剑神域：序列之争"/></a>
	<a href="FilmMinute?FilmTitle=刀剑神域：序列之争"><p>刀剑神域：序列之争</p></a></li>
			<li><a href="FilmMinute?FilmTitle=你的名字"><img src="图片/你的名字.jpg"  alt="你的名字" title="你的名字"/></a>
	<a href="FilmMinute?FilmTitle=你的名字"><p>你的名字</p></a></li>
			<li><a href="FilmMinute?FilmTitle=命运之夜——天之杯3"><img src="图片/天之杯3.jpg"  alt="你的名字" title="命运之夜——天之杯3"/></a>
	<a href="FilmMinute?FilmTitle=命运之夜——天之杯3"><p>命运之夜——天之杯3</p></a></li>
			<li><a href="FilmMinute?FilmTitle=天气之子"><img src="图片/天气之子.jpg"  alt="天气之子" title="天气之子"/></a>
	<a href="FilmMinute?FilmTitle=天气之子"><p>天气之子</p></a></li>
			<li><a href="FilmMinute?FilmTitle=游戏人生 零"><img src="图片/游戏人生.jpg"  alt="游戏人生 零 " title="游戏人生 零 "/></a>
	<a href="FilmMinute?FilmTitle=游戏人生 零"><p>游戏人生 零</p></a></li>
			</ul></li>
					<li class="a2"><a href="Screen?type=科幻"><h3>科幻</h3></a></li>
				<li><ul>
				<li><a href="FilmMinute?FilmTitle=环太平洋"><img src="图片/环太平洋.jpg"  alt="环太平洋" title="环太平洋"/></a>
	<a href="FilmMinute?FilmTitle=环太平洋"><p>环太平洋</p></a></li>
					<li><a href="FilmMinute?FilmTitle=信条"><img src="图片/信条.jpg"  alt="信条" title="信条"/></a>
	<a href="FilmMinute?FilmTitle=信条"><p>信条</p></a></li>
					<li><a href="FilmMinute?FilmTitle=黑客帝国"><img src="图片/黑客帝国.jpg"  alt="黑客帝国" title="黑客帝国"/></a>
	<a href="FilmMinute?FilmTitle=黑客帝国"><p>黑客帝国</p></a></li>
					<li><a href="FilmMinute?FilmTitle=盗梦空间"><img src="图片/盗梦空间.jpg"  alt="盗梦空间" title="盗梦空间"/></a>
	<a href="FilmMinute?FilmTitle=盗梦空间"><p>盗梦空间</p></a></li>
					<li><a href="FilmMinute?FilmTitle=无姓之人"><img src="图片/无姓之人.jpg" alt="无姓之人" title="无姓之人"/></a>
	<a href="FilmMinute?FilmTitle=无姓之人"><p>无姓之人</p></a></li>
				</ul></li>
				<li><a href="Screen?type=喜剧" class="a2"><h3>喜剧</h3></a></li>
				<li><ul>
				<li><a href="FilmMinute?FilmTitle=让子弹飞"><img src="图片/让子弹飞.png"  alt="让子弹飞" title="让子弹飞"/></a>
	<a href="FilmMinute?FilmTitle=让子弹飞"><p>让子弹飞</p></a></li>
					<li><a href="FilmMinute?FilmTitle=西虹市首富"><img src="图片/西虹市首富.jpg"  alt="西虹市首富 " title="西虹市首富 "/></a>
	<a href="FilmMinute?FilmTitle=西虹市首富"><p>西虹市首富</p></a></li>
					<li><a href="FilmMinute?FilmTitle=邪不压正"><img src="图片/邪不压正.jpeg"  alt="邪不压正" title="邪不压正"/></a>
	<a href="FilmMinute?FilmTitle=邪不压正"><p>邪不压正</p></a></li>
					<li><a href="FilmMinute?FilmTitle=飞驰人生"><img src="图片/飞驰人生.jpg"  alt="飞驰人生" title="飞驰人生"/></a>
	<a href="FilmMinute?FilmTitle=飞驰人生"><p>飞驰人生</p></a></li>
					<li><a href="FilmMinute?FilmTitle=调音师"><img src="图片/调音师.png"  alt="调音师 " title="调音师 "/></a>
	<a href="FilmMinute?FilmTitle=调音师"><p>调音师</p></a></li>
				</ul></li>
				
				</ul>
		</div>
		<div id="xia">
			<p>Copyringht&copy;科院（信息工程学院）</p>
	</div>
</body>
</html>
