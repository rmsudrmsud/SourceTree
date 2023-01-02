package handler.together;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import together.TogetherService;
import together.TogetherVo;
import togetherRep.TogetherRepService;

public class TogetherDetail implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub	
		int travel_num = Integer.parseInt(request.getParameter("travel_num"));
		TogetherVo vo = (new TogetherService().getNum(travel_num));
		
		TogetherRepService service = new TogetherRepService();
		vo.setReps(service.getNum(travel_num));
		
		request.setAttribute("vo", vo);
		
		return "/together/detail.jsp";
	}

}
