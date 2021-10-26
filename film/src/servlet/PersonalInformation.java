package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import film.Userinfo;

public class PersonalInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset-utf-8");
		//获取用户信息修改或查看
		String user= request.getParameter("user");
		String nickname= request.getParameter("nickname");
		String mob= request.getParameter("mob");
		if(mob!=null){
			Userinfo gx=new Userinfo();
			//通过用户名修改昵称和手机号
			gx.updateInformation(nickname,mob,user);
			HttpSession session = request.getSession();//没有Session就新建一个
		      session.setMaxInactiveInterval(10);
		   session.setAttribute("yh",user);
		   session.setAttribute("nc",nickname);
		   session.setAttribute("mob",mob);
				response.sendRedirect("PersonalInformation.jsp");
			}else{
				request.setAttribute("message", "手机号不能为空");
				request.getRequestDispatcher("PersonalInformation.jsp").forward(request, response);
			}		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
