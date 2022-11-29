package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberService;
import member.MemberVo;

/**
 * Servlet implementation class JoinController
 */
@WebServlet("/JoinController")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //회원가입 작성 폼 제공
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//요청에 대한 교통정리. 생자에 뷰 페이지 경로(). Dispatcher
		RequestDispatcher dis = request.getRequestDispatcher("/member/joinForm.jsp");
		dis.forward(request, response); //forward 방식으로 이동한다.
	}
	
	//페이지이동방식
	//forward: 서버내에서 페이지가 이동하는 방식
	//redirect : 새 request(요청)으로 페이지 이동하는 방식. 새로고침해도 똑같은작업반복 x,

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//회원가입완료
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//id, pwd, name, email 입력 폼 값 읽어오기. DB에 넣기 위해서
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		MemberVo vo = new MemberVo(id, pwd, name, email);
		MemberService service = new MemberService();
		service.join(vo);//회원가입 완료
		
		RequestDispatcher dis = request.getRequestDispatcher("/index.jsp");
		dis.forward(request, response); //forward 방식으로 이동한다.
	}

}
