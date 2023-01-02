package handler.member;//handler를 상속받는 클래스만듦.

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class MemberIdCheck implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if(request.getMethod().toLowerCase().equals("get")) {
			return "/member/idcheck.jsp";
		}
		
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		String id = request.getParameter("id");
		MemberService service = new MemberService();
		MemberVo vo = service.getMember(id);
		boolean flag = false;
		String msg = "사용 불가능한 아이디";

		if (vo == null) {
			msg = "사용 가능한 아이디";
			flag = true;
		}
		
		JSONObject obj = new JSONObject();
		obj.put("flag", flag);
		obj.put("msg", msg);
		String txt = obj.toJSONString();
		
		return "responsebody/" + txt; // 몸체를 받아서 보내줌. 뭐 foward나 redirect이런게 아니기때문에..?
		
	}

}
