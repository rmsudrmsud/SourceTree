package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import board.BoardService;
import board.BoardVo;

/**
 * Servlet implementation class BoardRpeAdd
 */
@WebServlet("/board/repadd")
public class BoardRpeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardRpeAdd() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		boolean flag = true;
		try {
			BoardService service = new BoardService();
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int parent = Integer.parseInt(request.getParameter("parent"));

			service.addBoard(new BoardVo(0, writer, null, title, content, parent)); // 서비스으로 db에넣어주고 vo객체에담기
			//댓글이지만 글작성과 같게 addboard를 호출하는데 원글에댓글작성해야 하기때문에 parent를 받기
		} catch (Exception e) {
			System.out.println(e); // 예외발생시 예외 출력
			flag = false;
		}

		JSONObject obj = new JSONObject();
		obj.put("flag", flag);
		String txt = obj.toJSONString();
		response.getWriter().append(txt);
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
