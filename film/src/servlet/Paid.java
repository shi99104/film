package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import film.OrderformInfo;

public class Paid extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setContentType("text/html;charset=utf-8"); 
			response.setCharacterEncoding("utf-8");
			String user=request.getSession().getAttribute("yh").toString();
		String ordernumber=request.getParameter("ordernumber");
		OrderformInfo sc=new OrderformInfo();
		sc.updateOrder("ÒÑ¸¶¿î",ordernumber);
		request.getRequestDispatcher("OrderForm.jsp?user="+user).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
