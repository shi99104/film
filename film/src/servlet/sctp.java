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
			//�½�һ�� SmartUpload ����
			SmartUpload s=new SmartUpload();
			//�ϴ���ʼ��
			s.initialize(getServletConfig(), request,response);
			//���������ϴ��ĵ����ļ�����󳤶ȣ��ڴ�Ϊ100MB
			s.setMaxFileSize(100*1024*1024);
			//���������ϴ����ļ�������
			s.setAllowedFilesList("bmp,jpg,png,tif,gif,pcx,tga,exif,fpx,svg,psd,cdr,pcd,dxf,ufo,eps,ai,raw,WMF,webp");
			//���ý�ֹ�ϴ����ļ�������
			//�ڴ�Ϊexe��bat��jsp��htm��html�ļ��Լ�û����չ�����ļ�
			s.setDeniedFilesList("jsp,htm,,");
			//�ϴ��ļ�
			s.upload();
			//���ϴ����ļ�ȫ�����浽ָ��Ŀ¼��
			s.save("D:/myeclipse2017/zye/film/WebRoot/images",2);
			File f=s.getFiles().getFile(0);
			
					out.println("�ļ��ϴ��ɹ�<br><br>");
				out.println("�ļ�"+":"+f.getFileName()+"("+f.getSize()+"�ֽ�)<br>");
			
		}catch(Exception e){
			out.println("�ϴ��ļ�ʧ�ܣ�");
		}
	}

}
