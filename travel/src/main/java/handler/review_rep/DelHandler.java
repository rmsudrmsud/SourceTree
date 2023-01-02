package handler.review_rep;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import review_rep.ReviewRepService;
import review_rep.ReviewRepVo;

public class DelHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int review_rep_num = Integer.parseInt(request.getParameter("review_rep_num"));
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		
		ReviewRepService service = new ReviewRepService();
		
		service.delReviewRep(review_rep_num);
		
		return "redirect:/review/detail.do?review_num="+review_num;
	}

}
