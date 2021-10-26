package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import film.Userinfo;

public class ExaminePersonalInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset-utf-8");
		//��ȡ�û��ǳƲ鿴������Ϣ
		String user= request.getParameter("user");
		if(user!=null&&user!=""){
		String nickname=null,mob=null;	
			Userinfo qu = new Userinfo();
			List<Userinfo> li = qu.QueryUser(user);
			for(Userinfo n: li){
				nickname=n.getNickname();
				  mob=n.getMob();}
			HttpSession session = request.getSession();//û��Session���½�һ��
		      session.setMaxInactiveInterval(10);
		   session.setAttribute("yh",user);
		   session.setAttribute("nc",nickname);
		   session.setAttribute("mob",mob);
		   response.sendRedirect("PersonalInformation.jsp");
			//request.getRequestDispatcher("PersonalInformation.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "δ��¼�û����û���Ϣ�鿴");
			request.getRequestDispatcher("UserLanding.jsp").forward(request, response);
		}
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
