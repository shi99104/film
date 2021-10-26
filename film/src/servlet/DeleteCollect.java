package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import film.Collectinfo;

/**
 * Servlet implementation class DeleteCollect
 */
public class DeleteCollect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset-utf-8");
			//��ȡ�鿴�ĵ�Ӱ����
			String FilmTitle=request.getParameter("FilmTitle");
			String user= request.getParameter("user");//�û���
			/*PrintWriter out=response.getWriter();//��ȡout����
			out.println(FilmTitle+user);*/
				 Collectinfo sc=new Collectinfo();
				 //ɾ����ע��Ϣ
					sc.DeleteCollectionfo(user,FilmTitle);
					HttpSession session = request.getSession();//û��Session���½�һ��
				      session.setMaxInactiveInterval(0);
				      //session.setAttribute("yh",user);
				      session.setAttribute("FilmTitle",FilmTitle);
						response.sendRedirect("FilmDetailed.jsp");
			//request.getRequestDispatcher("FilmDetailed.jsp").forward(request, response);
			}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
