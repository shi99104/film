package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import film.Collectinfo;

public class AddCollect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
			//��ȡ����ĵ�ӰƱ�ĵ�Ӱ����
			String FilmTitle=request.getParameter("FilmTitle");//ӰԺ����
			String user= request.getParameter("user");//�û���		
			PrintWriter out=response.getWriter();//��ȡout����
			out.println(FilmTitle+user);
			out.println(user.length());
			if(user!=""&&user!=null){
				Collectinfo  tj=new Collectinfo (user,FilmTitle);
				tj.AddCollect(tj);
					response.sendRedirect("FilmDetailed.jsp");
				
			//request.getRequestDispatcher("FilmDetailed.jsp").forward(request, response);
			}else{			
				request.setAttribute("message", "��½�û��ſɹ�ע");
				request.getRequestDispatcher("UserLanding.jsp").forward(request, response);
				}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
