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
		//��ȡ����ĵ�ӰƱ�ĵ�Ӱ����
		String cinema=request.getParameter("cinema");//ӰԺ����
		String  user=request.getParameter("user");//�û���
		String FilmTitle=request.getParameter("FilmTitle");//��Ӱ����
		int monovalent=Integer.parseInt(request.getParameter("monovalent"));//�۸�	
		int quantity=Integer.parseInt(request.getParameter("quantity"));//Ʊ��
		String ViewingTime=request.getParameter("date");//Ԥ��ʱ��
		int price=monovalent*quantity;
		String payment="δ����";
		//PrintWriter out=response.getWriter();
		//out.print(cinema+user+FilmTitle+monovalent+quantity+time+price);
		//int price=Integer.parseInt(request.getSession().getAttribute("price").toString());//�۸�	
		//�鿴�û����Ƿ�Ϊ��
		String ordernumber=getorderBH();
		if(user!=""&user!=null){
			HttpSession session = request.getSession();//û��Session���½�һ��
		      session.setMaxInactiveInterval(0);
		      session.setAttribute("ordernumber",ordernumber);//������
		      session.setAttribute("cinema",cinema);//ӰԺ
		      session.setAttribute("user", user);//�û�
		      session.setAttribute("FilmTitle",FilmTitle);//��Ӱ��
		      session.setAttribute("monovalent",monovalent);//����
		      session.setAttribute("quantity",quantity);//Ʊ��
		      session.setAttribute("price",price);//�ܼ۸�
		      session.setAttribute("ViewingTime",ViewingTime);//Ԥ��ʱ��
			if(ordernumber!=null&cinema!=null&FilmTitle!=null&price!=0&quantity!=0&ViewingTime!=null){
			OrderformInfo t=new OrderformInfo(ordernumber,user,FilmTitle,cinema,monovalent,quantity,price,ViewingTime,payment);
			t.AddOrderform(t);}
		    response.sendRedirect("SettleAccounts.jsp");
		}else{
			request.setAttribute("message", "��½�û��ſɹ�Ʊ");
			//response.sendRedirect("UserLanding.jsp");
			  request.getRequestDispatcher("UserLanding.jsp").forward(request, response);
		}
	}
	//��ȡ���������
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
