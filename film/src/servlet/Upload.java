package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;

/**
 * Servlet implementation class Upload
 */
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
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
				request.getRequestDispatcher("HTdyxxRevise.jsp").forward(request, response);
			}else{
				request.setAttribute("massage", "�ϴ��ɹ�");
				String file="images/"+f.getFileName();
				request.setAttribute("file1",file);
				request.getRequestDispatcher("HTdyxxRevise.jsp").forward(request, response);
				}}catch(Exception e){
				request.setAttribute("massage", "�ϴ�ʧ��");
				request.getRequestDispatcher("HTdyxxRevise.jsp").forward(request, response);
	}
		}

}
