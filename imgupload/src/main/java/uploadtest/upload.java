package uploadtest;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/test/upload")
public class upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public upload() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//업로드할파일의 경로. 업로드 : 클라이언트 컴퓨터에있는 파일을 서버에 올리는것
		//웹앱 : 이클립스상에서 웹서버로 사용한 곳.-> 업로드한 이미지를 웹페이지에서 실행할수 있도록 경로를 이곳으로 설정 c,d드라이브 같은곳 해도됨
		String path = "/Users/choigeunhyeong/Documents/Kosta/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/webapps/img/";
		
		//업로드 파일의 최대 크기
		int size = 100*1024*1024; //100m
		
		//업로드에 사용할 multipartrequest 객체
		MultipartRequest multipart = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
		//param1: 요청객체, param2: 업로드경로, param3: 파일최대크기, param4: 인코딩, param5: 파일명 중복되었을 때 처리 방법
		//파라메터로 요청, 경로, 사이즈 , 인코딩, new DefaultFileRenamePolicy() : 이름이 중복되었을때 처리할 객체
		
		//폼 파라메터 읽기
		String title = multipart.getParameter("title");
		//업로드된 파일의 원본이름
		String fname = multipart.getOriginalFileName("uploadfile"); // 원본 파일명
		
		//파일형식으로 받아옴
		File f = multipart.getFile("uploadfile");
		f.renameTo(new File(path+"test.jpg"));
		
		request.setAttribute("title", title);
		request.setAttribute("fname", "/img/"+fname);
		
		RequestDispatcher dis = request.getRequestDispatcher("/upload/imglist.jsp");
		dis.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
