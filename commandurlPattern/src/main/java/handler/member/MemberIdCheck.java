package handler.member;

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
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String id = request.getParameter("id");
		MemberService service = new MemberService();
		MemberVo vo = service.getMember(id);
		
		boolean flag = false;
		String msg = "사용불가능한 아이디";
		
		if(vo==null) {
			msg = "사용가능한 아이디";
			flag = true;
		}
		
		JSONObject obj = new JSONObject(); //ajax요청에 사용할 제이슨 객체 생성
		obj.put("flag", flag); //사용가능불가능을 ture flase로표현
		obj.put("msg", msg); // 출력할 값
		String txt = obj.toJSONString();
		
		return "responsebody/" + txt; //ajax요청 return responsbody
	}

}
