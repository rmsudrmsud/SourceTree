package handler.tasty;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Question_rep.Question_rep_Service;
import Tasty.TastyService;
import Tasty.TastyVo;
import handler.Handler;

public class TastyDetail implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int tasty_num = Integer.parseInt(request.getParameter("tasty_num"));
		TastyVo vo = (new TastyService()).getByTastyNum(tasty_num);
//		TastyService service = new TastyService();
		request.setAttribute("vo", vo);
		return "/tasty/detail.jsp";
	}

}
