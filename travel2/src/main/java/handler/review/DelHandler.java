package handler.review;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import review.ReviewService;
import review.ReviewVo;

public class DelHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("review_num"));
		int city_num = Integer.parseInt(request.getParameter("city_num"));
		ReviewService service = new ReviewService();
		ReviewVo vo=service.getByNum(num);
		File f = new File("/Users/choigeunhyeong/Documents/Kosta/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/webapps/img"+vo.getImg_path());
		f.delete();
		service.delReview(num);
		return "redirect:/review/getall.do?city_num="+city_num;
		
	}

}
