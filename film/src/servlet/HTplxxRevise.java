package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import film.Discussinfo;

public class HTplxxRevise extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8"); 
		int number=Integer.parseInt(request.getParameter("number")); 
		 String discuss=request.getParameter("discuss");
		 PrintWriter out=response.getWriter();
		 if(discuss!=""&&discuss!=null){
			 Discussinfo sc=new Discussinfo();
				sc.updateDisuss(discuss,number);
			 //response.sendRedirect("HTplxx.jsp");
			 out.print("<script>alert('Ӱ���޸ĳɹ���');window.location.href='HTplxx.jsp'</script>");
			 

			}else{
				request.setAttribute("yy", "���ļ�λ����������Ϊ��");
				request.getRequestDispatcher("HTplxxReviser.jsp").forward(request, response);
			}
		 }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
