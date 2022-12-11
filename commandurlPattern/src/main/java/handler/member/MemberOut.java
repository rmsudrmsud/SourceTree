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
		//request.getContextPath() : 프로젝트 base경로 => 이클립스에서 /프로젝트명
		service.delMember(id);
		return "/member/logout.do";
	}

}
