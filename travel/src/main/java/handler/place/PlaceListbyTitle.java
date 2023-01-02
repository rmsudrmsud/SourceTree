package handler.place;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import place.PlaceService;
import place.PlaceVo;

public class PlaceListbyTitle implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String fname = request.getParameter("fname");
		int city_num = Integer.parseInt(request.getParameter("city_num"));
		ArrayList<PlaceVo> list = (new PlaceService()).getByTitle(fname, city_num);
		request.setAttribute("list", list);
		return "/place/list.jsp";
	}

}
