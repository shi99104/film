package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import film.OrderformInfo;

/**
 * Servlet implementation class ReserveTime
 */
public class ReserveTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8");
		//获取购买的电影票的电影名字
		String cinema=request.getParameter("cinema");//影院名称
		String  user=request.getParameter("user");//用户名
		String FilmTitle=request.getParameter("FilmTitle");//电影名称
		int monovalent=Integer.parseInt(request.getParameter("monovalent"));//价格	
		int quantity=Integer.parseInt(request.getParameter("quantity"));//票数
		String ViewingTime=request.getParameter("date");//预订时间
		int price=monovalent*quantity;
		String payment="未付款";
		//PrintWriter out=response.getWriter();
		//out.print(cinema+user+FilmTitle+monovalent+quantity+time+price);
		//int price=Integer.parseInt(request.getSession().getAttribute("price").toString());//价格	
		//查看用户名是否为空
		String ordernumber=getorderBH();
		if(user!=""&user!=null){
			HttpSession session = request.getSession();//没有Session就新建一个
		      session.setMaxInactiveInterval(0);
		      session.setAttribute("ordernumber",ordernumber);//订单号
		      session.setAttribute("cinema",cinema);//影院
		      session.setAttribute("user", user);//用户
		      session.setAttribute("FilmTitle",FilmTitle);//电影名
		      session.setAttribute("monovalent",monovalent);//单价
		      session.setAttribute("quantity",quantity);//票数
		      session.setAttribute("price",price);//总价格
		      session.setAttribute("ViewingTime",ViewingTime);//预订时间
			if(ordernumber!=null&cinema!=null&FilmTitle!=null&price!=0&quantity!=0&ViewingTime!=null){
			OrderformInfo t=new OrderformInfo(ordernumber,user,FilmTitle,cinema,monovalent,quantity,price,ViewingTime,payment);
			t.AddOrderform(t);}
		    response.sendRedirect("SettleAccounts.jsp");
		}else{
			request.setAttribute("message", "登陆用户才可购票");
			//response.sendRedirect("UserLanding.jsp");
			  request.getRequestDispatcher("UserLanding.jsp").forward(request, response);
		}
	}
	//获取随机订单号
	public String getorderBH(){
		 Date dt = new Date();
		 String hours = Integer.toString(dt.getHours());
		 String seconds= Integer.toString(dt.getSeconds());
		Random random = new Random();
		     int order= random.nextInt(1000000000);
		    String ordernumber="CT"+hours+seconds+Integer.toString(order);
		     return ordernumber;	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
