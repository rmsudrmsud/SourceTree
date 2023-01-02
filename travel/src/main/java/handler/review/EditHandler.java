package handler.review;

import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import review.ReviewService;
import review.ReviewVo;

public class EditHandler implements Handler {

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
		int city_num=Integer.parseInt(request.getParameter("city_num"));
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		ReviewService service = new ReviewService();
		service.editReview(new ReviewVo(review_num, 0, null, title, content, null, null));
		
		return "redirect:/review/getall.do?city_num="+city_num;
	}

}
