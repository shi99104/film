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
	    String ordernumber=request.getParameter("ordernumber");//获取订单编号    
	    int price=Integer.parseInt(request.getParameter("price"));//获取总价
	    String payment=request.getParameter("payment");//是否付款   
	    if(payment.equals("未付款")){
	   HttpSession session = request.getSession();//没有Session就新建一个
	      session.setMaxInactiveInterval(0);;
	   session.setAttribute("ordernumber",ordernumber);//订单号
	   session.setAttribute("price",price);//总价格
		  request.getRequestDispatcher("WXPayment.jsp").forward(request, response);
				}
	   else{    
		   request.getRequestDispatcher("OrderForm.jsp?user="+user).forward(request, response);
	   }}else{
		   request.setAttribute("message", "登陆后才可查询订单");
			request.getRequestDispatcher("UserLanding.jsp").forward(request, response);
	   }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
