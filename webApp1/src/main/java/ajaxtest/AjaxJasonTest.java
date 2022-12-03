package ajaxtest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class AjaxJasonTest
 */
@WebServlet("/ajax/jsontest")
public class AjaxJasonTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxJasonTest() {
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
		//json 객체 생성
		JSONObject obj = new JSONObject(); //[]
		obj.put("name", "aaa"); //{키:값}
		obj.put("tel", "111");
		obj.put("age", 12);
		
		JSONObject obj2 = new JSONObject(); 
		obj2.put("name", "bbb"); //{키:값}
		obj2.put("tel", "222");
		obj2.put("age", 23);
		
		JSONObject obj3 = new JSONObject();
		obj3.put("name", "ccc"); //{키:값}
		obj3.put("tel", "333");
		obj3.put("age", 44);
		
		JSONArray arr = new JSONArray();
		arr.add(obj);
		arr.add(obj2);
		arr.add(obj3);
		
		//json객체를 문자열로 변환
		String txt = arr.toJSONString();
		
		//출력
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
