package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import film.Announcementinfo;
import film.Discussinfo;
import film.Userinfo;
public class addDiscussinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//��ȡǰ�������������Ϣ
				String discuss= request.getParameter("discuss");//������Ϣ
				HttpSession session = request.getSession();
				String nickname= (String) session.getAttribute("nc");//�û��ǳ�
				String FilmTitle= request.getParameter("FilmTitle");//��Ӱ��
				/*PrintWriter out = response.getWriter();
				out.print(discuss+nickname+FilmTitle);*/
				if(nickname!=""&&nickname!=null){
				if(discuss!=null&&FilmTitle!=null){						
					Discussinfo t=new Discussinfo(discuss,nickname,FilmTitle);
					t.AddDiscussinfo(t);
						response.sendRedirect("FilmDetailed.jsp");
						}else{
							request.setAttribute("pl", "���۲���Ϊ��");
							response.sendRedirect("FilmDetailed.jsp");
						}
				}else{
							request.setAttribute("message", "��¼�û�����Ӱ����");
							request.getRequestDispatcher("UserLanding.jsp").forward(request, response);
						}	
						}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
