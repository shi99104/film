package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import film.Suggestioninfo;

public class Suggestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;utf-8");
		request.getSession().setAttribute("yzm", getCode());
		request.getSession().setMaxInactiveInterval(120);
		//��ת
		response.sendRedirect("Suggestion.jsp");
		
	}
	//���һ����֤��
		private String getCode(){
			String code = "";
			Random random = new Random();
			for(int i=0;i<3;i++){
				code = code + random.nextInt(10);
			}
			for(int i=0;i<3;i++){
				code += (char)(random.nextInt(26)+97);
			}
			return code;
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
		String  suggestion=request.getParameter("suggestion");
		String user=request.getParameter("user");
		String code = request.getParameter("code");
		String codes = request.getSession().getAttribute("yzm").toString();
		/*PrintWriter out = response.getWriter(); 
		out.print(user+suggestion);*/
		if(user!=""&&user!=null){
			if(suggestion!=""&&suggestion!=null){
			if(code.equals(codes)){
				Suggestioninfo t=new Suggestioninfo(user,suggestion);
				t.AddSuggestioninfo(t);
				request.setAttribute("xx", "�����ѳɹ��ύ");
				request.getRequestDispatcher("Suggestion.jsp").forward(request, response);
				//response.sendRedirect("Suggestion.jsp");
			}else{
				request.setAttribute("xx", "��֤�������������������");
				request.getRequestDispatcher("Suggestion.jsp").forward(request, response);
				//response.sendRedirect("Suggestion.jsp");
			}
			}else{
				request.setAttribute("xx", "���鲻��Ϊ�գ���������Դ�ϵͳ���н��飬лл");
				request.getRequestDispatcher("Suggestion.jsp").forward(request, response);
				//response.sendRedirect("Suggestion.jsp");
			}
		}else{
			request.setAttribute("message", "��½�û��ſ�Ͷ�߽��飬�����½����");
			request.getRequestDispatcher("UserLanding.jsp").forward(request, response);
		}
	}

}
