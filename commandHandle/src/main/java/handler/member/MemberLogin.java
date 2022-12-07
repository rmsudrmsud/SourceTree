package handler.member;

import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class MemberLogin implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if(request.getMethod().toLowerCase().equals("get")) {
			return "/member/loginForm.jsp";
		}
		
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		
		return "/index.jsp";
	}

}
