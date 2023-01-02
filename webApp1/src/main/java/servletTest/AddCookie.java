package servletTest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCookie
 */
@WebServlet("/AddCookie")
public class AddCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCookie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dis = 
				request.getRequestDispatcher("/cookie/addForm.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		
		String key1 = request.getParameter("key1");
		String val1 = request.getParameter("val1");

		String key2 = request.getParameter("key2");
		String val2 = request.getParameter("val2");
		//키와 값으로 쿠키 객체 생성
		Cookie c1 = new Cookie(key1,val1);
		Cookie c2 = new Cookie(key2,val2);
		//생성한 쿠키를 response에 담아서 클라이언트에 보냄
		response.addCookie(c1);
		response.addCookie(c2);

		response.sendRedirect("/webApp1/ReadCookie");//지금 저장한 쿠키를 읽기
	}

}
