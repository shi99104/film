package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import film.Discussinfo;

public class HTplTJprocess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8");
	    //��ȡǰ����ӵ�������Ϣ
	    String FilmTitle=request.getParameter("FilmTitle"); 
	    String nickname=request.getParameter("nickname"); 
	    String discuss=request.getParameter("discuss");
	    PrintWriter out=response.getWriter();
	    if(FilmTitle!=""&&FilmTitle!=null&&nickname!=""&&nickname!=null&&discuss!=""&&discuss!=null){
	    	Discussinfo t=new Discussinfo(discuss,nickname,FilmTitle);
			t.AddDiscussinfo(t);
			response.sendRedirect("HTplxx.jsp");
			out.print("<script>alert('������ӳɹ�!');window.location.href='HTplxx.jsp'</script>");
	    }else{
	    	request.setAttribute("tj", "����Ϊ��");
			request.getRequestDispatcher("HTpltj.jsp").forward(request, response);
	    }
	    
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
