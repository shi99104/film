package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import film.Collectinfo;

/**
 * Servlet implementation class DeleteCollect
 */
public class DeleteCollect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset-utf-8");
			//获取查看的电影名字
			String FilmTitle=request.getParameter("FilmTitle");
			String user= request.getParameter("user");//用户名
			/*PrintWriter out=response.getWriter();//获取out对象
			out.println(FilmTitle+user);*/
				 Collectinfo sc=new Collectinfo();
				 //删除关注信息
					sc.DeleteCollectionfo(user,FilmTitle);
					HttpSession session = request.getSession();//没有Session就新建一个
				      session.setMaxInactiveInterval(0);
				      //session.setAttribute("yh",user);
				      session.setAttribute("FilmTitle",FilmTitle);
						response.sendRedirect("FilmDetailed.jsp");
			//request.getRequestDispatcher("FilmDetailed.jsp").forward(request, response);
			}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
