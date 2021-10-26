package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import film.Collectinfo;

public class AddCollect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
			//获取购买的电影票的电影名字
			String FilmTitle=request.getParameter("FilmTitle");//影院名称
			String user= request.getParameter("user");//用户名		
			PrintWriter out=response.getWriter();//获取out对象
			out.println(FilmTitle+user);
			out.println(user.length());
			if(user!=""&&user!=null){
				Collectinfo  tj=new Collectinfo (user,FilmTitle);
				tj.AddCollect(tj);
					response.sendRedirect("FilmDetailed.jsp");
				
			//request.getRequestDispatcher("FilmDetailed.jsp").forward(request, response);
			}else{			
				request.setAttribute("message", "登陆用户才可关注");
				request.getRequestDispatcher("UserLanding.jsp").forward(request, response);
				}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
