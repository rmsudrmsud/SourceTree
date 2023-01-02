package handler.imgboard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import imgboard.ImgBoardService;
import imgboard.ImgBoardVo;
import rep.RepService;

public class ListHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ImgBoardService service = new ImgBoardService();
		ArrayList<ImgBoardVo> list = service.getAll();
		RepService repservice = new RepService();
		for(ImgBoardVo vo : list) {
			vo.setReps(repservice.getAll(vo.getNum()));
		}
		request.setAttribute("list", list);
		
		return "/imgboard/list.jsp";
	}

}
