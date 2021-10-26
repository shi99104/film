package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import film.OrderformInfo;

public class OrderForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8");
		//获取到session的用户名
		String user= request.getParameter("user");
		//PrintWriter out=response.getWriter();
		if(user!=""&&user!=null){
			   request.getRequestDispatcher("OrderForm.jsp?user="+user).forward(request, response);
			}else{
				//out.print("<script>alert('登陆后才可查询订单!');window.location.href='UserLanding.jsp'</script>");
				request.setAttribute("message", "登陆后才可查询订单");
				request.getRequestDispatcher("UserLanding.jsp").forward(request, response);
			}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
