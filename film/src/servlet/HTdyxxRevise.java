package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import film.Filminfo;
import film.cinemainfo;

public class HTdyxxRevise extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8");
		int number=Integer.parseInt(request.getParameter("number")); 
		 String FilmTitle=request.getParameter("FilmTitle");
		 String bill=request.getParameter("bill"); 
		 String intrommend=request.getParameter("intrommend");  
		 String director=request.getParameter("director");  
		 String actor=request.getParameter("actor");  
		 String region=request.getParameter("region");
		 String laguae=request.getParameter("laguae");  
		 String type=request.getParameter("type");  
		 String releasedate=request.getParameter("releasedate");
		 int movietime=Integer.parseInt(request.getParameter("movietime"));
		 int price=Integer.parseInt(request.getParameter("price")); 
		 PrintWriter out=response.getWriter();
				if(number!=0&&FilmTitle!=null&&intrommend!=null&&director!=null&&actor!=null
						&&region!=null&&laguae!=null&&type!=null&&releasedate!=null&&movietime!=0&&price!=0){
					Filminfo xg=new Filminfo();
					xg.ReviseFilm(FilmTitle,bill,intrommend,director,actor,region,laguae,type,releasedate,
							movietime,price,number);
					out.print("<script>alert('电影信息修改成功！');window.location.href='HTdyxx.jsp'</script>");
				//response.sendRedirect("HTdyxx.jsp");
				}else{
					request.setAttribute("yy", "除文件位置其他不可为空");
					request.getRequestDispatcher("HTdyxxReviser.jsp").forward(request, response);
				}
			}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
