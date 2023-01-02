package handler.board;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import board.BoardService;
import board.BoardVo;
import handler.Handler;

public class AddRepHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int parent = Integer.parseInt(request.getParameter("parent"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BoardService service = new BoardService(); 
		service.addBoard(new BoardVo(0,writer,null,title,content,parent));//댓글이니까parent 0아님. 글작성이후
		ArrayList<BoardVo> list = service.getByParent(parent);
		JSONArray arr = new JSONArray();
		for(BoardVo vo:list) {
			JSONObject obj = new JSONObject();
			obj.put("num", vo.getNum());
			obj.put("title", vo.getTitle());
			obj.put("content", vo.getContent());
			obj.put("writer", vo.getWriter());
			arr.add(obj);
		}
		String txt = arr.toJSONString();
		return "responsebody/"+txt;
	}

}
