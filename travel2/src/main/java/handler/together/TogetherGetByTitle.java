package handler.together;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import together.TogetherService;
import together.TogetherVo;

public class TogetherGetByTitle implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String title = request.getParameter("title");
		int city_num = Integer.parseInt(request.getParameter("city_num"));
		ArrayList<TogetherVo> list = (new TogetherService().getByTitle(title,city_num));
		request.setAttribute("list", list);
		return "/together/list.jsp";
	}

}
