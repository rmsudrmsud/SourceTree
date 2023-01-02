package handler.board;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardService;
import board.BoardVo;
import handler.Handler;

public class EditHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//post방식
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int num = Integer.parseInt(request.getParameter("num"));
		String writer= request.getParameter("writer");
		String title= request.getParameter("title");
		String content=request.getParameter("content");
		
		BoardService service = new BoardService();
		service.editBoard(new BoardVo(num, null, null, title, content, 0));
		
		return "redirect:/board/getall.do"; //redirect:클라이언트에게 갔다가 재요청. 장점: 쓰기작업을 새로고침하면서 반복되는 작업을 막을 수 있음(쓰기,수정 등등의작업)
		//forward:서버내에서 페이지이동 
	}

}
