package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import film.OrderformInfo;

public class SettleAccounts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8");
	    String user=request.getSession().getAttribute("yh").toString();
	    String ordernumber=request.getParameter("ordernumber");//��ȡ�������    
	    int price=Integer.parseInt(request.getParameter("price"));//��ȡ�ܼ�
	    HttpSession session = request.getSession();//û��Session���½�һ��
	      session.setMaxInactiveInterval(0);;
	   session.setAttribute("ordernumber",ordernumber);//������
	   session.setAttribute("price",price);//�ܼ۸�
		  request.getRequestDispatcher("WXPayment.jsp").forward(request, response);
				}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
