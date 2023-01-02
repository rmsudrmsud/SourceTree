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
 * Servlet implementation class GuestBookEdit
 */
@WebServlet("/guestbook/edit") //get:상세페이지(수정품). post:수정완료
public class GuestBookEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GuestBookEdit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));// list.jsp에서 받아
		GuestBookService service = new GuestBookService();
		GuestBookVo vo = service.getBook(num);
		request.setAttribute("vo", vo);
		RequestDispatcher dis = 
				request.getRequestDispatcher("/guestbook/editForm.jsp");// editForm.jsp로 보내
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String content = request.getParameter("content");
		GuestBookService service = new GuestBookService();
		service.editBook(new GuestBookVo(num, "", null, "", content));
		response.sendRedirect("/webApp1/guestbook/list");
	}

}
