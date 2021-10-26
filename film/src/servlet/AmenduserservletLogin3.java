package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import film.Userinfo;

public class AmenduserservletLogin3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset-utf-8");
		//用户输入修改的密码
		String user= request.getParameter("user");
		String cipher= request.getParameter("cipher");
		Userinfo yz = new Userinfo();
		if(cipher!=null){
			if(yz.updateCipher(cipher,user)){
				response.sendRedirect("Amenduser4.jsp");
			}
			}else{
				request.setAttribute("message", "请输入修改的密码,不能为空");
				request.getRequestDispatcher("Amenduser3.jsp?user=\"" + user+ "\"").forward(request, response);
			}		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
