package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import film.Userinfo;

@SuppressWarnings("serial")
public class Login extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;utf-8");
		request.getSession().setAttribute("Vcode", getCode());
		request.getSession().setMaxInactiveInterval(120);
		//跳转
		response.sendRedirect("UserLanding.jsp");
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset-utf-8");
		//用户输入的验证码
		String code = request.getParameter("codes");
		//判断用户输入的验证码是否正确
		String codes = request.getSession().getAttribute("Vcode").toString();
		//如果验证码正确，验证用户名密码正确性
		String user = request.getParameter("user");
		String cipher = request.getParameter("cipher");
		if(user!=""&&user!=null&&cipher!=""&&cipher!=null){
		if(code.equals(codes)){		
			Userinfo ud = new Userinfo();
			if(ud.checkPassword(user,cipher)){
				List<Userinfo> li = ud.QueryNickname(user);
				String nc=null;
				for(Userinfo cx: li)
					nc=cx.getNickname();
				HttpSession session = request.getSession();//没有Session就新建一个
			      session.setMaxInactiveInterval(0);
			   session.setAttribute("yh",user);
			   session.setAttribute("nc",nc);
				response.sendRedirect("index.jsp");
			}else{
				request.setAttribute("message", "用户名或密码不正确");
				request.getRequestDispatcher("UserLanding.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("message", "验证码不正确");
			request.getRequestDispatcher("UserLanding.jsp").forward(request, response);
		}
		}else{
			request.setAttribute("message", "用户名、密码、验证码不可为空！");
			request.getRequestDispatcher("UserLanding.jsp").forward(request, response);	}	
	}
	}

