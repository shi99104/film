<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zk.jsp' starting page</title>
<style>
*{padding: 0px;margin: 0px;}
#flash{width:1200px;height: 535px;margin: 50px auto;position: relative;}
#flash #play{width:1200px;height: 535px;list-style: none;position:absolute;top:0px;left:0px;}
#flash #play li{display: none;position:absolute;top:0px;left:0px;}
#flash #play li img{float: left;}
#button{position: absolute;bottom:20px;left:470px;list-style: none;}
#button li{margin-left: 10px;float: left;}
#button li div{width:12px;height: 12px;background:#DDDDDD;border-radius: 6px;cursor: pointer;}
#prev{width:40px;height:63px;background:url(images/beijing.png) 0px 0px;position: absolute;top:205px;left:10px;z-index: 1000;}
#next{width:40px;height:63px;background:url(images/beijing.png) -40px 0px;position: absolute;top:205px;right:10px;z-index: 1000;}
#prev:hover{background:url(images/beijing.png) 0px -62px;}
#next:hover{background:url(images/beijing.png) -40px -62px;}
</style>

<script type="text/javascript" src="js/script.js"></script>

  </head>
  
  <body>
   <div id="flash">
     <div id="prev"></div>
     <div id="next"></div>
	 <ul id="play">
	 	<li style="display: block;"><img src="images/1.jpg" alt="" /></li>
	 	<li><img src="images/2.jpg" alt="" /></li>
	 	<li><img src="images/3.jpg" alt="" /></li>
	 	<li><img src="images/4.jpg" alt="" /></li>
	 	<li><img src="images/5.jpg" alt="" /></li>
	 	<li><img src="images/6.jpg" alt="" /></li>
	 	<li><img src="images/7.jpg" alt="" /></li>
	 	<li><img src="images/8.jpg" alt="" /></li>
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
    
  </body>
</html>
