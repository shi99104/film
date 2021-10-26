package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import film.Userinfo;

public class AmenduserservletLogin1 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1802184336132744543L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset-utf-8");
		//用户输入的用户名
		String user = request.getParameter("user");
		//验证用户名是否存在
			Userinfo ud = new Userinfo();
			if(user!=null){
			if(ud.ChangeCipher(user)){		
				response.sendRedirect("Amenduser2.jsp?user=\"" + user+ "\"");
			}else{
				request.setAttribute("message", "用户名不正确");
				request.getRequestDispatcher("Amenduser.jsp").forward(request, response);
			}
			}else{
				request.setAttribute("message", "请填写用户名,用户名不可为空");
				request.getRequestDispatcher("Amenduser.jsp").forward(request, response);
			}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
