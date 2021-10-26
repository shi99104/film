<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="film.*,java.sql.*"%>
<html>
  <head>   
    <title>详细|电影</title>
   <style type="text/css">
		a{text-decoration: none;}
		ul{list-style-type:none;padding-left: 0px;}
        li{display:inline-block;}
		#zong{width:1300px; margin:0 auto; height: 2000px;}
		#header{width:100%;color:#BB68F2;background:}
		#div1{width: 1000px;}
		#div2{width:1000px;}
		.a1{display: inline-block;vertical-align:middle;}
		#div2-1{width:200px;}
		#div2-2{width:500px;}
		#div2-3{width:200px;}
	</style>
  </head>
  
  <body>
   <div id="zong">
	<div id="header">
	<%	
		try{
		Connection conn = ConnectionFactory.createConnection();
		String sql="select* FROM 电影信息 order by number"; 
		Statement Stmt=conn.createStatement();
		ResultSet rs = Stmt.executeQuery(sql);
		%>
		<% while(rs.next()){
				int number=rs.getInt("number");
				String FilmTitle= rs.getString("FilmTitle");
				String intrommend = rs.getString("intrommend");
				String director = rs.getString("director");
				String actor= rs.getString("actor");
				String region = rs.getString("region");
				String laguae = rs.getString("laguae");
				String type = rs.getString("type");
				String releasedate= rs.getString("releasedate");
				String movietime= rs.getString("movietime");
				String price = rs.getString("price");
				%>
		<div id="div1"><h3>命运之夜——天之杯3：春之歌</h3>
		<hr size="2" color="#F3E9E9"></div>
		<div id="div2">
		<div id="div2-1" class="a1"><img src="图片/天之杯3logo.jpg" width="170"></div>
			<div id="div2-2" class="a1">
			<table>
				<tr><td>导演：</td><td></td></tr>
				<tr><td>主演：</td><td></td></tr>
				<tr><td>类型：</td><td></td></tr>
				<tr><td>制作地区：</td><td></td></tr>
				<tr><td>语言：</td><td></td></tr>
				<tr><td>片场：</td><td></td></tr>
				<tr><td>剧情介绍：</td><td></td></tr>
				<%
				 }
	         %>
	        </table> 
	       <%}
	       catch(Exception e){
	       out.print(e.toString());
	       }
	        %>
				</table>
				</div>
			<div id="div2-3" class="a1">
				<p>上映时间：</p>
				<img src="图片/天之杯3.jpg" width="100">
				<img src="图片/天之杯3.jpg" width="100">
				</div>
		</div>
	</div>
	<div id="footer"></div>
		</div>
  </body>
</html>
