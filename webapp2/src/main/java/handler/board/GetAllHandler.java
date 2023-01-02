package handler.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardService;
import board.BoardVo;
import handler.Handler;

public class GetAllHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BoardService service = new BoardService();//전체목록 검색하기위한 서비스단.
		ArrayList<BoardVo> list = service.getAll(); //원글만 검색.(parent=0)이 원글
		request.setAttribute("list", list);
		return "/board/list.jsp";
	}

}
