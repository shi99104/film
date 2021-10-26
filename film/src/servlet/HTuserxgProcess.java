package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import film.Guserinfo;
import film.Userinfo;

public class HTuserxgProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8");
		int number=Integer.parseInt(request.getParameter("number")); 
		String nickname=request.getParameter("nickname");
		String cipher=request.getParameter("cipher");
		 String mob=request.getParameter("mob"); 
		 PrintWriter out=response.getWriter();
				if(number!=0&&nickname!=null&&cipher!=null&&mob!=null){
					Userinfo xg=new Userinfo();
					xg.Reviseuser(nickname,cipher,mob,number);
				//response.sendRedirect("HTuserxx.jsp");
				out.print("<script>alert('用户信息修改成功!');window.location.href='HTuserxx.jsp'</script>");
				}else{
					//request.setAttribute("text", "可修改信息不可为空");
					//request.getRequestDispatcher("userProcess.jsp").forward(request, response);
					out.print("<script>alert('可修改信息不可为空!');window.location.href='userProcess.jsp'</script>");
				}
			}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
