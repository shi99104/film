<%@ page language="java" import="java.util.*,film.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>管理员删除订单|后台系统</title>
    
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
    <% String ordernumber=request.getParameter("ordernumber");
       OrderformInfo sc=new OrderformInfo();
				sc.DeleteOrdernumber(ordernumber);
		//response.sendRedirect("HTddxx.jsp");
		out.print("<script>alert('删除成功！');window.location.href='HTddxx.jsp'</script>");
		%>
   </body>
</html>
