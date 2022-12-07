package imgboard.rep.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import imgboard.rep.Rep;
import imgboard.rep.RepService;

/**
 * Servlet implementation class RepAdd
 */
@WebServlet("/rep/add")
public class RepAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		int parent = Integer.parseInt(request.getParameter("parent"));
		
		RepService service = new RepService();
		service.addRep(new Rep(0, writer, content, parent));
		//댓글목록 갱신하려고 댓글검색
		ArrayList<Rep> list = service.getAll(parent);
		JSONArray arr = new JSONArray();
		for(Rep r:list) {
			JSONObject obj = new JSONObject();
			obj.put("num", r.getNum());
			obj.put("writer", r.getWriter());
			obj.put("content", r.getContent());
			obj.put("parent", r.getParent());
			arr.add(obj);
		}
		
		String txt = arr.toJSONString();
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
