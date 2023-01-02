package handler.review_rep;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import handler.Handler;
import review_rep.ReviewRepService;
import review_rep.ReviewRepVo;

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
		
		int review_rep_num = Integer.parseInt(request.getParameter("review_rep_num"));
		String content = request.getParameter("content");
		
		ReviewRepService service = new ReviewRepService();
		service.editReviewRep(new ReviewRepVo(review_rep_num,0,"",content,null));
		ReviewRepVo r = service.getByNum(review_rep_num);
		
		JSONObject obj = new JSONObject();
		obj.put("review_rep_num",r.getReview_rep_num());
		obj.put("review_num", r.getReview_num());
		obj.put("id", r.getId());
		obj.put("content", r.getContent());
		obj.put("date", r.getDate().toString());
		
		String txt = obj.toJSONString();
		
		return "responsebody/"+txt;
	}

}
