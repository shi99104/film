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
			//�½�һ�� SmartUpload ����
			SmartUpload s=new SmartUpload();
			//�ϴ���ʼ��
			s.initialize(getServletConfig(), request,response);
			//���������ϴ��ĵ����ļ�����󳤶ȣ��ڴ�Ϊ100MB
			s.setMaxFileSize(100*1024*1024);
			//���������ϴ����ļ�������
			s.setAllowedFilesList("jpg,png");
			//���ý�ֹ�ϴ����ļ�������
			//�ڴ�Ϊexe��bat��jsp��htm��html�ļ��Լ�û����չ�����ļ�
			s.setDeniedFilesList("jsp,htm,,");
			//�ϴ��ļ�
			s.upload();
			//���ϴ����ļ�ȫ�����浽ָ��Ŀ¼��
			s.save("D:/myeclipse2017/zye/film/WebRoot/images",2);
			File f=s.getFiles().getFile(0);
			if(f.getSize() == 0){
				request.setAttribute("massage", "�ϴ�ʧ��");
				request.getRequestDispatcher("HTdytj.jsp").forward(request, response);
			}else{
				request.setAttribute("massage", "�ϴ��ɹ�");
				String file="images/"+f.getFileName();
				request.setAttribute("file1",file);
				request.getRequestDispatcher("HTdytj.jsp").forward(request, response);
				}}catch(Exception e){
				request.setAttribute("massage", "�ϴ�ʧ��");
				request.getRequestDispatcher("HTdytj.jsp").forward(request, response);
	}
		}
	}
