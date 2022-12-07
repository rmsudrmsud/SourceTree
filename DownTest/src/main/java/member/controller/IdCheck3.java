package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import member.MemberService;
import member.MemberVo;

/**
 * Servlet implementation class IdCheck3
 */
@WebServlet("/member/idcheck")
public class IdCheck3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheck3() {
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
		response.setCharacterEncoding("UTF-8");
		
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
		
		response.getWriter().append(txt);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
