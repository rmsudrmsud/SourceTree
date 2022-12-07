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
@WebServlet("/member/login")
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
    //get으로 요청오면 login폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dis = request.getRequestDispatcher("/member/loginForm.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//post로 요청오면 로그인처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String id= request.getParameter("id");
		String pwd= request.getParameter("pwd");
		
		MemberService service = new MemberService();
		MemberVo vo = service.getMember(id);
		
		//로그인처리
		if(vo !=null && pwd.equals(vo.getPwd())) { // 로그인 성공
			HttpSession session = request.getSession(); // 로그인한 정보를 request에 현재사용중인 세션저장. 반환
			session.setAttribute("loginId", id); //현재 로그인한 id 를 loginId 라는 이름으로 저장
			session.setAttribute("type", vo.getType()); //로그인 사람의 타입
			//session.removeAttribute("loginId"); 세션에 loginId로 저장한값을 지우는 메서
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("/index.jsp");
		dis.forward(request, response);
//		if(vo.getType()==1) {
//		RequestDispatcher dis = request.getRequestDispatcher("/product/editForm.jsp");
//		dis.forward(request, response);
//		}
//		
//		if(vo.getType()==2) {
//			RequestDispatcher dis = request.getRequestDispatcher("/product/addForm.jsp");
//			dis.forward(request, response);
//		}
		
		
	}

}
