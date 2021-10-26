package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Screen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
	    String age=request.getParameter("age");//��ȡ���
	    String area=request.getParameter("area");//��ȡ����
	    String type=request.getParameter("type");//��ȡ����
	    /*PrintWriter out = response.getWriter();
	    out.print(FilmTitle);*/
	    if(age!=""&age!=null){
	    HttpSession session = request.getSession();//û��Session���½�һ��
	      session.setMaxInactiveInterval(10);
	      session.setAttribute("age",age);      
	   response.sendRedirect("age.jsp");
	   }
	    else if(area!=""&area!=null){
	    	HttpSession session = request.getSession();//û��Session���½�һ��
		      session.setMaxInactiveInterval(10);
		      session.setAttribute("area",area);
		      response.sendRedirect("area.jsp");
	    }else if(type!=""&type!=null){
	    	HttpSession session = request.getSession();//û��Session���½�һ��
		      session.setMaxInactiveInterval(10);
		      session.setAttribute("type",type); 
		      response.sendRedirect("type.jsp");
    }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
