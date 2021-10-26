package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import film.Filminfo;
import film.cinemainfo;

public class filmTJprocess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
	    //获取前端添加的数据信息,添加电影
	    String FilmTitle=request.getParameter("FilmTitle"); 
	    String bill=request.getParameter("bill"); 
	    String intrommend=request.getParameter("intrommend");  
	    String director=request.getParameter("director");  
			String actor= request.getParameter("actor");
			String region= request.getParameter("region");
			String laguae=request.getParameter("laguae");  
		    String type=request.getParameter("type");  
				String releasedate= request.getParameter("releasedate");
				int movietime= Integer.valueOf(request.getParameter("movietime"));
				int price= Integer.valueOf(request.getParameter("price"));
				PrintWriter out=response.getWriter();
			if(FilmTitle!=null&&intrommend!=null&&director!=null&&actor!=null&&region!=null&&laguae!=null&&type!=null&&releasedate!=null){
				Filminfo tj=new Filminfo(FilmTitle,bill,intrommend,director,actor,region,laguae,type,releasedate,movietime,price);
				tj.AddFilminfo(tj);		
				out.print("<script>alert('电影添加成功!');window.location.href='HTdyxx.jsp'</script>");
				

			    //response.sendRedirect("HTdyxx.jsp");
			}else{
				request.setAttribute("tj", "不可为空");
				request.getRequestDispatcher("HTdytj.jsp").forward(request, response);
			}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
