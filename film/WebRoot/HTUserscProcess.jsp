<%@ page language="java" import="java.util.*,film.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>管理员删除用户|后台系统</title>

   </head>
  
  <body>
      <%
      String number=request.getParameter("number");
       int a = Integer.parseInt(number);
      Userinfo sc=new Userinfo();
	   sc.DeleteComtent(a);
		//response.sendRedirect("HTuserxx.jsp");
		out.print("<script>alert('用户信息删除成功!');window.location.href='HTuserxx.jsp'</script>");
       %>
  </body>
</html>
