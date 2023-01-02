package handler.tasty;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tasty.TastyService;
import Tasty.TastyVo;
import handler.Handler;

public class TastyListByTitle implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int city_num = Integer.parseInt(request.getParameter("city_num"));
		String title = request.getParameter("title");
		ArrayList<TastyVo> list = (new TastyService().getByTitle(city_num, title));
		request.setAttribute("list", list);
		return "/tasty/list.jsp";
	}

}
