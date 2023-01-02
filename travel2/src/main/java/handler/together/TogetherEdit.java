package handler.together;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import together.TogetherService;
import together.TogetherVo;

public class TogetherEdit implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	    int travel_num = Integer.parseInt(request.getParameter("travel_num"));
	    int city_num = Integer.parseInt(request.getParameter("city_num"));
	    String title = request.getParameter("title");
	    String Content = request.getParameter("content");
	    int ppl = Integer.parseInt(request.getParameter("ppl"));
	    
	    TogetherService service = new TogetherService();
	    service.editTravel(new TogetherVo (travel_num, city_num, "", title, Content, ppl, null));
	    
		return "redirect:/together/getall.do?city_num="+city_num;
	}

}
