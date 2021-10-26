package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;

/**
 * Servlet implementation class sctp
 */
public class sctp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sctp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try{
			//新建一个 SmartUpload 对象
			SmartUpload s=new SmartUpload();
			//上传初始化
			s.initialize(getServletConfig(), request,response);
			//设置允许上传的单个文件的最大长度，在此为100MB
			s.setMaxFileSize(100*1024*1024);
			//设置允许上传的文件的类型
			s.setAllowedFilesList("bmp,jpg,png,tif,gif,pcx,tga,exif,fpx,svg,psd,cdr,pcd,dxf,ufo,eps,ai,raw,WMF,webp");
			//设置禁止上传的文件的类型
			//在此为exe、bat、jsp、htm与html文件以及没有扩展名的文件
			s.setDeniedFilesList("jsp,htm,,");
			//上传文件
			s.upload();
			//将上传的文件全部保存到指定目录中
			s.save("D:/myeclipse2017/zye/film/WebRoot/images",2);
			File f=s.getFiles().getFile(0);
			
					out.println("文件上传成功<br><br>");
				out.println("文件"+":"+f.getFileName()+"("+f.getSize()+"字节)<br>");
			
		}catch(Exception e){
			out.println("上传文件失败！");
		}
	}

}
