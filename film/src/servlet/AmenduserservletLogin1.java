package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import film.Userinfo;

public class AmenduserservletLogin1 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1802184336132744543L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset-utf-8");
		//�û�������û���
		String user = request.getParameter("user");
		//��֤�û����Ƿ����
			Userinfo ud = new Userinfo();
			if(user!=null){
			if(ud.ChangeCipher(user)){		
				response.sendRedirect("Amenduser2.jsp?user=\"" + user+ "\"");
			}else{
				request.setAttribute("message", "�û�������ȷ");
				request.getRequestDispatcher("Amenduser.jsp").forward(request, response);
			}
			}else{
				request.setAttribute("message", "����д�û���,�û�������Ϊ��");
				request.getRequestDispatcher("Amenduser.jsp").forward(request, response);
			}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
