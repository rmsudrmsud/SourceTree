package handler.place;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import place.PlaceService;
import place.PlaceVo;

public class PlaceDetail implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("place_num"));
		PlaceVo vo = (new PlaceService()).getPlace(num);
		request.setAttribute("vo", vo);
		return "/place/detail.jsp";
	}

}
