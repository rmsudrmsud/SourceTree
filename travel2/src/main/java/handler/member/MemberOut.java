package handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import member.MemberService;

public class MemberOut implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		MemberService service = new MemberService();
		service.delMember(id);
		
		return "DispatcherServlet?url=/member/logout";
		//로그아웃 처리까지 되도록.
	}

}
