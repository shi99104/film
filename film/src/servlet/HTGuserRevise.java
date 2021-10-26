package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import film.Guserinfo;

public class HTGuserRevise extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8"); 
		int number=Integer.parseInt(request.getParameter("number")); 
		 String password=request.getParameter("password"); 
		 PrintWriter out = response.getWriter();
				if(number!=0&&password!=null){
					 Guserinfo xg=new Guserinfo();
					 xg.ReviseGuser(password,number);
				//response.sendRedirect("HTGuserxx.jsp");
				
				out.print("<script>alert('修改成功!');window.location.href='HTGuserxx.jsp'</script>");
				}else{
					//request.setAttribute("password", "密码不可为空");
					out.print("<script>alert('密码不可为空!');window.location.href='HTGuserReviser.jsp'</script>");
					//request.getRequestDispatcher("HTGuserReviser.jsp").forward(request, response);
				}
			}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
