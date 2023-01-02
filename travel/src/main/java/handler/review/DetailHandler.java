package handler.review;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import review.ReviewService;
import review.ReviewVo;
import review_rep.ReviewRepService;
import review_rep.ReviewRepVo;

public class DetailHandler implements Handler {

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
		
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		
		
		ReviewVo vo=(new ReviewService().getByNum(review_num));
		
		ReviewRepService rservice = new ReviewRepService();
		vo.setReps(rservice.getAll(review_num));
		
		request.setAttribute("vo", vo);
		
		
		return "/review/detail.jsp";
	}

}
