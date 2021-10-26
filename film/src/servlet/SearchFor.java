package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchFor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
	    String FilmTitle=request.getParameter("FilmTitle");//获取电影名
	    /*PrintWriter out = response.getWriter();
	    out.print(FilmTitle);*/
	    HttpSession session = request.getSession();//没有Session就新建一个
	      session.setMaxInactiveInterval(15);
	      session.setAttribute("FilmTitle",FilmTitle);
	  response.sendRedirect("SearchFor.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
