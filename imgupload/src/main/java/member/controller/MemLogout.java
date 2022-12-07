package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemLogout
 */
@WebServlet("/member/logout")
public class MemLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemLogout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession(false); 
		// 로그아웃 하기전에 세션객체 가져오기 - 새로운세션을 생성해서 가지고오면 안되고 이전로그인한 객체를 가져오기위해서 false로설정.
		//getSession(true/false) defalut:true
		//사용중인 세션이 없는 경우 true : 새로 생성해서 / false : 에러
		
		session.removeAttribute("loginID"); // 세션에 저장되어있던 id 삭제
		session.invalidate(); // 세션 무효화 =>새 세션이 생성. 로그아웃
		RequestDispatcher dis = request.getRequestDispatcher("/index.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); //get,post방식구분없이 동작할 경우 내버려두기
	}

}
