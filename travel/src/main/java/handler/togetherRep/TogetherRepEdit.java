package handler.togetherRep;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import handler.Handler;
import togetherRep.TogetherRepService;
import togetherRep.TogetherRepVo;

public class TogetherRepEdit implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("edit handler");
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		int travel_rep_num = Integer.parseInt(request.getParameter("travel_rep_num"));
		String content = request.getParameter("content");
		System.out.println(travel_rep_num + "번호");
		
		TogetherRepService service = new TogetherRepService();
		service.editTravelRep(new TogetherRepVo(travel_rep_num,0,"",content,null));
		
		TogetherRepVo r = service.get(travel_rep_num);
		JSONObject obj = new JSONObject();
		obj.put("travel_rep_num",r.getTravel_rep_num());
		obj.put("travel_num", r.getTravel_num());
		obj.put("id", r.getId());
		obj.put("content", r.getContent());
		obj.put("date", r.getDate().toString());
		
		String txt = obj.toJSONString();
		
		
		return "responsebody/"+txt;
		
	}

}
