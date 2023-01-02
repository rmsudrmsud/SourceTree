package handler.togetherRep;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import handler.Handler;
import togetherRep.TogetherRepService;
import togetherRep.TogetherRepVo;

public class TogetherRepAdd implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	  
	     
	     try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
			

		int travel_num = Integer.parseInt(request.getParameter("travel_num"));
		String id = request.getParameter("id");
		String content = request.getParameter("content");
	
		
		TogetherRepService service = new TogetherRepService();
		service.addTravelRep(new TogetherRepVo(0, travel_num , id, content, null));
		
	    ArrayList<TogetherRepVo> list = service.getNum(travel_num);	
		
		JSONArray arr = new JSONArray();
		
		for(TogetherRepVo r:list) {
			JSONObject obj = new JSONObject();
			obj.put("travel_rep_num", r.getTravel_rep_num());
			obj.put("travel_num", r.getTravel_num());
			obj.put("id", r.getId());
			obj.put("content", r.getContent());
			obj.put("date", r.getDate().toString());
			arr.add(obj);
		}
		
		String txt = arr.toJSONString();
		

		return "responsebody/"+txt;
	}

}
