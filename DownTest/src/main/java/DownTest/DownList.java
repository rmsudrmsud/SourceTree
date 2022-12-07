package DownTest;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownList
 */
@WebServlet("/down/list")
public class DownList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DownList() {
        super();
    }

	//다운로드경로에 뿌려줄 작업을 할 서블릿
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path="/Users/choigeunhyeong/Documents/down/"; //다운로드에 지정한 디렉토리
		
		//File : 파일이나 디렉토리에대한 정보를 가지고있는 클래스 
		File downDir = new File(path);
		
		String[] files = downDir.list();//파일객체의 list: 디렉토리에 저장되어있는파일목록(이름)을 배열에 담아 반환
		
		//request에 읽어들인 파일목록 정보를 담는다.
		request.setAttribute("files", files);
		RequestDispatcher dis = request.getRequestDispatcher("/downtest/list.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
