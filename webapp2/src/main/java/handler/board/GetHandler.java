package handler.board;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import board.BoardService;
import board.BoardVo;
import handler.Handler;

public class GetHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));
		BoardService service = new BoardService();
		BoardVo vo = service.getBoard(num);
		vo.setReps(service.getByParent(num));
		request.setAttribute("vo", vo);
		
		//get방식
		if(request.getMethod().toLowerCase().equals("get")) {
			return "/board/detail.jsp";
		}
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject obj = new JSONObject();
		obj.put("num", vo.getNum());
		obj.put("writer", vo.getWriter());
		obj.put("w_date", vo.getW_date().clone().toString());
		obj.put("title", vo.getTitle());
		obj.put("content", vo.getContent());
		String txt = obj.toJSONString();
		return "responsebody/"+txt;
		
//		if(request.getMethod().toLowerCase().equals("get")) {
//
//			try {
//				request.setCharacterEncoding("UTF-8");
//				response.setCharacterEncoding("UTF-8");
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			int type = Integer.parseInt(request.getParameter("type"));
//			int num = Integer.parseInt(request.getParameter("num"));
//
//			BoardService service = new BoardService();
//			BoardVo vo = service.getBoard(num);
//			if (type == 1) {
//				return "responsebody/"+"작성일:" + vo.getW_date();
//			} else {
//				request.setAttribute("vo", vo);
//				return "/board/detail.jsp";
//			}
//		}
//		
//		try {
//			request.setCharacterEncoding("UTF-8");
//			response.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		BoardService service = new BoardService();
//		
//		int num = Integer.parseInt(request.getParameter("num"));
//		String title= request.getParameter("title");
//		String content=request.getParameter("content");
//		
//		
//		service.editBoard(new BoardVo(num, "", null, title, content, 0)); //서비스addbook으로 db에넣어주고 vo객체에담기
//		
//		return "redirect:/board/getall.do";

	}
}
