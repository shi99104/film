package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import film.Userinfo;

public class AmenduserservletLogin2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset-utf-8");
		//用户输入的手机号
		String user= request.getParameter("user");
		String mob= request.getParameter("mob");
		Userinfo yz = new Userinfo();
		if(mob!=null){
			if(yz.checkmob(user,mob)){
				response.sendRedirect("Amenduser3.jsp?user=\"" + user+ "\"");
			}else{
				request.setAttribute("message", "手机号不正确,请重新输入");
				request.getRequestDispatcher("Amenduser2.jsp?user=\"" + user+ "\"").forward(request, response);
			}
			}else{
				request.setAttribute("message", "请输入绑定的手机号,不能为空");
				request.getRequestDispatcher("Amenduser2.jsp?user=\"" + user+ "\"").forward(request, response);
			}		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
