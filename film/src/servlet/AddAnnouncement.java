package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import film.Announcementinfo;
import film.Userinfo;

public class AddAnnouncement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8");
		//获取前端输入的公告信息
		String announcement= request.getParameter("announcement");
		String user= request.getParameter("user");
		PrintWriter out=response.getWriter();
			if(announcement!=null){
				Announcementinfo tj=new Announcementinfo(user,announcement);
				tj.AddAnnouncement(tj);				
				//response.sendRedirect("HTggxx.jsp");
             out.print("<script>alert('公告添加成功!');window.location.href='HTggxx.jsp'</script>");
			}else{
				request.setAttribute("gg", "公告不可为空！");
				request.getRequestDispatcher("HTggtj.jsp").forward(request, response);
			}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
