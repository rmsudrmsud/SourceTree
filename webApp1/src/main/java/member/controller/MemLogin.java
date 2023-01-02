package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberService;
import member.MemberVo;

/**
 * Servlet implementation class MemLogin
 */
@WebServlet("/login") //get:로그인폼. post:로그인처리
public class MemLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dis = 
				request.getRequestDispatcher("/member/loginForm.jsp");
		dis.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");		
		response.setCharacterEncoding("euc-kr");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberService service = new MemberService();
		MemberVo vo = service.getMember(id);
		
		//로그인 처리
		if(vo != null && pwd.equals(vo.getPwd())) {//로그인 성공
			//현재 사용중인 세션 반환
			HttpSession session = request.getSession(); //로그인 정보를 session에 저장
			session.setAttribute("loginId", id); //로그인 아이디	
			session.setAttribute("type",vo.getType());//로그인 사람의 타입
		}
		
		RequestDispatcher dis = 
				request.getRequestDispatcher("/index.jsp");
		dis.forward(request, response);
		
	}

}
