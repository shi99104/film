package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import film.OrderformInfo;
import film.Userinfo;

public class CinemaSelectProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset-utf-8"); 
		//��ȡ����ĵ�ӰƱ�ĵ�Ӱ����
		String cinema=request.getParameter("cinema");//ӰԺ����
		String  user=request.getParameter("user");//�û���
		String FilmTitle=request.getParameter("FilmTitle");//��Ӱ����
		String laguae=request.getParameter("laguae");//����
		int monovalent=Integer.parseInt(request.getParameter("price"));//�۸�	
		//int price=Integer.parseInt(request.getSession().getAttribute("price").toString());//�۸�
		HttpSession session = request.getSession();//û��Session���½�һ��
	      session.setMaxInactiveInterval(120);
	      session.setAttribute("cinema",cinema);
		   session.setAttribute("user", user);
		   session.setAttribute("FilmTitle",FilmTitle);
		   session.setAttribute("laguae",laguae);
		   session.setAttribute("monovalent",monovalent);
		   response.sendRedirect("ReserveTime.jsp");
		    //request.getRequestDispatcher("ReserveTime.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
