<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '1.jsp' starting page</title>
    
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
     <div id="time">	
			  <ul>
			<%
			 Date t=new Date();  
			      int  m=t.getMonth()+1;
			      int  m2=t.getMonth()+1;
			      int  m3=t.getMonth()+1;
			       int d1=t.getDate()+1;
			       int d2=t.getDate()+2;
			       int d3=t.getDate()+3;
			    if(m==1||m==3||m==5||m==7||m==8||m==10||m==12){
			      if(d1>31||d2>31||d3>31){
			      m=m+d1/31;
			      m2=m2+d2/31;
			      m3=m3+d3/31;
			      d1=d1%31;
			      d2=d2%31;
			      d3=d3%31;
			      }
			    }if(m==2||m==4||m==6||m==9||m==11){
			    if(d1>30||d2>30||d3>30){
			    m=m+d1/30;
			    m2=m2+d2/30;
			    m3=m3+d3/30;
			    d1=d1%30; 
			    d2=d2%30;
			    d3=d3%30;
			    }
			    }
			  %>
				<span>观影时间:</span>
		      <li><a href="ReserveTime.jsp" style="border-bottom-style:ridge;"><%=m%>月<%=d1%>日</a></li>
			<li><a onclick.href="ReserveTime2.jsp"><%=m2%>月<%=d2%>日</a></li>
			<li><a href="../ReserveTime3.jsp"><%=m3%>月<%=d3%>日</a></li>
			</ul>
		</div>
		<div ><a href="ReserveTime2.jsp"><%=m2%>月<%=d2%>日</a></div>
  </body>
</html>
