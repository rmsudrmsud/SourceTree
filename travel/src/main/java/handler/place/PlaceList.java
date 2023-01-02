package handler.place;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.Handler;
import place.PlaceService;
import place.PlaceVo;

public class PlaceList implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int city_num = Integer.parseInt(request.getParameter("city_num"));
		
		PlaceService service = new PlaceService();
		ArrayList<PlaceVo> list = service.getAll(city_num);		
		request.setAttribute("list", list);
		
		HttpSession session = request.getSession();
		session.setAttribute("city_num", city_num); 
		return "/place/list.jsp";
	
	}

}
