<%@ page language="java" import="java.util.*,com.jspsmart.upload.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'scwjs.jsp' starting page</title>
    
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
    
    <% 
    try{
			//新建一个 SmartUpload 对象
			SmartUpload s=new SmartUpload();
			//上传初始化
			s.initialize(getServletConfig(), request,response);
			//设置允许上传的单个文件的最大长度，在此为100MB
			s.setMaxFileSize(100*1024*1024);
			//设置允许上传的文件的类型
			s.setAllowedFilesList("bmp,jpg,png,tif,gif,pcx,tga,exif,fpx,svg,psd,cdr,pcd,dxf,ufo,eps,ai,raw,WMF,webp");
			//设置禁止上传的文件的类型
			//在此为exe、bat、jsp、htm与html文件以及没有扩展名的文件
			s.setDeniedFilesList("jsp,htm,,");
			//上传文件
			s.upload();
			//将上传的文件全部保存到指定目录中
			s.save("D:/myeclipse2017/zye/film/WebRoot/images",2);
			File f=s.getFiles().getFile(0);
					out.println("文件上传成功<br><br>");
				out.println("文件"+":"+f.getFileName()+"("+f.getSize()+"字节)<br>");
			
		}catch(Exception e){
			out.println("上传文件失败！");
		}
    %>
  </body>
</html>
