package handler.together;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.Handler;
import together.TogetherService;
import together.TogetherVo;

public class TogetherGetAll implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		TogetherService service = new TogetherService();
		int city_num = Integer.parseInt(request.getParameter("city_num"));
		
		ArrayList<TogetherVo> list = service.getByTcNum(city_num);
		request.setAttribute("list", list);
		
	      HttpSession session = request.getSession();
	      session.setAttribute("city_num", city_num);
	      
		return "/together/list.jsp";
	}

}
