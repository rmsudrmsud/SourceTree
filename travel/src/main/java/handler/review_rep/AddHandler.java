package handler.review_rep;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import handler.Handler;
import review_rep.ReviewRepService;
import review_rep.ReviewRepVo;

public class AddHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		
		ReviewRepService service = new ReviewRepService();
		service.addReviewRep(new ReviewRepVo(0, review_num, id, content, null));
		
		
		ArrayList<ReviewRepVo> list = service.getAll(review_num);
		
		JSONArray arr = new JSONArray();
		
		for(ReviewRepVo r:list) {
			JSONObject obj = new JSONObject();
			
			obj.put("review_num",r.getReview_num() );
			obj.put("review_rep_num",r.getReview_rep_num() );
			obj.put("id",r.getId() );
			obj.put("content",r.getContent() );
			obj.put("date",r.getDate().toString());
			arr.add(obj);
			
		}
		String txt = arr.toJSONString();
		System.out.println(txt);
		return "responsebody/"+txt;
	}

}
