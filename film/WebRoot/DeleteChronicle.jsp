<%@ page language="java" import="java.util.*,film.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>历史记录删除|后台</title>
    
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
         History sc=new History();
	         sc.DeleteHistory(a);
		response.sendRedirect("Chronicle.jsp");
		   %>
  </body>
</html>
