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
		//跳转
		response.sendRedirect("Suggestion.jsp");
		
	}
	//随机一个验证码
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
				request.setAttribute("xx", "建议已成功提交");
				request.getRequestDispatcher("Suggestion.jsp").forward(request, response);
				//response.sendRedirect("Suggestion.jsp");
			}else{
				request.setAttribute("xx", "验证码输入错误，请重新输入");
				request.getRequestDispatcher("Suggestion.jsp").forward(request, response);
				//response.sendRedirect("Suggestion.jsp");
			}
			}else{
				request.setAttribute("xx", "建议不可为空，请你认真对此系统进行建议，谢谢");
				request.getRequestDispatcher("Suggestion.jsp").forward(request, response);
				//response.sendRedirect("Suggestion.jsp");
			}
		}else{
			request.setAttribute("message", "登陆用户才可投诉建议，请你登陆再试");
			request.getRequestDispatcher("UserLanding.jsp").forward(request, response);
		}
	}

}
