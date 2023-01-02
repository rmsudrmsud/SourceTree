package ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class Test3
 */
@WebServlet("/Test3")
public class Test3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test3() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//요청파람 읽는다
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		//요청 파람 출력
		System.out.println("name:" + name);
		System.out.println("tel:" + tel);
		
		//json 배열 생성 
		JSONArray arr = new JSONArray();
		
		//json 객체 생성
		JSONObject o1 = new JSONObject();
		o1.put("name", "aaa");
		o1.put("tel", "111");
		arr.add(o1);//생성한 객체를 배열에 추가
		
		JSONObject o2 = new JSONObject();
		o2.put("name", "bbb");
		o2.put("tel", "222");
		arr.add(o2);
		
		response.getWriter().append(arr.toJSONString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
