package handler.tasty;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tasty.TastyService;
import Tasty.TastyVo;
import handler.Handler;

public class TastyListAll implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		TastyService service = new TastyService();
		int city_num = Integer.parseInt(request.getParameter("city_num"));
		System.out.println(city_num);
		ArrayList<TastyVo> list = service.getTasty(city_num);
		request.setAttribute("list", list);
		
		HttpSession session = request.getSession();
		session.setAttribute("city_num", city_num);
		
		return "/tasty/list.jsp";
	}

}
