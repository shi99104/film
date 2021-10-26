package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import film.Guserinfo;
import film.Userinfo;

public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
	    String chapter=request.getParameter("chapter");    
		//����Ա������û���������
			String user = request.getParameter("user");
			String password = request.getParameter("password");
			Guserinfo ud = new Guserinfo();
			if(ud.checkGPassword(user,password)){
				HttpSession session = request.getSession();//û��Session���½�һ��
				      session.setMaxInactiveInterval(0);;
				   session.setAttribute("gly",user);
			response.sendRedirect("HTGuserxx.jsp");
			}else{
				request.setAttribute("message", "�û��������벻��ȷ");
				request.getRequestDispatcher("AdministratorLanding.jsp").forward(request, response);
			}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
