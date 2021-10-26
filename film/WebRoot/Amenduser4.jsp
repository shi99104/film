<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
        <style type="text/css">
        a{text-decoration: none;}
	    ul{list-style:none;}
	    body{text-align: center;margin:0px;padding: 0px;}
		#zong{width:100%; margin:0 auto; height: 2000px; }
		#up{width:100%; height:150px;text-align: left;}
		#left{width: 30%;text-align: left;margin-left: 80px;}
		#rigth{width: 50%;text-align: right;}
		.a1{display: inline-block;vertical-align:middle;}
		#main{width: 80%;margin:0 auto; height: 500px;}
		#shang h3{text-align: left;border-bottom-color:#DED0D1;border-style: none;border-bottom-style: solid;border-bottom-width: 3px;}
		#shang ul li{width:19%;height:20px;background:#2F6FBE;margin-left: 10px; display:inline-block;}
		#xia{margin:0 auto;height:300px;border:solid;border-width: 1px;}
	</style>

  </head>
  
  <body>
  <div id="zong">
			  <div id="up" >
				  <div id="left" class="a1"><img src="图片/logo.jpg" width="300px" height="80px"></div>
			      <div id="rigth" class="a1">已有账号？<a href="UserLanding.jsp">登陆</a></div>
				  <hr color="#1850BB">
			  </div>
		       <div id="main">
			  <div id="shang"><h3>找回登陆密码</h3>
				   <ul>
				   <li  style="background:#DED0D1">确认账号</li><li  style="background:#DED0D1">安全校验</li><li class="a2" style="background:#DED0D1">设置密码</li><li>完成</li>
				   </ul></div>
			  <div id="xia" align="center">
			  
				<table  cellspacing="40">
					<tr><td><h4>密码修改成功</h4></td></tr>
				  
					   <tr align="center"><td>
					   <a href="UserLanding.jsp"><button type="button" style="background: #5889B8;">完成</button></a></td></tr>
				    </table>
				 
					  </div>
			  </div>
			  <div id="down">
		<p align="center">Copyringht&copy;科院（信息工程学院）</p></div>	
		</div>
  </body>
</html>
