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
		//获取购买的电影票的电影名字
		String cinema=request.getParameter("cinema");//影院名称
		String  user=request.getParameter("user");//用户名
		String FilmTitle=request.getParameter("FilmTitle");//电影名称
		String laguae=request.getParameter("laguae");//语言
		int monovalent=Integer.parseInt(request.getParameter("price"));//价格	
		//int price=Integer.parseInt(request.getSession().getAttribute("price").toString());//价格
		HttpSession session = request.getSession();//没有Session就新建一个
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
