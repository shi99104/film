package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import film.Userinfo;

public class Adduser extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
	    String nickname = request.getParameter("nickname");
		String user= request.getParameter("user");
		String cipher= request.getParameter("cipher");
		String ciphers = request.getParameter("ciphers");
		String mob = request.getParameter("mob");
		if(nickname!=null&&nickname!=""&&user!=null&&user!=""&&cipher!=null&&cipher!=""&&ciphers!=null&&ciphers!=""&&mob!=null&&mob!=""){
		Userinfo i=new Userinfo();
		if(i.ChangeCipher(user)){
			request.setAttribute("massage", "�û����Ѵ��ڣ�����������");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}else{
		Userinfo tj= new Userinfo(nickname,user,cipher,mob);
		if(cipher.equals(ciphers)){
			if(tj. AddUser(tj)){
				request.setAttribute("massage", "ע��ɹ�");
				//response.sendRedirect("UserLanding.jsp");
				request.getRequestDispatcher("UserLanding.jsp").forward(request, response);
			}else{
				request.setAttribute("massage", "�û����Ѵ���");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("massage", "�������벻һ��");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}}
	}else{
		request.setAttribute("massage", "�����ֵ����Ϊ��");
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
	}
}
