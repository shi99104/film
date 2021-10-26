  <%@ page language="java" import="java.util.*,film.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户投诉建议删除后台|后台系统</title>
    
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
       int a = Integer.parseInt(number);
       Suggestioninfo sc=new Suggestioninfo();
					sc.DeleteSuggestion(a);
		//response.sendRedirect("HTtsjyxx.jsp");
		out.print("<script>alert('用户投诉建议删除成功!');window.location.href='HTtsjyxx.jsp'</script>");
		%>
   </body>
</html>
