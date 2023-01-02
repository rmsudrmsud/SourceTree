package handler.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardService;
import board.BoardVo;
import handler.Handler;

public class GetByTitleHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String searchval = request.getParameter("searchval");
		ArrayList<BoardVo> list = (new BoardService()).getByTitle(searchval);
		request.setAttribute("list", list);
		return "/board/list.jsp";
	}

}
