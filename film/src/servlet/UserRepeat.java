package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import film.Userinfo;

public class UserRepeat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset-utf-8");
		//�û�������û���
		PrintWriter out = response.getWriter();
		String user= request.getParameter("user");
		Userinfo i=new Userinfo();
        if(i.ChangeCipher(user)){
			out.print("�û�������ʹ�ã�����������");
			}else{
			out.print("�û�����ʹ��");
			}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
