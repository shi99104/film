package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;

public class UploadPicture extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		response.setCharacterEncoding("utf-8");
		try{
			//新建一个 SmartUpload 对象
			SmartUpload s=new SmartUpload();
			//上传初始化
			s.initialize(getServletConfig(), request,response);
			//设置允许上传的单个文件的最大长度，在此为100MB
			s.setMaxFileSize(100*1024*1024);
			//设置允许上传的文件的类型
			s.setAllowedFilesList("jpg,png");
			//设置禁止上传的文件的类型
			//在此为exe、bat、jsp、htm与html文件以及没有扩展名的文件
			s.setDeniedFilesList("jsp,htm,,");
			//上传文件
			s.upload();
			//将上传的文件全部保存到指定目录中
			s.save("D:/myeclipse2017/zye/film/WebRoot/images",2);
			File f=s.getFiles().getFile(0);
			if(f.getSize() == 0){
				request.setAttribute("massage", "上传失败");
				request.getRequestDispatcher("HTdytj.jsp").forward(request, response);
			}else{
				request.setAttribute("massage", "上传成功");
				String file="images/"+f.getFileName();
				request.setAttribute("file1",file);
				request.getRequestDispatcher("HTdytj.jsp").forward(request, response);
				}}catch(Exception e){
				request.setAttribute("massage", "上传失败");
				request.getRequestDispatcher("HTdytj.jsp").forward(request, response);
	}
		}
	}
