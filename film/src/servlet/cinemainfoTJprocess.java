package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import film.cinemainfo;

public class cinemainfoTJprocess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8");
	    //��ȡǰ����ӵ�������Ϣ
	    String cinema=request.getParameter("cinema"); 
	    String town=request.getParameter("town");  
	    String address=request.getParameter("address");  
			String mob= request.getParameter("mob");
			int Atstarting=Integer.parseInt(request.getParameter("Atstarting"));
			String remarks= request.getParameter("remarks");
			PrintWriter out=response.getWriter();
			if(cinema!=null&&town!=null&&address!=null&&mob!=null){
				cinemainfo tj=new cinemainfo(cinema,town,address,mob,Atstarting,remarks);
				tj.AddCinemainfo(tj);		

out.print("<script>alert('ӰԺ��Ϣ��ӳɹ�!');window.location.href='HTyyxx.jsp'</script>");
			    response.sendRedirect("HTyyxx.jsp");
			}else{
				request.setAttribute("tj", "����ע����Ϊ�գ�����������д����");
				request.getRequestDispatcher("HTyytj.jsp").forward(request, response);
			}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
