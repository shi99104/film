package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import film.Guserinfo;
import film.cinemainfo;

public class HTyyxxRevise extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8");
		int number=Integer.parseInt(request.getParameter("number")); 
		 String file=request.getParameter("file"); 
		 String cinema=request.getParameter("cinema");  
		 String town=request.getParameter("town");  
		 String address=request.getParameter("address");  
		 String mob=request.getParameter("mob");  
		 int Atstarting=Integer.parseInt(request.getParameter("Atstarting"));  
		 String remarks=request.getParameter("remarks"); 
		 PrintWriter out=response.getWriter();
				if(number!=0&&cinema!=null&&town!=null&&address!=null&&mob!=null&&Atstarting!=0){
					cinemainfo xg=new cinemainfo();
					xg.Revisecinema(file,cinema,town,address,mob,Atstarting,remarks,number);
					out.print("<script>alert('影院信息修改成功!');window.location.href='HTyyxx.jsp'</script>");
					
				//response.sendRedirect("HTyyxx.jsp");
				}else{
					request.setAttribute("yy", "除文件位置其他不可为空");
					request.getRequestDispatcher("HTyyxxReviser.jsp").forward(request, response);
				}
			}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
