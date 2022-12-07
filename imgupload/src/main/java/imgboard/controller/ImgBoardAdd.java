package imgboard.controller;

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

import imgboard.ImgBoardService;
import imgboard.ImgBoardVo;

/**
 * Servlet implementation class ImgBoardAdd
 */
@WebServlet("/imgboard/add")
public class ImgBoardAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgBoardAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dis =request.getRequestDispatcher("/imgboard/add.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String path = "/Users/choigeunhyeong/Documents/Kosta/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/webapps/img";
		
		int size = 100*1024*1024; //100m
		
		//업로드에 사용할 multipartrequest 객체
		MultipartRequest multipart = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
		//업로드된 파일의 파일객체 반환하는 메서드
		File f = multipart.getFile("file");
		//getName(): 파일명반환
		String fname=f.getName();//파일명
		String writer=multipart.getParameter("writer");
		String title=multipart.getParameter("title");
		String content=multipart.getParameter("content");
		String img_path = "/img/"+fname;
		
		ImgBoardService service = new ImgBoardService();
		service.addImgBoard(new ImgBoardVo(0, writer, null, title, content, img_path));
		
		response.sendRedirect(request.getContextPath()+"/imgboard/list");
		
	}

}
