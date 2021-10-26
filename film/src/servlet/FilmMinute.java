package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import film.Filminfo;
import film.History;

public class FilmMinute extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset-utf-8"); 
		String  FilmTitle=request.getParameter("FilmTitle");
		HttpSession session = request.getSession();
		String user=(String) session.getAttribute("yh");
		//String user= request.getSession().getAttribute("yh").toString();
		History t=new History(user,FilmTitle);
		t.AddHistory(t);
		Filminfo qu = new Filminfo();
		List<Filminfo> li = qu.Queryfilminfo(FilmTitle);
		String FilmTitle1 =null , intrommend = null, director = null, actor = null,region = null,laguae = null,type = null,releasedate = null,bill=null;
		int price = 0,movietime=0;
		for(Filminfo cx: li){
			FilmTitle1=cx.getFilmTitle();
			intrommend=cx.getIntrommend();
			director=cx.getDirector();
			actor=cx.getActor();
			region=cx.getRegion();
			laguae=cx.getLaguae();
			type=cx.getType();
			releasedate=cx.getReleasedate();
			 movietime=cx.getMovietime();
			 bill=cx.getBill();
			 price=cx.getPrice();}	//没有Session就新建一个
	      session.setMaxInactiveInterval(0);
	   session.setAttribute("FilmTitle",FilmTitle1);
	   session.setAttribute("intrommend",intrommend);
	   session.setAttribute("director",director);
	   session.setAttribute("actor",actor);
	   session.setAttribute("region",region);
	   session.setAttribute("laguae",laguae);
	   session.setAttribute("type",type);
	   session.setAttribute("releasedate",releasedate);
	   session.setAttribute("movietime",movietime);
	   session.setAttribute("bill",bill);
	   session.setAttribute("price",price);
       response.sendRedirect("FilmDetailed.jsp");				
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
