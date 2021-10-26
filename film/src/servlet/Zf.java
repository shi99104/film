package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Zf extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8");
	    String user=request.getSession().getAttribute("yh").toString();
	    if(user!=""&&user!=null){
	    String ordernumber=request.getParameter("ordernumber");//��ȡ�������    
	    int price=Integer.parseInt(request.getParameter("price"));//��ȡ�ܼ�
	    String payment=request.getParameter("payment");//�Ƿ񸶿�   
	    if(payment.equals("δ����")){
	   HttpSession session = request.getSession();//û��Session���½�һ��
	      session.setMaxInactiveInterval(0);;
	   session.setAttribute("ordernumber",ordernumber);//������
	   session.setAttribute("price",price);//�ܼ۸�
		  request.getRequestDispatcher("WXPayment.jsp").forward(request, response);
				}
	   else{    
		   request.getRequestDispatcher("OrderForm.jsp?user="+user).forward(request, response);
	   }}else{
		   request.setAttribute("message", "��½��ſɲ�ѯ����");
			request.getRequestDispatcher("UserLanding.jsp").forward(request, response);
	   }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
