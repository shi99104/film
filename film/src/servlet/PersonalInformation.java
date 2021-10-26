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
		//��ȡ�û���Ϣ�޸Ļ�鿴
		String user= request.getParameter("user");
		String nickname= request.getParameter("nickname");
		String mob= request.getParameter("mob");
		if(mob!=null){
			Userinfo gx=new Userinfo();
			//ͨ���û����޸��ǳƺ��ֻ���
			gx.updateInformation(nickname,mob,user);
			HttpSession session = request.getSession();//û��Session���½�һ��
		      session.setMaxInactiveInterval(10);
		   session.setAttribute("yh",user);
		   session.setAttribute("nc",nickname);
		   session.setAttribute("mob",mob);
				response.sendRedirect("PersonalInformation.jsp");
			}else{
				request.setAttribute("message", "�ֻ��Ų���Ϊ��");
				request.getRequestDispatcher("PersonalInformation.jsp").forward(request, response);
			}		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
