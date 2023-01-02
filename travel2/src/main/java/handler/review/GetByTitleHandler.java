package handler.review;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import review.ReviewService;
import review.ReviewVo;

public class GetByTitleHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		int city_num = Integer.parseInt(request.getParameter("city_num"));
		ReviewService service = new ReviewService();
		ArrayList<ReviewVo> list=service.getByTitle(title, city_num);
        request.setAttribute("list", list);
        return "/review/list.jsp";
		
	}

}
