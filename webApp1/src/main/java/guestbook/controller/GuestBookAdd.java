package guestbook.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.GuestBookService;
import guestbook.GuestBookVo;

/**
 * Servlet implementation class GuestBookAdd
 */
@WebServlet("/guestbook/add")// 추가폼, 추가완료 요청 처리할 컨트롤러. get:추가폼, post: 추가완료 요청 처
public class GuestBookAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestBookAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dis=request.getRequestDispatcher("/guestbook/addForm.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String writer= request.getParameter("writer");
		String pwd = request.getParameter("pwd");
		String content=request.getParameter("content");
		
		GuestBookService service = new GuestBookService();
		service.addBook(new GuestBookVo(0, writer, null, pwd, content)); //서비스addbook으로 db에넣어주고 vo객체에담기
		
		response.sendRedirect("/webApp1/guestbook/list"); //새로고침시 list를 새로고침함 *쓰기작업은 처리이후 목록으로갈때 sendRedirect
//		RequestDispatcher dis=request.getRequestDispatcher("/guestbook/list");
//		dis.forward(request, response); 새로고침시 url이 add요청으로 계속 가기때문에 같은글이 자꾸 추가됨.
	}

}
