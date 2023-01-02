package handler.review;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.Handler;
import review.ReviewService;
import review.ReviewVo;

public class ListHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		int city_num = Integer.parseInt(request.getParameter("city_num"));
	 ReviewService service = new ReviewService();
	 ArrayList<ReviewVo> list = new ArrayList<>();
	 list = service.getAll(city_num);
	 
	 HttpSession session = request.getSession();
     session.setAttribute("city_num", city_num);
	 
	 request.setAttribute("list", list);
	 
	 return "/review/list.jsp";
	}

}
