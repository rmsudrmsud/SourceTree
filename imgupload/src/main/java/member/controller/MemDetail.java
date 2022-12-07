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
 * Servlet implementation class MemDetail
 */
@WebServlet("/member/detail")
public class MemDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemDetail() {
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
		
		String id = request.getParameter("id");
		MemberService service = new MemberService();
		MemberVo vo = service.getMember(id);
		
		//검색결과를 request에 담는다.
		request.setAttribute("vo",vo);
		
		//requestDispacher객체를 생성하여 /member/detail.jsp로 이동.
		RequestDispatcher dis = request.getRequestDispatcher("/member/detail.jsp");
		dis.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberService service = new MemberService();
		service.editMember(new MemberVo(id, pwd, null, null, 0));
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
	}

}
