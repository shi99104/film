<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改|账号密码</title>
           <style type="text/css">
    a{text-decoration: none;}
	ul{list-style:none;}
	body{text-align: center;margin:0px;padding: 0px;}
		a{text-decoration: none;}
		#zong{width:100%; margin:0 auto; height: 2000px; }
		#up{width:100%; height:150px;text-align: left;}
		#left{width: 30%;text-align: left;margin-left: 80px;}
		#rigth{width: 50%;text-align: right;}
		.a1{display: inline-block;vertical-align:middle;}
		#main{width: 80%;margin:0 auto; height: 500px;}
		#shang h3{text-align: left;border-bottom-color:#DED0D1;border-style: none;border-bottom-style: solid;border-bottom-width: 3px;}
		#shang ul li{width:19%;height:20px;background:#2F6FBE;margin-left: 10px; display:inline-block;}
		#xia{margin:0 auto;height:300px;border:solid;border-width: 1px;}
		#xia table{text-align:center;}
	</style>
	<script type="text/javascript">
		 function checkpassword(){ 
                var div = document.getElementById("div3"); 
                div.innerHTML = ""; 
                var password = document.getElementById("text3").value; 
                if (password == "") { 
                div.innerHTML = "密码不能为空"; 
               document.getElementById("text3").focus(); 
                return false; 
            } 
                if (password.length < 8 || password.length > 16) { 
                div.innerHTML = "密码长度为8-16位"; 
                document.getElementById("text3").select(); 
                return false; 
                } 
				 div.innerHTML = "✓"; 
                return true; 
        }
	</script>	
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
				   <li  style="background:#DED0D1">确认账号</li><li style="background:#DED0D1">安全校验</li><li>设置密码</li><li style="background:#DED0D1">完成</li>
				   </ul></div>
			  <div id="xia" >
			  <% String user =request.getParameter("user");%>
			  <form action="AmenduserservletLogin3" method ="get">
				<table cellspacing="50">
					<tr><td><h4>亲爱的用户<%=user%>,请输入您要修改的密码</h4></td></tr>			  
				  <tr><td><input type="text" name="cipher" placeholder="请输入密码密码" style="width: 30%;height: 30px;border-style: none;border-bottom-style: solid;border-bottom-width: 1px;" size="150" onblur="checkpassword()" id="text3" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;"><span id="div3">*<span></td><td>${message}</td></tr>
				  <tr><td><input name="user" type="hidden" value=<%=user%>></td></tr>
					   <tr><td><input type="submit" value="下一步" style="background: #5889B8;"></td></tr>   
					 </table>
					 </form>
					  </div>
			  </div>
			  <div id="down">
		<p align="center">Copyringht&copy;科院（信息工程学院）</p></div>	
		</div>
  </body>
</html>

