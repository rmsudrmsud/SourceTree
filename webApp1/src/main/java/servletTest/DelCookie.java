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
 * Servlet implementation class DelCookie
 */
@WebServlet("/DelCookie")
public class DelCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dis = 
				request.getRequestDispatcher("/cookie/delForm.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String delKey = request.getParameter("ra");
		Cookie[] cookies = request.getCookies();
		//배열에서 1개씩꺼내서 비교
		for (Cookie c : cookies) {
			if(c.getName().equals(delKey)) {
				c.setMaxAge(0);//유효시간 0으로 설정
				response.addCookie(c);
			}
		}
		response.sendRedirect("/webApp1/ReadCookie");
	}

}
