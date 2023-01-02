package handler.togetherRep;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import togetherRep.TogetherRepService;


public class TogetherRepDel implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int travel_rep_num = Integer.parseInt(request.getParameter("travel_rep_num"));
		int travel_num = Integer.parseInt(request.getParameter("travel_num"));
		TogetherRepService service = new TogetherRepService();
		
		service.delete(travel_rep_num);
		
		return "redirect:/together/detail.do?travel_num="+travel_num;
	}

}
