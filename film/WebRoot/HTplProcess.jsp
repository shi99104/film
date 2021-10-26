<%@ page language="java" import="java.util.*,film.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>管理员删除评论|后台系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <% String number=request.getParameter("number");
       int a= Integer.parseInt(number);
       Discussinfo sc=new Discussinfo();
			sc.DeleteDiscuss(a);
		//response.sendRedirect("HTplxx.jsp");
		out.print("<script>alert('影评删除成功！');window.location.href='HTplxx.jsp'</script>");
		%>
   </body>
</html>

