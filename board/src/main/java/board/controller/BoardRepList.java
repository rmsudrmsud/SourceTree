package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import board.BoardService;
import board.BoardVo;

/**
 * Servlet implementation class BoardRepList
 */
@WebServlet("/board/replist")
public class BoardRepList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardRepList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int parent = Integer.parseInt(request.getParameter("parent")); //원글에대한번호 보낸거 받아서
		System.out.println(parent);
		BoardService service = new BoardService();
		ArrayList<BoardVo> reps = service.getByParent(parent); //번호로 검색하는기능
		JSONArray arr = new JSONArray(); //검색한녀석을 제이슨으로 담기(여러개니까 배열) JSONArray() = []과같음 / [{"num":3, "writer":"aaa"}]
		for(BoardVo rep:reps) {
			JSONObject obj = new JSONObject();
			obj.put("num", rep.getNum());
			obj.put("writer", rep.getWriter());
			obj.put("w_date", rep.getW_date().toString());
			obj.put("title", rep.getTitle());
			obj.put("content", rep.getContent());
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
