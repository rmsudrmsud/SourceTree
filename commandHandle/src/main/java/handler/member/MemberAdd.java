package handler.member;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class MemberAdd implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if(request.getMethod().toLowerCase().equals("get")) {
			return "/member/joinForm.jsp";
		}
		
		try {
			request.setCharacterEncoding("euc-kr");
			response.setCharacterEncoding("euc-kr");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		// id, pwd, name, email 입력 폼 값 읽어오기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int type = Integer.parseInt(request.getParameter("type"));
		MemberVo vo = new MemberVo(id, pwd, name, email, type);
		MemberService service = new MemberService();
		service.join(vo);// 회원가입 완료
		return "redirect:/index.jsp"; //전체 db값에 영향을 주면 redirect사용.
	}

}
